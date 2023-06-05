package com.example.hospitalplanner.controllers;

import com.example.hospitalplanner.jpas.ConsultationJPA;
import com.example.hospitalplanner.jpas.UserJPA;
import com.example.hospitalplanner.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class    AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String first_name, @RequestParam String last_name, @RequestParam String email, @RequestParam String phone_number, @RequestParam String user_password) {
        if(userService.checkEmail(email) == false) {
            return new ResponseEntity<>("Invalid Email", HttpStatus.BAD_REQUEST);
        }

        if(userService.checkPassword(user_password) == false) {
            return new ResponseEntity<>("Invalid Password", HttpStatus.BAD_REQUEST);
        }

        userService.registerUser(first_name, last_name, email, phone_number, user_password);

        return new ResponseEntity<>("User has been registered succesfully!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String user_password) {
        if(userService.loginUser(email, user_password) == false) {
            return new ResponseEntity<>("User does not exist!", HttpStatus.BAD_REQUEST);
        }
        UserJPA user = userService.getUserByEmail(email);
        JSONObject response = new JSONObject();

        response.put("user_id", user.getUser_id());
        response.put("first_name", user.getFirst_name());
        response.put("last_name", user.getLast_name());
        response.put("email", user.getEmail());
        response.put("user_password", user.getUser_password());
        response.put("phone_number", user.getPhone_number());
        response.put("role", user.getRole());

        Map<String, Object> responseMap = response.toMap();

        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

}
