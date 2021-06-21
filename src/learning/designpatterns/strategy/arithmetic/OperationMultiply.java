package learning.designpatterns.strategy.arithmetic;

/**
 * @description
 * @author:Alexius
 * @time: 10:22
 * @date: 2021-06-21
 */


public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}