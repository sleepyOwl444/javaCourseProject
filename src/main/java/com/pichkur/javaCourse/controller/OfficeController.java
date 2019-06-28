package com.pichkur.javaCourse.controller;

import com.pichkur.javaCourse.interfaces.OfficeService;

import com.pichkur.javaCourse.model.view.AnswerView;
import com.pichkur.javaCourse.model.view.office.OfficeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/office")
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }


    /**
     * Получает список офисов
     * @return список офисов
     */
    @GetMapping(value = "/list")
    public List<OfficeView> getOffices(@RequestParam("orgId") Long orgId,
                                       @RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "phone", required = false) String phone,
                                       @RequestParam(name = "isActive", required = false) Boolean isActive
    ) {
        return officeService.getOffices(orgId, name, phone, isActive);
    }

    /**
     * Получает запись о конкретном офисе по id
     * @param id офиса, который хотим получить
     * @return запись об офисе
     */
    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable("id") Long id) {

        return officeService.getOfficeById(id);
    }

    /**
     * Обновляет запись об офисе
     * @param office обновленный вариант офиса
     * @return сообщение об успехе или неуспехе обновления
     */
//    @PostMapping(value = "/update")
//    public String updateOffice(@RequestBody OfficeEntity office) {
//
//        return officeService.updateOffice(office);
//    }

    /**
     * Сохраняет новый офис
     * @param office, который хотим сохранить
     * @return сообщение об успехе или неуспехе сохранения
     */
    @PostMapping(value = "/save")
    public AnswerView saveOffice(@RequestBody OfficeView office) {

        return officeService.saveOffice(office);
    }

}
