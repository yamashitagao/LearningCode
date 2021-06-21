package learning.designpatterns.strategy.arithmetic;

/**
 * @description
 * @author:Alexius
 * @time: 10:24
 * @date: 2021-06-21
 */


public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}