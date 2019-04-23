package com.pichkur.javaCourse.service;

import com.pichkur.javaCourse.interfaces.DocumentTypeService;
import com.pichkur.javaCourse.model.DocEntity;
import com.pichkur.javaCourse.model.DocTypeEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Override
    public List<DocTypeEntity> getDocumentTypes() {
        List<DocTypeEntity> docTypes = new ArrayList<>();
        docTypes.add(new DocTypeEntity());
        return docTypes;
    }
}
