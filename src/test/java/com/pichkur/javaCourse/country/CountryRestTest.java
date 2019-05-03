package com.pichkur.javaCourse.country;


import com.pichkur.javaCourse.model.CountryEntity;
import com.pichkur.javaCourse.model.view.CountryView;
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
public class CountryRestTest {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://localhost:8888/api/countries";

    @Test
    public void shouldReturnListOfCounties() {
        ResponseEntity<CountryView[]> countries = restTemplate.getForEntity(url, CountryView[].class);
        Assert.assertEquals(countries.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(countries.getBody().length, 2);
        Assert.assertEquals(countries.getBody()[1].getCode(), "643");
        Assert.assertEquals(countries.getBody()[1].getName(), "Российская Федерация");
    }

}
