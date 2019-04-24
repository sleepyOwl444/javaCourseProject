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

    private final String url = "http://localhost:8888/api/user";

    @Test
    public void shouldReturnListOfUsers() {

        ResponseEntity<UserEntity[]> users = restTemplate.getForEntity(url + "/list", UserEntity[].class);
        Assert.assertEquals(users.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(users.getBody().length, 2);
        Assert.assertEquals(users.getBody()[1].getSecond_name(), "Ивочкин");
    }

    @Test
    public void shouldReturnUser() {

        ResponseEntity<UserEntity> user = restTemplate.getForEntity(url + "/{id}", UserEntity.class, 1);
        UserEntity entity = user.getBody();
        Assert.assertEquals(user.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(entity.getFirst_name(), "Иван");
    }

    @Test
    public void shouldUpdateUserAndReturnSuccess() {
        HttpEntity<UserEntity> request = new HttpEntity<>(new UserEntity());
        ResponseEntity<String> response = restTemplate.postForEntity(url + "/update", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }


    @Test
    public void shouldSaveUserAndReturnSuccess() {
        HttpEntity<UserEntity> request = new HttpEntity<>(new UserEntity());
        ResponseEntity<String> response = restTemplate.postForEntity(url + "/save", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }
}
