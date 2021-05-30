package learning.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 *      作用:批量修改文件夹或文件
 *      思路1:遍历所有文件文件夹
 *           获取路径存放入列表
 *           修改文件
 *      思路2:遍历所有文件文件夹
 *           判断复合条件的修改
 *
 *      遍历文件夹：多级文件夹
 *
 *
 *      DESTINATION_FILE_NAME:目标文件名
 *      NEW_FILE_NAME:新文件名
 * @author:Alexius
 * @time: 22:40
 * @date: 2021/5/29
 */


public class RenameFile {
    String FILE_PATh = "D:\\A";
    String DESTINATION_FILE_NAME = "idanmu";
    String NEW_FILE_NAME = "";
    List<File> resultIteration = new ArrayList<>(); //迭代结果集
    /**
     * @description
     *      使用for方法循环便利遍历
     * @param
     * @return List<String>
     * @throws 
     * @since 
     * @author Alexius
     * @date 2021/5/30 0:02
    */
    public List<String> FindFiles(){
        List<String> result = new ArrayList<>();
        List<File> directoryFile = new ArrayList<>();
        File resourceFile = new File(FILE_PATh);

        if (!resourceFile.exists()){return null;}

        File[] files = resourceFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //如果路径存在文件或文件夹 而且是文件夹
            if (files[i].isDirectory()){
                directoryFile.add(files[i]);
            }
            //如果路径存在文件或文件夹 而且符合要求 存入结果集
            if (files[i].getName().equals(DESTINATION_FILE_NAME) ){

                result.add(files[i].getPath());
            }
        }
        int len = directoryFile.size();
        for (int i = 0; i < len; i++) {
            File[] dirFiles = directoryFile.get(i).listFiles();
            if (!(dirFiles.length < 1)){
                for (int j = 0; j < dirFiles.length; j++) {
                    //如果路径存在文件或文件夹 而且是文件夹
                    if (dirFiles[j].isDirectory()){
                        directoryFile.add(dirFiles[j]);
                        len ++ ;
                    }
                    //如果路径存在文件或文件夹 而且符合要求 存入结果集
                    if (dirFiles[j].getName().equals(DESTINATION_FILE_NAME) ){
                        result.add(dirFiles[j].getPath());
                    }
                }
            }

        }

        
        return result;
    }

    /**
     * @description
     *      迭代方式循环遍历
     * @param
     * @return List<String>
     * @throws 
     * @since 
     * @author Alexius
     * @date 2021/5/30 11:23 
    */
    public List<File> FindFilesItIteration(List<File> directoryFiles){

        List<File> dirFiles = new ArrayList<>();
        if (directoryFiles.size() < 1){ return null; }
        for (int i = 0; i < directoryFiles.size(); i++) {
            if (directoryFiles.get(i).isDirectory()){
                dirFiles.add( directoryFiles.get(i));
            }
            if (directoryFiles.get(i).getName().equals(DESTINATION_FILE_NAME)){
                resultIteration.add(directoryFiles.get(i));
            }
        }
        for (int i = 0; i < dirFiles.size(); i++) {
            File[] files = dirFiles.get(i).listFiles();
            List<File> files1 = Arrays.asList(files);
            FindFilesItIteration(files1);
        }

        return resultIteration;
    }
}
