package com.pichkur.javaCourse.interfaces;

import com.pichkur.javaCourse.model.view.AnswerView;
import com.pichkur.javaCourse.model.view.OfficeView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;


@Validated
public interface OfficeService {

    List<OfficeView> getOffices(Long orgId, String name, String phone, Boolean isActive);

    OfficeView getOfficeById(Long id);

//    String updateOffice(OfficeEntity office);

    AnswerView saveOffice(@Valid OfficeView office);

}
