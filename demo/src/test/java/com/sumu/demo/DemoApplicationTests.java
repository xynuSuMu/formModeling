package com.sumu.demo;

import com.sumu.form.service.FormService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    FormService formService;

    @Test
    void contextLoads() {
        formService.deleteFormTable("form_custom_verification");
    }

}
