package com.michell_bento.cadastrousuario.api;

import com.michell_bento.cadastrousuario.api.request.UserRequestDTO;
import com.michell_bento.cadastrousuario.api.response.UserResponseDTO;
import com.michell_bento.cadastrousuario.business.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.saveUser(userRequestDTO));
    }

    @GetMapping()
    public  ResponseEntity<UserResponseDTO> findUserByEmail(@RequestParam ("email") String email){
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @DeleteMapping()
    public  ResponseEntity<Void> deleteUser(@RequestParam ("email") String email){
        userService.deleteUser(email);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }
}
