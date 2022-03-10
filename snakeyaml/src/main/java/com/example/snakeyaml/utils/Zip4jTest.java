package com.example.snakeyaml.utils;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;

import java.io.File;

public class Zip4jTest {
    public static void main(String[] args) {
        try{
            zipFile();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void zipFile() throws ZipException {
        // 生成的压缩文件
        ZipFile zipFile = new ZipFile("F:\\ztTest.zip");
        ZipParameters parameters = new ZipParameters();
        // 压缩方式
        parameters.setCompressionMethod(CompressionMethod.DEFLATE);
        // 压缩级别
        parameters.setCompressionLevel(CompressionLevel.NORMAL);

        // 要打包的文件夹
        File currentFile = new File("F:\\ztTestOutFile");
        zipFile.addFolder(currentFile,parameters);
       File[] list = currentFile.listFiles();
        // 遍历test文件夹下所有的文件、文件夹
        for (File f : list) {
            if (f.isDirectory()) {
                zipFile.addFolder( f.getPath(), parameters);
            } else {
                zipFile.addFile(f, parameters);
            }
        }

    }
}
