package com.example.notifications;

public class WhatsappDecorator extends NotifierDecorator{
    private String phone;

    public WhatsappDecorator(Notifier notifier, String phone){
        super(notifier);
        this.phone = phone;
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        System.out.println("[Whatsapp] -> " + phone + " : " + message);
    }
}
