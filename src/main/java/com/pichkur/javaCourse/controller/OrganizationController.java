package com.pichkur.javaCourse.controller;


import com.pichkur.javaCourse.interfaces.OrganizationService;
import com.pichkur.javaCourse.model.view.OrganizationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получает список организаций
     * @return список организаций
     */
    @GetMapping("/list")
    public List<OrganizationView> getOrganizations(@RequestParam("name") String name,
                                                   @RequestParam(name = "inn", required = false) String inn,
                                                   @RequestParam(name = "isActive", required = false) Boolean isActive){
        return organizationService.getOrganizations(name, inn, isActive);
    }

    /**
     * Получает запись о конкретной организации по id
     * @param id организации, которую хотим получить
     * @return запись об организации
     */
    @GetMapping("/{id}")
    public OrganizationView getOrganizationById(@PathVariable("id") Long id) {
        return organizationService.getOrganizationById(id);
    }
//
//    /**
//     * Обновляет запись об организации
//     * @param organization обновленный вариант организации
//     * @return сообщение об успехе или неуспехе обновления
//     */
//    @PostMapping("/update")
//    public String updateOrganization(@RequestBody OrganizationEntity organization) {
//        return organizationService.updateOrganization(organization);
//    }
//
//    /**
//     * Сохраняет новую организацию
//     * @param organization, которую хотим сохранить
//     * @return сообщение об успехе или неуспехе сохранения
//     */
//    @PostMapping("/save")
//    public String saveOrganization(@RequestBody OrganizationEntity organization) {
//        return organizationService.saveOrganization(organization);
//    }


}
