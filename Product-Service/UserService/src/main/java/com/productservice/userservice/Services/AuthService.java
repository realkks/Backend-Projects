package com.productservice.userservice.Services;

import com.productservice.userservice.Exceptions.UserAlreadyExistsException;
import com.productservice.userservice.Exceptions.UserNotFoundException;
import com.productservice.userservice.Exceptions.WrongPasswordException;
import com.productservice.userservice.Models.User;
import com.productservice.userservice.Repository.UserRepo;
import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class AuthService {
    private UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;          // Using bcrypt to encrypt password
    public AuthService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
                return "token";
            }else{
                throw new WrongPasswordException("Incorrect password");
            }
        }

        private String createJwtToken(Long user_id, List<String> roles, String email){
            Map<String, Object> dataInJwt = new HashMap<>();
            dataInJwt.put("user_id",user_id);
            dataInJwt.put("roles",roles);
            dataInJwt.put("email",email);

            Jwts.builder()
                    .claims(dataInJwt)     // Adding data to jwt token
                    .issuedAt(new Date(System.currentTimeMillis()))  // Setting issue date
                    // System.currentTimeMillis() will return currenttime in milliseconds
                    // 1000L * 60 * 60 * 24 - It represnts 1 day in milliseconds
                    .expiration(new Date(System.currentTimeMillis()+ 1000L * 60 * 60 * 24 * 30)); // Setting expiration date
            return null;
        }

}
