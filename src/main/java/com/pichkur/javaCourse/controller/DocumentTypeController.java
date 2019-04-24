package com.pichkur.javaCourse.controller;


import com.pichkur.javaCourse.interfaces.DocumentTypeService;
import com.pichkur.javaCourse.model.DocTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @GetMapping
    public List<DocTypeEntity> getDocumentTypes() {
        return documentTypeService.getDocumentTypes();
    }
}
