package com.example.snakeyaml.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class CompressFile {
    /**
     * 解压文件到指定目录
     */
    @SuppressWarnings("rawtypes")
    public static void unZipFiles(String zipPath, String descDir) {
        File zipFile = new File(zipPath);
        File pathFile = new File(descDir);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        // 解决zip文件中有中文目录或者中文文件
        ZipFile zip = null;
        try {
            zip = new ZipFile(zipFile, Charset.forName("GBK"));

            for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
                // 输出文件路径信息
                FileOutputStream out = null;
                InputStream in = null;
                try {
                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    String zipEntryName = entry.getName();
                    in = zip.getInputStream(entry);
                    String outPath = descDir + File.separator + zipEntryName;
                    // 判断路径是否存在,不存在则创建文件路径
                    // File file = new File(outPath.substring(0, outPath.lastIndexOf("/")));
                    File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                    if (new File(outPath).isDirectory()) {
                        continue;
                    }

                    out = new FileOutputStream(outPath);
                    byte[] buf1 = new byte[1024];
                    int len;
                    while ((len = in.read(buf1)) > 0) {
                        out.write(buf1, 0, len);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        CompressFile.unZipFiles("G:\\javatest\\slice.zip","G:\\javatest");
    }
}
