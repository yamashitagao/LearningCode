package learning.tools;

import learning.designpatterns.singleton.Singleton;
import learning.tools.RenameFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @author:Alexius
 * @time: 17:15
 * @date: 2021/5/29
 */


public class MainText {
    public static void main(String[] args) {
        String FILE_PATh = "D:\\A\\idanmu";
        String DESTINATION_FILE_NAME = "";
        String NEW_FILE_NAME = "";
        String RULE = "^\\d{6}$";//^\d{2}$
        RenameFile rf = new RenameFile(FILE_PATh,DESTINATION_FILE_NAME,NEW_FILE_NAME);
        rf.ADD_DIR = false;
        rf.C_SUFFIX = true;
        rf.SUFFIX = "rar";

        List<String> strings = rf.FindFiles();
        File file =new File(FILE_PATh);
        File[] files = file.listFiles();
        List<File> files1 = Arrays.asList(files);
        List<File> files2 = rf.findFilesItIteration(files1,RULE);
        for (File f :
                files2) {
            System.out.println(f.getPath()+ " : "+f.getName());
        }
        rf.renameFile(files2);

    }
}
