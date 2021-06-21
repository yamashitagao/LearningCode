package learning.designpatterns.decorator.tanks;

/**
 * @description
 *      坦克涂装的装饰类
 * @author:Alexius
 * @time: 9:43
 * @date: 2021-06-21
 */


public class TankPaintingDecorator extends GODecorator {


    public TankPaintingDecorator(GameObject tankDecorator) {
        super(tankDecorator);
    }

    @Override
    public void paint() {
        tankDecorator.paint();
        painting(tankDecorator);
    }

    public void painting(GameObject tankDecorator){
        System.out.println(tankDecorator.toString()+"迷彩涂装");
    }
}
