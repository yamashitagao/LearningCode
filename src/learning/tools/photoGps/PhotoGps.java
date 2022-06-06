package learning.tools.photoGps;

import com.drew.imaging.FileType;
import com.drew.imaging.FileTypeDetector;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.png.PngMetadataReader;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.GpsDirectory;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/**
 * @description
 * @author:Gjc
 * @time: 16:42
 * @date: 2021-12-06
 */


public class PhotoGps {
    public static HashMap<String, Object> readPicInfo(String file_path) {
        HashMap<String, Object> map = new HashMap<String,Object>();
        Tag tag = null;
        File jpegFile = new File(file_path);
        Metadata metadata;
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            Iterator<Directory> it = metadata.getDirectories().iterator();
            while (it.hasNext()) {
                Directory exif = it.next();
                Iterator<Tag> tags = exif.getTags().iterator();
                while (tags.hasNext()) {
                    tag = (Tag) tags.next();
                    System.out.println(tag.getTagName()+"--"+tag.getDescription());
                }
            }
        } catch (JpegProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 读取照片里面的信息
     */
    private static String printImageTags(File file) throws ImageProcessingException, Exception{
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        String str=new String();
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                String tagName = tag.getTagName();  //标签名
                String desc = tag.getDescription(); //标签信息

                if (tagName.equals("Image Height")) {
                    str+="Image Height : "+desc+"<br/>";
                    System.out.println("图片高度: "+desc);
                } else if (tagName.equals("Image Width")) {
                    str+="Image Width : "+desc+"<br/>";
                    System.out.println("图片宽度: "+desc);
                } else if (tagName.equals("Date/Time Original")) {
                    System.out.println("拍摄时间: "+desc);
                }else if (tagName.equals("GPS Latitude")) {
                    str+="Latitude : "+pointToLatlong(desc)+"&nbsp&nbsp&nbsp&nbsp"+desc+"<br/>";
                    System.err.println("纬度 : "+desc);
//                	System.err.println("纬度(度分秒格式) : "+pointToLatlong(desc));
                } else if (tagName.equals("GPS Longitude")) {
                    str+="Longitude : "+pointToLatlong(desc)+"&nbsp&nbsp&nbsp&nbsp"+desc+"<br/>";
                    System.err.println("经度: "+desc);
//                	System.err.println("经度(度分秒格式): "+pointToLatlong(desc));
                }
            }
        }
        return str;
    }
    /**
     * 经纬度格式  转换为  度分秒格式 ,如果需要的话可以调用该方法进行转换
     * @param point 坐标点
     * @return
     */
    public static String pointToLatlong (String point ) {
        Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());
        Double fen = Double.parseDouble(point.substring(point.indexOf("°")+1, point.indexOf("'")).trim());
        Double miao = Double.parseDouble(point.substring(point.indexOf("'")+1, point.indexOf("\"")).trim());
        Double duStr = du + fen / 60 + miao / 60 / 60 ;
        return duStr.toString();
    }


    public static void main(String[] args) {
        readPicInfo("D:\\1.jpg");
        System.out.println("------------");
        try {
            printImageTags(new File("D:\\1.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
