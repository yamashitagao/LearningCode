package learning.jframs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * @description
 * @author:Gjc
 * @time: 10:38
 * @date: 2022-02-15
 */

public class MazeModel {
//    private int width;
//    private int height;
//    private ArrayList<MazePoint> mazePoints;
//
//    /**
//     * 迷宫的构造方法
//     *
//     * @param width  迷宫的宽度
//     * @param height 迷宫的
//     * @param level  1 -> 递归分割算法生成迷宫，2 -> 递归回溯算法生成迷宫，3 -> 普里姆算法生成迷宫
//     */
//    public MazeModel(int width, int height, int level) {
//        super();
//        this.width = width;
//        this.height = height;
//        switch (level) {
//            case 1 : this.mazePoints = recursiveDivision();
//            case 2 : this.mazePoints = recursiveBacktracker();
//            case 3 : this.mazePoints = prim();
//        }
//    }
//
//    /**
//     * 递归回溯生成迷宫
//     *
//     * @return 生成的迷宫的单元格集合
//     */
//    private ArrayList<MazePoint> recursiveBacktracker() {
//        ArrayList<MazePoint> maze = new ArrayList<>();
//        // 初始化所以单元格都被强包围
//        for (int h = 0; h < height; h++) {
//            for (int w = 0; w < width; w++) {
//                MazePoint point = new MazePoint(w, h, true);
//                maze.add(point);
//            }
//        }
//        // 建立一个存放操作单元格的栈
//        Stack<MazePoint> stack = new Stack<>();
//        // 选择（0,0）点作为起始点，开始打通迷宫
//        stack.push(maze.get(0));
//        maze.get(0).visited = true;
//
//        Random random = new Random();
//        int x;   // 操作单元格的横坐标
//        int y;   // 操作单元格的纵坐标
//        int direction;   // 方向
//        while (!stack.empty()) {
//            // 选择栈顶元素作为当前操作数
//            MazePoint operatingPoint = stack.peek();
//            x = operatingPoint.getX();
//            y = operatingPoint.getY();
//
//            direction = random.nextInt(4);
//            MazePoint adjacency;
//
//            switch (direction) {
//
//                case 0: // 左边
//                    if ((x - 1) >= 0) {   // 判断左边是否为边缘
//                        adjacency = maze.get(x - 1 + y * width);   // 判断左边单元格是否被访问过
//                        if (!adjacency.visited) {
//                            operatingPoint.setLeft(0);   // 打通操作单元格的左墙，和左边单元格的右墙
//                            adjacency.setRight(0);
//                            stack.push(adjacency);    // 将左墙入栈，作为下次循环的操作单元格
//                            adjacency.visited = true;    // 将左边的单元格设置为访问过了
//                            x--;   // 改变操作单元格的坐标，方便后面判断当前单元格四周是否都访问过
//                        }
//                    }
//                    break;
//                case 1: // 右边
//                    // 注释参照case0
//                    if ((x + 1) < width) {
//                        adjacency = maze.get(x + 1 + y * width);
//                        if (!adjacency.visited) {
//                            operatingPoint.setRight(0);
//                            adjacency.setLeft(0);
//                            stack.push(adjacency);
//                            adjacency.visited = true;
//                            x++;
//                        }
//                    }
//                    break;
//                case 2: // 上边
//                    // 注释参照case0
//                    if ((y - 1) >= 0) {
//                        adjacency = maze.get(x + (y - 1) * width);
//                        if (!adjacency.visited) {
//                            operatingPoint.setUp(0);
//                            adjacency.setDown(0);
//                            stack.push(adjacency);
//                            adjacency.visited = true;
//                            y--;
//                        }
//                    }
//                    break;
//                case 3: // 下边
//                    // 注释参照case0
//                    if ((y + 1) < height) {
//                        adjacency = maze.get(x + (y + 1) * width);
//                        if (!adjacency.visited) {
//                            operatingPoint.setDown(0);
//                            adjacency.setUp(0);
//                            stack.push(adjacency);
//                            adjacency.visited = true;
//                            y++;
//                        }
//                    }
//                    break;
//            }
//
//            // 若操作单元格四周都被访问过，将该单元格出栈。
//            if ((x - 1 < 0 || maze.get(x - 1 + y * width).visited)
//                    && (x + 1 >= width || maze.get(x + 1 + y * width).visited)
//                    && (y - 1 < 0 || maze.get(x + (y - 1) * width).visited)
//                    && (y + 1 >= height || maze.get(x + (y + 1) * width).visited)) {
//                stack.pop();
//            }
//        }
//
//        maze.get(0).setLeft(0);    // 左上角开墙作为入口
//        maze.get(width * height - 1).setRight(0);    // 右下角开墙作为出口
//        return maze;
//    }
//
//    /**
//     * 分割迷宫区域
//     *
//     * @param maze  单元格集合
//     * @param right 区域的宽
//     * @param top   区域的高
//     */
//    private void divide(ArrayList<MazePoint> maze, int left, int right, int top, int down) {
//        if (right - left > 0 && top - down > 0) {
//            // 在区域中心”十“字筑墙
//            for (int x = left, y = (top - down) / 2 + down; x <= right; x++) {
//                maze.get(x + y * this.width).setDown(1);
//                maze.get(x + (y + 1) * this.width).setUp(1);
//            }
//            for (int x = (right - left) / 2 + left, y = down; y <= top; y++) {
//                maze.get(x + y * this.width).setRight(1);
//                maze.get(x + 1 + y * this.width).setLeft(1);
//            }
//
//            // 在“十”字墙中选其中三个方向拆一面墙
//            Random random = new Random();
//            int direction = random.nextInt(4);
//            int x = (right - left) / 2 + left;
//            int y = (top - down) / 2 + down;
//            int tempX;
//            int tempY;
//            if (direction != 0) {    // 打通一面左边的墙
//                if (x - left > left) {
//                    tempX = random.nextInt(x - left + 1) + left;
//                } else {
//                    tempX = left;
//                }
//                tempY = y;
//                maze.get(tempX + tempY * this.width).setDown(0);
//                maze.get(tempX + (tempY + 1) * this.width).setUp(0);
//            }
//            if (direction != 1) {    // 打通一面右边的墙
//                if (right - (x + 1) > x + 1) {
//                    tempX = random.nextInt(right - (x + 1) + 1) + x + 1;
//                } else {
//                    tempX = x + 1;
//                }
//                tempY = y;
//                maze.get(tempX + tempY * this.width).setDown(0);
//                maze.get(tempX + (tempY + 1) * this.width).setUp(0);
//            }
//            if (direction != 2) {    // 打通一面上面的墙
//                tempX = x;
//                if (y - down > down) {
//                    tempY = random.nextInt(y - down + 1) + down;
//                } else {
//                    tempY = down;
//                }
//                maze.get(tempX + tempY * this.width).setRight(0);
//                maze.get(tempX + 1 + tempY * this.width).setLeft(0);
//            }
//            if (direction != 3) {    // 打通一面下面的墙
//                tempX = x;
//                if (top - (y + 1) > y + 1) {
//                    tempY = random.nextInt(top - (y + 1) + 1) + y + 1;
//                } else {
//                    tempY = y + 1;
//                }
//                maze.get(tempX + tempY * this.width).setRight(0);
//                maze.get(tempX + 1 + tempY * this.width).setLeft(0);
//            }
//
//            maze.stream().limit(this.width).forEach(m -> m.setUp(1));
//            maze.stream().skip((this.height - 1) * this.width).forEach(m -> m.setDown(1));
//            maze.stream().filter(m -> m.getX() == 0).forEach(m -> m.setLeft(1));
//            maze.stream().filter(m -> m.getX() == width - 1).forEach(m -> m.setRight(1));
//            divide(maze, left, (right - left) / 2 + left, (top - down) / 2 + down, down);
//            divide(maze, left, (right - left) / 2 + left, top, (top - down) / 2 + down + 1);
//            divide(maze, (right - left) / 2 + left + 1, right, (top - down) / 2 + down, down);
//            divide(maze, (right - left) / 2 + left + 1, right, top, (top - down) / 2 + down + 1);
//        }
//    }
//
//    /**
//     * 递归分割生成迷宫
//     *
//     * @return 生成的迷宫的单元格集合
//     */
//    private ArrayList<MazePoint> recursiveDivision() {
//        // 初始化迷宫的所有单元格
//        ArrayList<MazePoint> maze = new ArrayList<>();
//        for (int h = 0; h < height; h++) {
//            for (int w = 0; w < width; w++) {
//                MazePoint point = new MazePoint(w, h);
//                maze.add(point);
//            }
//        }
//        divide(maze, 0, width - 1, height - 1, 0);  // 递归分割迷宫
//
//        maze.get(0).setLeft(0);    // 左上角开墙作为入口
//        maze.get(width * height - 1).setRight(0);    // 右下角开墙作为出口
//        return maze;
//    }
//
//    private ArrayList<MazePoint> prim() {
//        ArrayList<MazePoint> mazePoints = new ArrayList<>();
//        PrimMaze primMaze = new PrimMaze(width * 2 + 1, height * 2 + 1);
//        int[][] tempMaze = primMaze.getMaze();
//        for (int i = 0; i < tempMaze.length; i++) {
//            for (int j = 0; j < tempMaze[i].length; j++) {
//                if (i % 2 != 0 && j % 2 != 0) {
////                    MazePoint mazePoint = new MazePoint(i / 2, j / 2);
//                    if (tempMaze[i - 1][j] == 10) {
//                        mazePoint.setLeft(1);
//                    }
//                    if (tempMaze[i + 1][j] == 10) {
//                        mazePoint.setRight(1);
//                    }
//                    if (tempMaze[i][j - 1] == 11) {
//                        mazePoint.setUp(1);
//                    }
//                    if (tempMaze[i][j + 1] == 11) {
//                        mazePoint.setDown(1);
//                    }
//                    mazePoints.add(mazePoint);
//                }
//            }
//        }
//        mazePoints.get(0).setLeft(0);    // 左上角开墙作为入口
//        mazePoints.get(width * height - 1).setRight(0);    // 右下角开墙作为出口
//        return mazePoints;
//    }
//
//    public void draw() {
//        new PlayView(mazePoints);
//    }

}



