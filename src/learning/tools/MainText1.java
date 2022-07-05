package learning.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @author:Gjc
 * @time: 13:59
 * @date: 2022-06-23
 */


public class MainText1 {
    public static void main(String[] args) {

        FileReader  fileReader = null;
        try {
            fileReader = new FileReader("D:\\111.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(fileReader);
        String str = "";//一行的内容
        String exceptionStr = "";
        int index = 0;  //行数
        List<String> s = new ArrayList<>();
        int i1 =0;
        while(true){
            try {
                if (!((str = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            s.add(str);
//                System.out.println(++i1);
        }
        try {
            fileReader = new FileReader("D:\\333.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in1 = new BufferedReader(fileReader);
        String str1 = "";//一行的内容
        List<String> d = new ArrayList<>();
        while(true){
            try {
                if (!((str1 = in1.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            d.add(str1);
//                System.out.println(++i1);
        }
        List<String> dif = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dif.addAll(d);
        dif.retainAll(s);
        res.addAll(d);
        res.addAll(s);
        List<String> listWithoutDuplicates = res.stream().distinct().collect(Collectors.toList());
        listWithoutDuplicates.removeAll(dif);
        System.out.println(listWithoutDuplicates);
        System.out.println(listWithoutDuplicates.size());
    }
}
