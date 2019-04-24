package com.pichkur.javaCourse.controller;

import com.pichkur.javaCourse.interfaces.OfficeService;

import com.pichkur.javaCourse.model.OfficeEntity;
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
    public List<OfficeEntity> getOffices() {

        return officeService.getOffices();
    }

    /**
     * Получает запись о конкретном офисе по id
     * @param id офиса, который хотим получить
     * @return запись об офисе
     */
    @GetMapping(value = "/{id}")
    public OfficeEntity getOfficeById(@PathVariable("id") Long id) {

        return officeService.getOfficeById(id);
    }

    /**
     * Обновляет запись об офисе
     * @param office обновленный вариант офиса
     * @return сообщение об успехе или неуспехе обновления
     */
    @PostMapping(value = "/update")
    public String updateOffice(@RequestBody OfficeEntity office) {

        return officeService.updateOffice(office);
    }

    /**
     * Сохраняет новый офис
     * @param office, который хотим сохранить
     * @return сообщение об успехе или неуспехе сохранения
     */
    @PostMapping(value = "/save")
    public String saveOffice(@RequestBody OfficeEntity office) {

        return officeService.saveOffice(office);
    }

}
