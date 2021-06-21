package learning.designpatterns.decorator.shape;

/**
 * @description
 * @author:Alexius
 * @time: 8:25
 * @date: 2021-06-21
 */


public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
