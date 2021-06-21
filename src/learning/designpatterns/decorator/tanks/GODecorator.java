package learning.designpatterns.decorator.tanks;

/**
 * @description
 * @author:Alexius
 * @time: 9:37
 * @date: 2021-06-21
 */


public abstract class GODecorator implements GameObject{
    protected GameObject tankDecorator;

    public GODecorator(GameObject tankDecorator) {
        this.tankDecorator = tankDecorator;
    }

    @Override
    public void paint() {
        tankDecorator.paint();
    }
}
