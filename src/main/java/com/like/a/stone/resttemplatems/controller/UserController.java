package com.like.a.stone.resttemplatems.controller;

import com.like.a.stone.resttemplatems.dto.UserDTO;
import com.like.a.stone.resttemplatems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @GetMapping
  public ResponseEntity<List<UserDTO>> getUsers() {
    return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDto) {
    UserDTO user = service.saveUser(userDto);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> updateUser(@RequestBody UserDTO userRequest, @PathVariable("id") Integer id) {
    service.updateUser(userRequest, id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
    service.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
    UserDTO user = service.getUser(id);
    return ResponseEntity.ok().body(user);
  }
}
