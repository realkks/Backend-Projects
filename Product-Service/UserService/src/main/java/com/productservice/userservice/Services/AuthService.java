package com.productservice.userservice.Services;

import com.productservice.userservice.Exceptions.UserAlreadyExistsException;
import com.productservice.userservice.Exceptions.UserNotFoundException;
import com.productservice.userservice.Exceptions.WrongPasswordException;
import com.productservice.userservice.Models.Session;
import com.productservice.userservice.Models.User;
import com.productservice.userservice.Repository.SessionRepo;
import com.productservice.userservice.Repository.UserRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.swing.text.html.Option;
import java.util.*;

@Service
public class AuthService {
    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;          // Using bcrypt to encrypt password

    private SecretKey key = Jwts.SIG.HS256.key().build();   // Creating secret key object for jwt token
    private SessionRepo sessionRepo;



    public AuthService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder,SessionRepo sessionRepo) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.sessionRepo = sessionRepo;
    }

    public boolean signUp(String email,String password) throws UserAlreadyExistsException {
        if (userRepo.findByEmail(email).isPresent()){
            throw new UserAlreadyExistsException("User with email: "+email+" already exists");
        }
        // Adding new user in user repository
        else{
            User user = new User();
            user.setEmail(email);
            // Encoding password before adding to repository
            user.setPassword(bCryptPasswordEncoder.encode(password));
            userRepo.save(user);
            return true;
        }

    }

    public String login(String email,String password) throws UserNotFoundException,WrongPasswordException {
        Optional<User> userOptional = userRepo.findByEmail(email);
            if (userOptional.isEmpty()){
                throw new UserNotFoundException("User with email: "+email+" not found");
            }
            boolean matches = bCryptPasswordEncoder.matches(password,userOptional.get().getPassword());
            if(matches){
                String token= createJwtToken(userOptional.get().getId()
                        ,new ArrayList<>()
                        ,userOptional.get().getEmail());
                Session session = new Session();
                session.setToken(token);
                session.setUser(userOptional.get());
                session.setExpirydate(new Date(System.currentTimeMillis()+ 1000L * 60 * 60 * 24 * 30));
                sessionRepo.save(session);
                return token;
            }else{
                throw new WrongPasswordException("Incorrect password");
            }
        }

        public boolean validateToken(String token) {
            try {
                Jws<Claims> claims = Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(token);
                Date expiredAt = claims.getBody().getExpiration();
                String email = claims.getBody().get("email", String.class);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private String createJwtToken(Long user_id, List<String> roles, String email){
            Map<String, Object> dataInJwt = new HashMap<>();
            dataInJwt.put("user_id",user_id);
            dataInJwt.put("roles",roles);
            dataInJwt.put("email",email);

            String token = Jwts.builder()
                    .claims(dataInJwt)     // Adding data to jwt token
                    .issuedAt(new Date(System.currentTimeMillis()))  // Setting issue date
                    // System.currentTimeMillis() will return currenttime in milliseconds
                    // 1000L * 60 * 60 * 24 - It represnts 1 day in milliseconds
                    .expiration(new Date(System.currentTimeMillis()+ 1000L * 60 * 60 * 24 * 30)) // Setting expiration date
                    .signWith(key)  // Signing token with secret key
                    .compact();     // Compacting token to string.com

            return token;
        }

}
