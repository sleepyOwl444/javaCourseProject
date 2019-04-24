package com.pichkur.javaCourse.user;


import com.pichkur.javaCourse.model.UserEntity;
import com.pichkur.javaCourse.responce.SimpleResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserRestTest {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://localhost:8888";

    @Test
    public void shouldReturnListOfUsers() {

        ResponseEntity<UserEntity[]> users = restTemplate.getForEntity(url + "/api/user/list", UserEntity[].class);
        Assert.assertEquals(users.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void shouldReturnUser() {

        ResponseEntity<UserEntity> user = restTemplate.getForEntity(url + "/api/user/{id}", UserEntity.class, 1);
        UserEntity entity = user.getBody();
        Assert.assertEquals(user.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(entity.getFirst_name(), "Иван");
    }

    @Test
    public void shouldUpdateUserAndReturnSuccess() {
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(url + "api/user/update", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }


    @Test
    public void shouldSaveUserAndReturnSuccess() {
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(url + "/api/user/save", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }
}
