package learning.base.IOLearning;

import java.io.*;
import java.util.Date;

/**
 * @description
 * @author:Alexius
 * @time: 15:14
 * @date: 2021-07-07
 */


public class Main {
    public static void main(String[] args) {
        long ot =System.currentTimeMillis();
        int count = 0;
        InputStream inputStream = null;
        byte[] buffer=new byte[512];
        try {
            inputStream = new FileInputStream(new File("D:\\DevTools\\思维导图\\java_1.png"));

            while(inputStream.read(buffer)!=-1){
                inputStream.markSupported();
                count++;
            }
            System.out.println(System.currentTimeMillis()-ot);
            System.out.println("---长度是： "+count*512+" 字节");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                inputStream.close();
            }catch (IOException e) {
                //TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }


    }
}
