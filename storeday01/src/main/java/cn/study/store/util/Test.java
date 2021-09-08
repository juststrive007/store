package cn.study.store.util;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;

@Component
public class Test {
    static {
        try {
            copytReeourcesFileToTemp("classpath:static/web/", "*", "E:\\test1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copytReeourcesFileToTemp(String fileRoot, String regExpStr, String tempParent) throws Exception {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = (Resource[]) resolver.getResources(fileRoot + regExpStr);
            for (Resource resource : resources) {
                File newFile = new File(tempParent, resource.getFilename());
                if (newFile.exists()) {
                    newFile.delete();
                }
                InputStream stream = null;
                try {
                    stream = resource.getInputStream();
                } catch (Exception e1) {
                    System.out.println(resource.getFilename() + "是文件夹");
                }
                if (stream == null) {
                    System.out.println("创建文件夹" + resource.getFilename());
                    newFile.mkdirs();
                    Resource[] children = (Resource[]) resolver.getResources(fileRoot + resource.getFilename() + "/" + regExpStr);
                    for (Resource child : children) {
                        copytReeourcesFileToTemp(fileRoot + resource.getFilename() + "/", regExpStr, tempParent + "\\" + resource.getFilename());
                    }
                } else {
                    if (!newFile.getParentFile().exists()) {
                        newFile.getParentFile().mkdir();
                    }
                    FileUtils.copyInputStreamToFile(stream, newFile);
                }
            }
        } catch (Exception e) {
            System.out.println("复制文件出现错误" + e.getMessage());
            throw e;
        }

    }
}
