package com.example.snakeyaml.utils;

import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

public class ZtZIpTest {
    public static void main(String[] args) {
//        ZipUtil.unpack();
//        ZipUtil.pack();

        //ZipUtil.pack(new File("F:\\ztTest"),new File("F:\\ztTest.zip"));
        ZipUtil.unpack(new File("F:\\ztTest.zip"),new File("F:\\ztTestOutFile"));

    }
}
