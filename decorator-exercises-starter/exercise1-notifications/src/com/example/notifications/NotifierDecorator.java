package com.example.notifications;

public abstract class NotifierDecorator implements Notifier{
    private Notifier notifier;

    public NotifierDecorator(Notifier notifier){
        this.notifier = notifier;
    }

    @Override
    public void notify(String message){
        notifier.notify(message);
    }
}
