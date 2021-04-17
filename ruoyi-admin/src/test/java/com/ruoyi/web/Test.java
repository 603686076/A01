package com.ruoyi.web;

import com.ruoyi.system.domain.RecNotesCon;
import com.ruoyi.web.controller.RecNotesConController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestA {

    private RecNotesConController recNotesConController;
    private RecNotesCon recNotesCon = new RecNotesCon();


    @Test
    void test() {
        recNotesCon.setUserId((long)106);
        System.out.println(recNotesConController.list(recNotesCon));
    }

}
