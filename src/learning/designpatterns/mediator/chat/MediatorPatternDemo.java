package learning.designpatterns.mediator.chat;

/**
 * @description
 * @author:Alexius
 * @time: 10:14
 * @date: 2021-06-21
 */


public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}