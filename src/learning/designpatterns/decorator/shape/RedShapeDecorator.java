package learning.designpatterns.decorator.shape;

/**
 * @description
 * @author:Alexius
 * @time: 8:30
 * @date: 2021-06-21
 */


public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
