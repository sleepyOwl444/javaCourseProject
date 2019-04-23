package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.DocTypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DocumentTypeService {

    List<DocTypeEntity> getDocumentTypes();
}
