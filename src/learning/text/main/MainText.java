package learning.text.main;

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
        String FILE_PATh = "D:\\A";
        String DESTINATION_FILE_NAME = "2";
        RenameFile rf = new RenameFile();

        List<String> strings = rf.FindFiles();
        File file =new File(FILE_PATh);
        File[] files = file.listFiles();
        List<File> files1 = Arrays.asList(files);
        List<File> files2 = rf.FindFilesItIteration(files1);
        for (File f :
                files2) {
            System.out.println(f.getPath()+ " : "+f.getName());
        }

    }
}
