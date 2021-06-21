package learning.designpatterns.mediator.chat;

/**
 * @description
 * @author:Alexius
 * @time: 10:14
 * @date: 2021-06-21
 */


public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
