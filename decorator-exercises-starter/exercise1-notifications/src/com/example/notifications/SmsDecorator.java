package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private String phone;

    public SmsDecorator(Notifier notifier, String phone){
        super(notifier);
        this.phone = phone;
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        System.out.println("[SMS] -> " + phone + " : " + message);
    }
}
