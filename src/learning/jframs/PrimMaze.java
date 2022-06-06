package learning.jframs;

import java.util.ArrayList;
import java.util.Random;

/**
 * @description
 * @author:Gjc
 * @time: 10:44
 * @date: 2022-02-15
 */


class PrimMaze {
    private int[][] maze;

    public int[][] getMaze() {
        return maze;
    }

    PrimMaze(int row, int column) {
        int row1 = row / 2;
        int column1 = column / 2;
        maze = new int[row1 * 2 + 1][column1 * 2 + 1];
        for (int x = 0; x < row1 * 2 + 1; x++)            //初始化迷宫
        {
            for (int y = 0; y < column1 * 2 + 1; y++) {
                if (x == 0 || x == row1 * 2) {
                    maze[x][y] = -1;
                }
                if (y == 0 || y == column1 * 2) {
                    maze[x][y] = -1;
                }
            }
        }
        for (int x = 1; x < row1 * 2; x++) {
            for (int y = 1; y < column1 * 2; y++) {
                if (x % 2 == 1 || y % 2 == 1) {
                    maze[x][y] = 0;
                }
                if (x % 2 == 0 || y % 2 == 0) {
                    maze[x][y] = 1;
                }
            }
        }

        ArrayList<int[]> list = new ArrayList<>();            //记录已连通的"路"的坐标的集合
        int[] coordinate = new int[2];        //记录未访问的点坐标
        int x = 1, y = 1;        //设置起点位置
        coordinate[0] = coordinate[1] = 1;
        list.add(coordinate);        //将起点加入已经连通的路集合

        //x,y表示当前访问坐标
        while (list.size() < row1 * column1)            //当所有点都已访问完时结束
        {
            boolean flag1;        //标识坐标是否已经被访问
            int[] record = {-1, -1, -1, -1};        //用于记录四周未被访问的方位,0代表上,1代表下,2代表左,3代表右

            if (x - 2 > 0)            //判断当前位置上方是否有路
            {
                int[] a = new int[2];
                a[0] = x - 2;
                a[1] = y;
                flag1 = judge(a, list);        //判断上方是否已经被访问
                if (flag1) {
                    record[0] = 0;
                }
            }
            if (x + 2 < row1 * 2)        //判断当前位置下方是否有路
            {
                int[] a = new int[2];
                a[0] = x + 2;
                a[1] = y;
                flag1 = judge(a, list);        //判断下方是否已经被访问
                if (flag1) {
                    record[1] = 1;
                }
            }
            if (y - 2 > 0)        //判断当前位置左方是否有路
            {
                int[] a = new int[2];
                a[0] = x;
                a[1] = y - 2;
                flag1 = judge(a, list);        //判断左方是否已经被访问
                if (flag1) {
                    record[2] = 2;
                }
            }
            if (y + 2 < column1 * 2)        //判断当前位置右方是否有路
            {
                int[] a = new int[2];
                a[0] = x;
                a[1] = y + 2;
                flag1 = judge(a, list);        //判断右方是否已经被访问
                if (flag1) {
                    record[3] = 3;
                }
            }

            boolean flag2 = false;            //flag2标识四周是否有未访问过的路
            for (int i = 0; i < 4; i++)        //判断当前位置的四个方位是否有未访问过的路
            {
                if (record[i] == i) {
                    flag2 = true;        //如果有未访问过的路,跳出循环
                    break;
                }
            }

            int r = new Random().nextInt(4);
            while (record[r] == r) {
                r = new Random().nextInt(4);
            }

            while (record[r] != r && flag2)            //当方位标识错误且当前位置四周有未访问过的点时继续随机获取一个新的方位标识,直到标识正确
            {
                r = new Random().nextInt(4);        //随机选取一个可以符合条件的墙并将其敲碎
                if (record[r] == r)        //当标识正确时,敲碎两点之间的墙
                {
                    if (r == 0) {       //当上方有未访问过的点时,敲碎上方的墙
                        maze[x - 1][y] = 0;
                    }
                    if (r == 1) {        //当下方有未访问过的点时,敲碎下方的墙
                        maze[x + 1][y] = 0;
                    }
                    if (r == 2) {         //当左方有未访问过的点时,敲碎左方的墙
                        maze[x][y - 1] = 0;
                    }
                    if (r == 3) {       //当右方有未访问过的点时,敲碎右方的墙
                        maze[x][y + 1] = 0;
                    }
                }
            }

            //将与当前坐标之间的墙被敲碎的路的坐标从未被访问的集合中移出
            if (r == 0 && flag2)        //如果敲碎的是上方的墙,则将上方的路加入到已连通的路集合
            {
                int[] b = new int[2];
                b[0] = x - 2;
                b[1] = y;
                if (judge(b, list)) {
                    list.add(b);
                }
            }
            if (r == 1 && flag2)        //如果敲碎的是下方的墙,则将下方的路加入到已连通的路集合
            {
                int[] b = new int[2];
                b[0] = x + 2;
                b[1] = y;
                if (judge(b, list)) {
                    list.add(b);
                }
            }
            if (r == 2 && flag2)        //如果敲碎的是左方的墙,则将左方的路加入到已连通的路集合
            {
                int[] b = new int[2];
                b[0] = x;
                b[1] = y - 2;
                if (judge(b, list)) {
                    list.add(b);
                }
            }
            if (r == 3 && flag2)        //如果敲碎的是右方的墙,则将右方的路加入到已连通的路集合
            {
                int[] b = new int[2];
                b[0] = x;
                b[1] = y + 2;
                if (judge(b, list)) {
                    list.add(b);
                }
            }


            int i = new Random().nextInt(list.size());            //随机选取一个被连通的路坐标
            x = list.get(i)[0];                //获取路坐标
            y = list.get(i)[1];
        }

        for (int r = 0; r < maze.length; r++)//将方格墙转为线条墙,10表示横,11表示竖
        {
            for (int c = 0; c < maze[r].length; c++) {
                if (r % 2 == 0 && c % 2 == 1) {
                    if (maze[r][c] != 0) {
                        maze[r][c] = 10;
                    }
                }
                if (r % 2 == 1 && c % 2 == 0) {
                    if (maze[r][c] != 0) {
                        maze[r][c] = 11;
                    }
                }
            }
        }

    }

    boolean judge(int[] coordinate, ArrayList<int[]> list)            //判断路是否已经加入通路集合,已加入则返回false
    {
        boolean flag = true;
        for (int[] ints : list) {
            if (coordinate[0] == ints[0] && coordinate[1] == ints[1])            //若已访问点集合中含有该位置的坐标,表示该位置已访问过,不用重复加入该位置的坐标
            {
                flag = false;
                break;
            }
        }
        return flag;
    }
}


