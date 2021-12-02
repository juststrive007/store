package cn.study.store.util;


import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileCopy {
    public void cpyTest()  {
        File dst = new File("E:\\test");
        File  configFile;
        try {
            //获取类路径下的指定文件流
            ClassPathResource cpr = new ClassPathResource("static/web");
            System.out.println(cpr.getFilename());

            configFile = cpr.getFile();
            FileUtils.copyDirectory(configFile,dst);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
