package com.pichkur.javaCourse.document;

import com.pichkur.javaCourse.model.CountryEntity;
import com.pichkur.javaCourse.model.DocTypeEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DocumentRestTest {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://localhost:8888/api/docs";

    @Test
    public void shouldReturnListOfCounties() {
        ResponseEntity<DocTypeEntity[]> countries = restTemplate.getForEntity(url, DocTypeEntity[].class);
        Assert.assertEquals(countries.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(countries.getBody().length, 1);
        Assert.assertEquals(countries.getBody()[0].getCode(), "21");
        Assert.assertEquals(countries.getBody()[0].getName(), "Паспорт гражданина РФ");
    }
}
