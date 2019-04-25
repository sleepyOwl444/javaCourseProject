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

    /**
     * Получаем типы документов из справочника
     * @return типы документов
     */
    @Override
    public List<DocTypeEntity> getDocumentTypes() {
        List<DocTypeEntity> docTypes = new ArrayList<>();
        List<DocEntity> docs = new ArrayList<>();
        docTypes.add(new DocTypeEntity(Long.valueOf(1), Long.valueOf(0), "21", "Паспорт гражданина РФ", docs));
        return docTypes;
    }
}
