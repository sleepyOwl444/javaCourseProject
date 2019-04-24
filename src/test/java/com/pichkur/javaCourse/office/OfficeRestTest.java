package com.pichkur.javaCourse.office;


import com.pichkur.javaCourse.model.OfficeEntity;
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
public class OfficeRestTest {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://localhost:8888/api/office";

    @Test
    public void shouldReturnListOfOffices() {
        ResponseEntity<OfficeEntity[]> offices = restTemplate.getForEntity(url + "/list", OfficeEntity[].class);
        Assert.assertEquals(offices.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(offices.getBody().length, 2);
        Assert.assertEquals(offices.getBody()[1].getName(), "Яндекс Главный офис");
    }

    @Test
    public void shouldReturnOfficeById() {
        ResponseEntity<OfficeEntity> office = restTemplate.getForEntity(url + "/{id}", OfficeEntity.class, 1);
        Assert.assertEquals(office.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(office.getBody().getName(), "Сбербанк Главный офис");
    }

    @Test
    public void shouldUpdateOfficeAndReturnSuccess() {
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(url + "/update", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }

    @Test
    public void shouldSaveOfficeAndReturnSuccess() {
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(url + "/save", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }
}
