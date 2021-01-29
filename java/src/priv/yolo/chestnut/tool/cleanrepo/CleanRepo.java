package priv.yolo.chestnut.tool.cleanrepo;

import java.io.File;
import java.io.FileFilter;

public class CleanRepo {

    public static void main(String[] args) {
        String filePath = "";
        clean(filePath);
    }

    private static void clean(String filePath) {
        // 是否含有子文件夹
        boolean isContainsDirectory = false;
        // 是否有以".pom"结尾的文件
        boolean haveFileEndsWithPom = false;
        // 是否有以".jar"结尾的文件
        boolean haveFileEndsWithJar = false;

        File currentFile = new File(filePath);
        if (currentFile.exists()) {
            // 统计当前文件对象的下一层级对象有哪些（不包含隐藏文件）
            File[] sonFiles = currentFile.listFiles(new HiddenFileFilter());
            if (isEmptyFloat(sonFiles)) {
                if (currentFile.delete())
                    System.out.println("删除：" + currentFile.getAbsolutePath());
            } else {
                for (File file : sonFiles) {
                    if (file.isDirectory()) {
                        clean(file.getAbsolutePath());
                        // 每次迭代完成后统计下当前文件对象下一层级对象是否还存在文件夹
                        File[] directories = currentFile.listFiles(new FolderFilter());
                        isContainsDirectory = !isEmptyFloat(directories);
                    }
                    if (file.isFile()) {
                        if (file.getName().endsWith(".pom")) haveFileEndsWithPom = true;
                        if (file.getName().endsWith(".jar")) haveFileEndsWithJar = true;
                        if (file.getName().endsWith(".lastUpdated")) {
                            if (file.delete())
                                System.out.println("删除：" + file.getAbsolutePath());
                        }
                    }
                }

                // 当且仅当本文件对象下一层级不包含文件夹，且不包含以.pom或者.jar结尾的文件，进入删除操作
                if (!isContainsDirectory && !haveFileEndsWithJar && !haveFileEndsWithPom) {
                    File[] delFiles = currentFile.listFiles();
                    if (!isEmptyFloat(delFiles)) {
                        for (File delSonF : delFiles) {
                            if (delSonF.delete())
                                System.out.println("删除：" + delSonF.getAbsolutePath());
                        }
                    }
                    if (currentFile.delete())
                        System.out.println("删除：" + currentFile.getAbsolutePath());
                }

            }
        } else {
            System.out.println("输入的文件路径有误！");
        }

    }

    // 判断是否是空文件夹
    private static boolean isEmptyFloat(File[] files) {
        return files == null || files.length == 0;
    }

}

// 统计时候不统计隐藏文件
class HiddenFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        return !file.isHidden();
    }

}

// 仅统计文件夹
class FolderFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        return file.isDirectory();
    }

}
