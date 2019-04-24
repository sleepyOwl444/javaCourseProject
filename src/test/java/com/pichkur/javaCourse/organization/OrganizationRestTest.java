package com.pichkur.javaCourse.organization;

import com.pichkur.javaCourse.model.OrganizationEntity;
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
public class OrganizationRestTest {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String url = "http://localhost:8888/api/organization";

    @Test
    public void shouldReturnListOfOrganizations() {
        ResponseEntity<OrganizationEntity[]> organizations = restTemplate.getForEntity(url + "/list", OrganizationEntity[].class);
        Assert.assertEquals(organizations.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(organizations.getBody().length, 3);
        Assert.assertEquals(organizations.getBody()[2].getName(), "ВТБ");
    }

    @Test
    public void shouldReturnOrganizationById() {
        ResponseEntity<OrganizationEntity> organization = restTemplate.getForEntity(url + "/{id}", OrganizationEntity.class, 1);
        Assert.assertEquals(organization.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(organization.getBody().getName(), "Яндекс");
    }

    @Test
    public void shouldUpdateOrganizationAndReturnSuccess() {
        HttpEntity<OrganizationEntity> request = new HttpEntity<>(new OrganizationEntity());
        ResponseEntity<String> response = restTemplate.postForEntity(url + "/update", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }

    @Test
    public void shouldSaveOrganizationAndReturnSuccess() {
        HttpEntity<OrganizationEntity> request = new HttpEntity<>(new OrganizationEntity());
        ResponseEntity<String> response = restTemplate.postForEntity(url + "/save", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "success");
    }
}

