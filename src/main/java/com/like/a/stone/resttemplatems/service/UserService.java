package com.like.a.stone.resttemplatems.service;

import com.like.a.stone.resttemplatems.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  @Value("${spring.external.service.base-url}")
  private String basePath;

  private final RestTemplate restTemplate;

  public List<UserDTO> getUsers() {
    UserDTO[] response = restTemplate.getForObject(basePath+"/users", UserDTO[].class);
    return Arrays.asList(response);
  }

  public UserDTO saveUser(UserDTO user) {
    return restTemplate.postForObject(basePath + "/users", user, UserDTO.class);
  }

  public void updateUser(UserDTO user, Integer id) {
    restTemplate.put(basePath + "/users/" + id, user);
  }

  public void deleteUser(Integer id) {
    restTemplate.delete(basePath + "/users/" + id);
  }

  public UserDTO getUser(Integer id) {
    return restTemplate.getForObject(basePath + "/users/"+ id, UserDTO.class);
  }
}
