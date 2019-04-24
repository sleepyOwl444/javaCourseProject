package com.pichkur.javaCourse.controller;


import com.pichkur.javaCourse.interfaces.OrganizationService;
import com.pichkur.javaCourse.model.OrganizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/list")
    public List<OrganizationEntity> getOrganizations(){
        return organizationService.getOrganizations();
    }

    @GetMapping("/{id}")
    public OrganizationEntity getOrganizationById(@PathVariable("id") Long id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping("/update")
    public String updateOrganization(@RequestBody OrganizationEntity organization) {
        return organizationService.updateOrganization(organization);
    }

    @PostMapping("/save")
    public String saveOrganization(@RequestBody OrganizationEntity organization) {
        return organizationService.saveOrganization(organization);
    }


}
