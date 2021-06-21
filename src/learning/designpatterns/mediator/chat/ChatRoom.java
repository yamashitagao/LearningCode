package learning.designpatterns.mediator.chat;

import java.util.Date;

/**
 * @description
 * @author:Alexius
 * @time: 10:13
 * @date: 2021-06-21
 */


public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
