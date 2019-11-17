package com.jowl.feign.clients;

import com.jowl.feign.models.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "user-client", url = "http://localhost:8080/users")
public interface UserClient {

    @RequestLine("GET /user/email/{email}")
    User findByEmail(@Param("email") String email);

    @RequestLine("GET /")
    List<User> findAll();

    @RequestLine("POST /user")
    @Headers("Content-Type: application/json")
    User create(User user);

    @RequestLine("GET /user/{id}")
    User findById(@Param("id") long id);
}
