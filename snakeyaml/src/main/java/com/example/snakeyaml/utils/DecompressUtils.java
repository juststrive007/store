package com.example.snakeyaml.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DecompressUtils {
    public static void decompress(String zipFile,String dstPath)throws IOException{
        File pathFile = new File(dstPath);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(zipFile);
        for(Enumeration entries = zip.entries(); entries.hasMoreElements();){
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = null;
            OutputStream out = null;
            try {
                in = zip.getInputStream(entry);
                String outPath = (dstPath+"/"+zipEntryName.replace("\\*","/"));
                //判断路径是否存在，不存在则创建文件路径
                File file = new File(outPath.substring(0,outPath.lastIndexOf('/')));
                if(!file.exists()){
                    file.mkdirs();
                }
                //判断文件全路径是否为文件夹，如果是上面已经上传，不需要解压
                if(new File(outPath).isDirectory()){
                    continue;
                }
                out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len=in.read(buf1))!=-1){
                    out.write(buf1,0,len);
                }
            }
            finally {
                if(null != in){
                    in.close();
                }
                if(null != out){
                    out.close();
                }
            }
        }
        zip.close();
    }
    public static void main(String[] args) throws IOException {
        DecompressUtils.decompress("src/main/resources/static/test1.zip","src/main/resources/static/test2");
    }
}
