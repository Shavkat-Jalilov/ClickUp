package com.example.clickup.Controller;

import com.example.clickup.DTO.ApiResponse;
import com.example.clickup.DTO.LoginDTO;
import com.example.clickup.DTO.UserDTO;
import com.example.clickup.Entity.Users;
import com.example.clickup.Service.UserService;
import com.example.clickup.WebToken.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenGenerator tokenGenerator;

    @PostMapping("/userCreat")
    public HttpEntity<?> userCreat(@RequestBody UserDTO userDTO){
        ApiResponse apiResponse = userService.addUser(userDTO);
        return ResponseEntity.status(apiResponse.isHolat()?200:409).body(apiResponse.getMessage());
    }

    @PostMapping("/login")
        public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
          try{
              Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                      loginDTO.getUsername(),
                      loginDTO.getPassword()
              ));
              Users users =(Users) authenticate.getPrincipal();
              String token=tokenGenerator.UsernameTekshirish(users.getUsername());
              return ResponseEntity.ok(token);
          }catch (Exception e){
              return ResponseEntity.ok(new ApiResponse("Parol yoki login xato", false));
          }
        }

    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/readUsers")
    public HttpEntity<?> readUsers(){
        ApiResponse apiResponse = userService.readUser();
        return ResponseEntity.status(apiResponse.isHolat()?200:409).body(apiResponse.getMessage());
    }
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @DeleteMapping("/deleteUser/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
        ApiResponse apiResponse = userService.deleteUser(id);
        return ResponseEntity.status(apiResponse.isHolat()?200:409).body(apiResponse.getMessage());
    }


}
