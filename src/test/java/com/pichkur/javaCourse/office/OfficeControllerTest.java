package com.pichkur.javaCourse.office;

import com.pichkur.javaCourse.controller.OfficeController;
import com.pichkur.javaCourse.interfaces.OfficeService;
import com.pichkur.javaCourse.model.OfficeEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OfficeControllerTest {

    @Mock
    private OfficeService officeService;

    @InjectMocks
    private OfficeController officeController = new OfficeController();


    @Test
    public void testGetOfficeByIdMethod() {
        OfficeEntity office = new OfficeEntity(Long.valueOf(1), Long.valueOf(0));
        when(officeService.getOfficeById(anyLong())).thenReturn(office);
        Assert.assertEquals(officeController.getOfficeById(anyLong()), office);
        verify(officeService).getOfficeById(anyLong());
    }
}
