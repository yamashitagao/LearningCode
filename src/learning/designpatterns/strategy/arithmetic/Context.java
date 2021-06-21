package learning.designpatterns.strategy.arithmetic;

/**
 * @description
 * @author:Alexius
 * @time: 10:23
 * @date: 2021-06-21
 */


public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}