package com.productservice.userservice.Controllers;

import com.productservice.userservice.Dtos.*;
import com.productservice.userservice.Services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public SignUpResponseDto signUp(SignUpRequestDto request){
        SignUpResponseDto response = new SignUpResponseDto();
        if (authService.signUp(request.getEmail(),request.getPassword())){
            response.setStatus(RequestStatus.SUCCESS);
        }
        else{
            response.setStatus(RequestStatus.FAILED);
        }
        return response;

    }

    //ResponseEntity is a spring class that represents an HTTP response, including headers, body, cookies
    // and status.
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto request){
        String token = authService.login(request.getEmail(), request.getPassword());
        LoginResponseDto response = new LoginResponseDto();
        response.setStatus(RequestStatus.SUCCESS);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("AUTH_TOKEN",token);
        ResponseEntity<LoginResponseDto> responseEntity = new ResponseEntity<>(
                response,headers , HttpStatus.OK
        );
        return null;

    }
}
