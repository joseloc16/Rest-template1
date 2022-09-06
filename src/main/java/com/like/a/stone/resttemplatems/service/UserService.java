package com.like.a.stone.resttemplatems.service;

import com.like.a.stone.resttemplatems.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final RestTemplate restTemplate;

  public List<UserDTO> getAll() {
    return null;
  }

  public UserDTO saveUser(UserDTO user) {
    return null;
  }

  public UserDTO updateUser(UserDTO user) {
    return null;
  }

  public void deleteUser(Integer id) {

  }

  public UserDTO getUser(Integer id) {
    return null;
  }
}
