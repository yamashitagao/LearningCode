package learning.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @description 作用:批量修改文件夹或文件
 * 思路1:遍历所有文件文件夹
 * 获取路径存放入列表
 * 修改文件
 * 思路2:遍历所有文件文件夹
 * 判断复合条件的修改
 * <p>
 * 遍历文件夹：多级文件夹
 *
 * FILE_PATh                文件路径
 * DESTINATION_FILE_NAME    改文件名
 * NEW_FILE_NAME            新文件名
 * SUFFIX                   后缀名
 * C_SUFFIX                 是否改后缀名
 * ADD_DIR                  是否加文件夹
 *
 * <p>
 * <p>
 * DESTINATION_FILE_NAME:目标文件名
 * NEW_FILE_NAME:新文件名
 * @author:Alexius
 * @time: 22:40
 * @date: 2021/5/29
 */


public class RenameFile {
    String FILE_PATh;
    String DESTINATION_FILE_NAME;
    String NEW_FILE_NAME;
    String SUFFIX;
    List<File> resultIteration = new ArrayList<>(); //迭代结果集
    Boolean ADD_DIR = true;  //是否加目录
    Boolean C_SUFFIX = false;

    public RenameFile(String FILE_PATh, String DESTINATION_FILE_NAME, String NEW_FILE_NAME) {
        this.FILE_PATh = FILE_PATh;
        this.DESTINATION_FILE_NAME = DESTINATION_FILE_NAME;
        this.NEW_FILE_NAME = NEW_FILE_NAME;
    }

    /**
     * @param
     * @return List<String>
     * @throws
     * @description 使用for方法循环便利遍历
     * @author Alexius
     * @date 2021/5/30 0:02
     * @since
     */


    public List<String> FindFiles() {
        List<String> result = new ArrayList<>();
        List<File> directoryFile = new ArrayList<>();
        File resourceFile = new File(FILE_PATh);

        if (!resourceFile.exists()) {
            return null;
        }

        File[] files = resourceFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //如果路径存在文件或文件夹 而且是文件夹
            if (files[i].isDirectory()) {
                directoryFile.add(files[i]);
            }
            //如果路径存在文件或文件夹 而且符合要求 存入结果集
            if (files[i].getName().equals(DESTINATION_FILE_NAME)) {

                result.add(files[i].getPath());
            }
        }
        int len = directoryFile.size();
        for (int i = 0; i < len; i++) {
            File[] dirFiles = directoryFile.get(i).listFiles();
            if (!(dirFiles.length < 1)) {
                for (int j = 0; j < dirFiles.length; j++) {
                    //如果路径存在文件或文件夹 而且是文件夹
                    if (dirFiles[j].isDirectory()) {
                        directoryFile.add(dirFiles[j]);
                        len++;
                    }
                    //如果路径存在文件或文件夹 而且符合要求 存入结果集
                    if (dirFiles[j].getName().equals(DESTINATION_FILE_NAME)) {
                        result.add(dirFiles[j].getPath());
                    }
                }
            }

        }


        return result;
    }

    /**
     * @param
     * @return List<String>
     * @throws
     * @description 迭代方式循环遍历
     * @author Alexius
     * @date 2021/5/30 11:23
     * @since
     */
    public List<File> findFilesItIteration(List<File> directoryFiles, String RULE) {

        List<File> dirFiles = new ArrayList<>();
        if (directoryFiles.size() < 1) {
            return null;
        }
        for (int i = 0; i < directoryFiles.size(); i++) {
            if (directoryFiles.get(i).isDirectory()) {
                dirFiles.add(directoryFiles.get(i));
                //加文件夹 不用判断  不加文件夹 分开文件夹
                if (ADD_DIR) {
                    if (directoryFiles.get(i).getName().equals(DESTINATION_FILE_NAME)) {
                        resultIteration.add(directoryFiles.get(i));
                    }
                    if (isDestinationFile(directoryFiles.get(i).getName(), RULE)) {
                        resultIteration.add(directoryFiles.get(i));
                    }
                }
            } else {
                if (directoryFiles.get(i).getName().equals(DESTINATION_FILE_NAME)) {
                    resultIteration.add(directoryFiles.get(i));
                }
                if (isDestinationFile(directoryFiles.get(i).getName(), RULE)) {
                    resultIteration.add(directoryFiles.get(i));
                }
            }

        }
        for (int i = 0; i < dirFiles.size(); i++) {
            File[] files = dirFiles.get(i).listFiles();
            List<File> files1 = Arrays.asList(files);
            findFilesItIteration(files1, RULE);
        }

        return resultIteration;
    }


    /**
     * @param fileName 传入文件名字（比较）
     * @return boolean
     * @throws
     * @description 判断是否是目标文件
     * <p>
     * 方法内容：patten 正则表达式 匹配文件
     * RULE:  匹配规则 正则表达式
     * @author Alexius
     * @date 2021/5/30 17:50
     * @since
     */
    public boolean isDestinationFile(String fileName, String RULE) {
//        if (RULE.isEmpty()||RULE.equals("")){
//            throw new RuntimeException("规则为空");
//        }
        Pattern pattern = Pattern.compile(RULE);
        return pattern.matcher(fileName).matches();
    }


    /**
     * @param files
     * @return
     * @throws
     * @description 重命名文件方法
     * @author Alexius
     * @date 2021/6/3 17:30
     * @since
     */

    public void renameFile(List<File> files) {
        File newFile;
        if (C_SUFFIX) {
            //只改后缀名
            for (File file :
                    files) {
                int i = file.getName().lastIndexOf(".");
                if (i<0){
                    newFile = new File(file.getPath() + "." +  SUFFIX);
                    file.renameTo(newFile);
                }else{
                    String newFileName = file.getName().substring(0, i);
                    System.out.println(newFileName + "." + SUFFIX);
                    newFile = new File(newFileName + SUFFIX);
                    file.renameTo(newFile);
                }


            }
        } else if (NEW_FILE_NAME.isEmpty() || NEW_FILE_NAME.equals("")) {
            throw new RuntimeException("新文件名为空");
        } else {
            for (File file :
                    files) {
                newFile = new File(file.getParentFile().getPath() + "\\" + NEW_FILE_NAME);
                System.out.println(file.getParentFile().getPath() + "\\" + NEW_FILE_NAME);
                file.renameTo(newFile);

            }
        }

    }
}
