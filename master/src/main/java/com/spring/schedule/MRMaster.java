package com.spring.schedule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MRMaster {

    private static Master master;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.print("fail to start MRMaster!");
        }
        //根据传入的带有通配符的文件名称获取需要的文件
        List<String> files = getFiles(args[0]);
        int nReduce = Integer.valueOf(args[1]);
        try {
            master = new Master(files.toArray(new String[0]), nReduce);
            while (!master.done()) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getFiles(String root) {
        List<String> files = new ArrayList<>();

        if (root == null || root == "") {
            return files;
        }

        String path = root.substring(0, root.lastIndexOf("/"));

        String pattern = root.substring(root.lastIndexOf("/"), root.length());

        File rootPath = new File(path);
        if (!rootPath.isDirectory()) {
            return files;
        }

        File[] fileList = rootPath.listFiles();

        for (File file : fileList) {
            if (Pattern.matches(pattern, file.getName())) {
                files.add(file.getPath());
            }
        }

        return files;
    }
}
