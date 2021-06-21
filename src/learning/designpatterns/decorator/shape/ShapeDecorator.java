package learning.designpatterns.decorator.shape;

/**
 * @description
 *          核心 装饰器
 * @author:Alexius
 * @time: 8:27
 * @date: 2021-06-21
 */


public abstract class  ShapeDecorator implements Shape{
    //传入装饰原型（被装饰者）
    protected Shape decoratedShape;

    //在构造时候传入原型
    public ShapeDecorator(Shape decoratorShape) {
        this.decoratedShape = decoratorShape;
    }


    public void draw(){
        decoratedShape.draw();
    }
}
