package cn.study.store.service;

import cn.study.store.util.FileCopy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileCopyTest {
    @Autowired
    FileCopy fileCopy;
    @Autowired
    cn.study.store.util.Test test;

    @Test
    public void cpyTest(){
        fileCopy.cpyTest();
    }


    @Test
    public void tcpTest() throws Exception {
        test.copytReeourcesFileToTemp("classpath:static/bootstrap3/", "*", "E:\\test1");
    }
}
