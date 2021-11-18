package learning.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.*;
import sun.misc.GC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * ppt转图片 图片转张图 有问题！
 * @author:Gjc
 * @time: 14:09
 * @date: 2021-11-16
 */


public class PdfToImage {
    /**
     * pdf转图
     */
    public static List<String> pdfToImagePath(String filePath) {
        List<String> list = new ArrayList<>();
        String substring = filePath.substring(0, filePath.lastIndexOf("."));
        String imagePath;
        try {
            File file = new File(filePath);
            PDDocument doc = PDDocument.load(file);
            PDFRenderer pdfRenderer = new PDFRenderer(doc);

            int numberOfPages = doc.getNumberOfPages();
            for (int i = 0; i < numberOfPages; i++) {
                // 方式1,第二个参数是设置缩放比(即像素)
                // BufferedImage image = renderer.renderImageWithDPI(i, 296);
                // 方式2,第二个参数是设置缩放比(即像素)
                BufferedImage bufferedImage = pdfRenderer.renderImage(i, 1.25f);
                imagePath = substring + "/" + i + ".png";
                ImageIO.write(bufferedImage, "PNG", new File(imagePath));
                list.add(imagePath);

            }
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }


    /**
     * ppt2007文档的转换 后缀为.pptx
     *
     * @param pptFile PPT文件
     * @param imgFile 图片将要保存的路径目录（不是文件）
     * @param list    存放文件名的 list
     * @return
     */
    public static boolean doPPT2007toImage(File pptFile, File imgFile, List<String> list) {
        FileInputStream is = null;
        long tempTime;
        SlideShow slideShow = null;
        try {
            is = new FileInputStream(pptFile);
            if (pptFile.getAbsolutePath().endsWith(".ppt")) {
                slideShow = new HSLFSlideShow(is);
            } else if (pptFile.getAbsolutePath().endsWith(".pptx")) {
                slideShow = new XMLSlideShow(is);
            }
            is.close();
            // 获取大小
            Dimension pgsize = slideShow.getPageSize();
            // 获取幻灯片
            List<XSLFSlide> slides = slideShow.getSlides();

            tempTime = System.currentTimeMillis();
            for (int i = 0; i < slides.size(); i++) {
                // 解决乱码问题
                // 这几个循环只要是设置字体为宋体，防止中文乱码，
//                List<XSLFShape> shapes = slides.get(i).getShapes();
//                for (XSLFShape shape : shapes) {
//
//                    if (shape instanceof XSLFTextShape) {
//                        XSLFTextShape sh = (XSLFTextShape) shape;
//                        List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();
//
//                        for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
//                            List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
//                            for (XSLFTextRun xslfTextRun : textRuns) {
//                                xslfTextRun.setFontFamily("微软雅黑");
//                            }
//                        }
//                    }
//                }

                //根据幻灯片大小生成图片
                BufferedImage img = new BufferedImage(pgsize.width * 2, pgsize.height * 2, BufferedImage.TYPE_INT_RGB);

                Graphics2D graphics = img.createGraphics();

                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
                graphics.scale(2, 2);
                // 最核心的代码
                slides.get(i).draw(graphics);

                //图片将要存放的路径
                String absolutePath = imgFile.getAbsolutePath() + "/" + (i + 1) + ".jpg";
                File jpegFile = new File(absolutePath);
                // 图片路径存放
                list.add(absolutePath);

                //如果图片存在，则不再生成
                if (jpegFile.exists()) {
                    continue;
                }
                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(jpegFile);

                // 写入到图片中去
                ImageIO.write(img, "jpg", out);

                out.close();

            }
            System.out.println("step1:" + (System.currentTimeMillis() - tempTime));

            System.out.println("PPT转换成图片 成功！");

            return true;

        } catch (Exception e) {
            System.out.print("PPT转换成图片 发生异常！");
        }

        
        return false;

    }

    /**
     * 将宽度相同的图片，竖向追加在一起 ##注意：宽度必须相同
     *
     * @param piclist 文件路径列表
     * @param outPath 输出路径
     */
    public static void yPic(List<String> piclist, String outPath) {// 纵向处理图片
        if (piclist == null || piclist.size() <= 0) {
            System.out.println("图片数组为空!");
            return;
        }

        try {
            int height = 0, // 总高度
                    width = 0, // 总宽度
                    _height = 0, // 临时的高度 , 或保存偏移高度
                    __height = 0, // 临时的高度，主要保存每个高度
                    picNum = piclist.size();// 图片的数量
            File fileImg = null; // 保存读取出的图片
            int[] heightArray = new int[picNum]; // 保存每个文件的高度
            BufferedImage buffer = null; // 保存图片流
            List<int[]> imgRGB = new ArrayList<int[]>(); // 保存所有的图片的RGB
            int[] _imgRGB; // 保存一张图片中的RGB数据
            for (int i = 0; i < picNum; i++) {
                fileImg = new File(piclist.get(i)); //获取列表图片
                buffer = ImageIO.read(fileImg); //图片流
                heightArray[i] = _height = buffer.getHeight();// 图片高度
                if (i == 0) { //纵向只需要一个宽度
                    width = buffer.getWidth();// 图片宽度
                }
                height += _height; // 获取总高度
                _imgRGB = new int[width * _height];// 从图片中读取RGB
                _imgRGB = buffer.getRGB(0, 0, width, _height, _imgRGB, 0, width);
                imgRGB.add(_imgRGB);
            }
            _height = 0; // 设置偏移高度为0
            // 生成新图片
            BufferedImage imageResult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < picNum; i++) {
                __height = heightArray[i];
                if (i != 0) _height += __height; // 计算偏移高度
                imageResult.setRGB(0, _height, width, __height, imgRGB.get(i), 0, width); // 写入流中
            }
            File outFile = new File(outPath);
            ImageIO.write(imageResult, "jpg", outFile);// 写图片
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "D:\\DevCode\\Buss\\材料\\syt资料\\企业文化月刊-文化天地-9月刊.pptx";
//        List<String> strings = pdfToImagePath(path);
        String image = "D:\\DevCode\\Buss\\材料\\syt资料\\企业文化月刊-文化天地-9月刊";
        File f = new File(image);
        File file = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }
        List<String> imagePath = new ArrayList<>();
        doPPT2007toImage(file, f, imagePath);
        for (String p :
                imagePath) {
            System.out.println(p);
        }
        long tempTime = System.currentTimeMillis();
        yPic(imagePath, "D:\\DevCode\\Buss\\材料\\syt资料\\企业文化月刊-文化天地-9月刊\\long.jpg");
        System.out.println("step2:" + (System.currentTimeMillis() - tempTime));
    }

}
