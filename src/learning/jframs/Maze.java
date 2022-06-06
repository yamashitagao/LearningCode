package learning.jframs;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @description
 * @author:Gjc
 * @time: 10:31
 * @date: 2022-02-15
 */


public class Maze extends JFrame {
//    public Maze() {
//        this.setTitle("复杂迷宫");
//        this.setSize(240, 265);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setResizable(false);
//        initialize();
//        this.setVisible(true);
//    }
//
//    private void initialize() {
//        JPanel contentPane = new JPanel();
//        this.setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JLabel widthLabel = new JLabel("迷宫长度：");
//        JLabel heightLabel = new JLabel("迷宫高度：");
//        JLabel levelLabel = new JLabel("难度:");
//        JTextField widthText = new JTextField();
//        JTextField heightText = new JTextField();
//        JRadioButton level1 = new JRadioButton("1");
//        JRadioButton level2 = new JRadioButton("2");
//        JRadioButton level3 = new JRadioButton("3");
//        ButtonGroup levelGroup = new ButtonGroup();
//        levelGroup.add(level1);
//        levelGroup.add(level2);
//        levelGroup.add(level3);
//        JButton run = new JButton("生成迷宫");
//
//        // 设定标签位置
//        widthLabel.setBounds(20, 20, 100, 30);
//        heightLabel.setBounds(20, 70, 110, 30);
//        widthText.setBounds(120, 20, 70, 30);
//        heightText.setBounds(120, 70, 70, 30);
//        levelLabel.setBounds(20, 120, 60, 30);
//        level1.setBounds(80, 120, 50, 30);
//        level2.setBounds(130, 120, 50, 30);
//        level3.setBounds(180, 120, 50, 30);
//        run.setBounds(55, 170, 120, 30);
//        // 限制输入框只接收数字
//        widthText.setDocument(new NumberTextField());
//        heightText.setDocument(new NumberTextField());
//
//        // 改变字体
//        Font font = new Font("楷体", Font.PLAIN, 17);
//        widthLabel.setFont(font);
//        heightLabel.setFont(font);
//        widthText.setFont(font);
//        heightText.setFont(font);
//        levelLabel.setFont(font);
//        level1.setFont(font);
//        level2.setFont(font);
//        level3.setFont(font);
//        run.setFont(font);
//
//        // 取消按钮选中边框
//        level1.setFocusPainted(false);
//        level2.setFocusPainted(false);
//        level3.setFocusPainted(false);
//
//        // 默认选择难度3
//        level3.setSelected(true);
//
//        contentPane.add(widthLabel);
//        contentPane.add(heightLabel);
//        contentPane.add(widthText);
//        contentPane.add(heightText);
//        contentPane.add(levelLabel);
//        contentPane.add(level1);
//        contentPane.add(level2);
//        contentPane.add(level3);
//        contentPane.add(run);
//
//        // 生成迷宫监听器
//        run.addActionListener(e -> {
//            // 建议宽在10-90，长在10-45之间
//            if (widthText.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "长度不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
//            } else if (heightText.getText().equals("")) {
//                JOptionPane.showMessageDialog(null, "高度不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                int width = Integer.parseInt(widthText.getText());
//                int height = Integer.parseInt(heightText.getText());
//                if (width >= 10 && width <= 90 && height >= 10 && height <= 45) {
//                    int level = level1.isSelected() ? 1 : level2.isSelected() ? 2 : 3;
//                    MazeModel maze = new MazeModel(width, height, level);
//                    this.dispose();
//                    maze.draw();
//                } else {
//                    JOptionPane.showMessageDialog(null, "迷宫的长必须在10-45之间，宽必须在10-90之间，请检查输入是否有误！", "错误输入", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
//        // 添加回车键入监听器
//        KeyAdapter enterAdapter = new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    run.doClick();   // 回车即生成迷宫
//                }
//            }
//        };
//        widthText.addKeyListener(enterAdapter);
//        heightText.addKeyListener(enterAdapter);
//    }
//
//    public static void main(String[] args) {
//
//    }
}


