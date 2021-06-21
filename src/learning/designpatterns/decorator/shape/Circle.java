package learning.designpatterns.decorator.shape;

/**
 * @description
 * @author:Alexius
 * @time: 8:26
 * @date: 2021-06-21
 */


public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
