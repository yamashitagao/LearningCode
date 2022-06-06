package learning.jframs;

/**
 * @description
 * @author:Gjc
 * @time: 10:40
 * @date: 2022-02-15
 */


public class MazePoint {
    int X;
    int Y;
    int left;
    int right;
    int up;
    int down;

    boolean visited = false;
    boolean unKnow;

    public MazePoint() {

    }

//    public MazePoint(int x, int y, boolean unKnow) {
//        X = x;
//        Y = y;
//        this.unKnow = unKnow;
//    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public boolean isUnKnow() {
        return unKnow;
    }

    public void setUnKnow(boolean unKnow) {
        this.unKnow = unKnow;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }
}
