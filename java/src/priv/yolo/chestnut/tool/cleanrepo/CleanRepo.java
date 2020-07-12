package priv.yolo.chestnut.tool.cleanrepo;

import java.io.File;
import java.io.FileFilter;

public class CleanRepo {

    public static void main(String[] args) {
        String filePath = "";
        clean(filePath);
    }

    private static void clean(String filePath) {
        // 是否含有子文件夹或文件
        boolean isContainsDirectoryOrFile = false;
        // 是否有以'.jar'结尾的文件
        boolean haveFileEndsWithJar = false;
        // 是否有以'.pom'结尾的文件
        boolean haveFileEndsWithPom = false;

        File file = new File(filePath);

        if (file.exists()) {
            File[] sonFiles = file.listFiles();

            // 空文件夹
            if (sonFiles == null || sonFiles.length == 0) {
                if (file.delete()) System.out.println("删除：" + file.getAbsolutePath());
            // 非空文件夹
            } else {
                // 遍历子文件夹或文件
                for (File sonF : sonFiles) {
                    // 是文件夹
                    if (sonF.isDirectory()) {
                        // 递归
                        clean(sonF.getAbsolutePath());
                        // 每一次递归结束，判断是否为空文件夹（隐藏文件不算数）
                        File[] checkSonFiles = file.listFiles(new NotHiddenFileFilter());
                        isContainsDirectoryOrFile = (checkSonFiles != null && checkSonFiles.length != 0);
                    }
                    // 是文件
                    if (sonF.isFile()) {
                        if (sonF.getName().endsWith(".pom")) haveFileEndsWithPom = true;
                        if (sonF.getName().endsWith(".jar")) haveFileEndsWithJar = true;
                        if (sonF.getName().endsWith(".lastUpdated")) {
                            if (sonF.delete()) System.out.println("删除：" + sonF.getAbsolutePath());
                        }
                    }
                }
                // 遍历结束，以下情况会做删除处理：
                // 1. 空文件夹 （haveFileEndsWithJar、haveFileEndsWithPom为默认值）
                // 2. 本文件下一层都是文件且不含有以'.jar'和'.pom'结尾的文件（isContainsDirectoryOrFile为默认值）
                if (!isContainsDirectoryOrFile && !haveFileEndsWithJar && !haveFileEndsWithPom) {
                    File[] delSonFiles = file.listFiles();

                    if (delSonFiles != null && delSonFiles.length != 0) {
                        for (File delSonF : delSonFiles) {
                            if (delSonF.delete()) System.out.println("删除：" + delSonF.getAbsolutePath());
                        }
                    }

                    if (file.delete()) System.out.println("删除：" + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("输入有误！");
        }
    }

}

class NotHiddenFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        return !file.isHidden();
    }

}
