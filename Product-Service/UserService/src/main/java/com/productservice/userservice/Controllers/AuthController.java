package com.productservice.userservice.Controllers;

import com.productservice.userservice.Dtos.*;
import com.productservice.userservice.Exceptions.UserAlreadyExistsException;
import com.productservice.userservice.Exceptions.UserNotFoundException;
import com.productservice.userservice.Exceptions.WrongPasswordException;
import com.productservice.userservice.Services.AuthService;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    AuthController(AuthService authService){
        this.authService = authService;
    }

    // Signup method that takes a SignUpRequestDto object as a parameter and returns a SignUpResponseDto object.
    // Recommended practice to use response entity instead of returning the object directly.
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto request) {
            SignUpResponseDto response = new SignUpResponseDto();
        try {
            if (authService.signUp(request.getEmail(), request.getPassword())) {
                response.setStatus(RequestStatus.SUCCESS);
            } else {
                response.setStatus(RequestStatus.FAILED);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        catch(Exception e){
            response.setStatus(RequestStatus.FAILED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //ResponseEntity is a spring class that represents an HTTP response, including headers, body, cookies
    // and status.
    // Login method that takes a LoginRequestDto object as a parameter and returns a ResponseEntity object
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login( @RequestBody LoginRequestDto request){
        try {
            String token = authService.login(request.getEmail(), request.getPassword());
            LoginResponseDto response = new LoginResponseDto();
            response.setStatus(RequestStatus.SUCCESS);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("AUTH_TOKEN", token);
            ResponseEntity<LoginResponseDto> responseEntity = new ResponseEntity<>(
                    response, headers, HttpStatus.OK
            );
            return responseEntity;
        }
        catch (Exception e){
            LoginResponseDto response = new LoginResponseDto();
            response.setStatus(RequestStatus.FAILED);
            return new ResponseEntity<>(response,null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestParam("token") String token){
        return authService.validateToken(token);
    }
}
