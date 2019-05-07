package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.OfficeEntity;
import com.pichkur.javaCourse.model.view.AnswerView;
import com.pichkur.javaCourse.model.view.OfficeView;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OfficeService {

    List<OfficeView> getOffices(Long orgId, String name, String phone, Boolean isActive);

    OfficeView getOfficeById(Long id);

//    String updateOffice(OfficeEntity office);

    AnswerView saveOffice(OfficeView office);

}
