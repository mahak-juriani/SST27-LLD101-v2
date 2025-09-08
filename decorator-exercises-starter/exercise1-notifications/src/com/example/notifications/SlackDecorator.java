package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private String channel;

    SlackDecorator(Notifier notifier, String channel){
        super(notifier);
        this.channel = channel;
    }

    @Override
    public void notify(String message) {
        super.notify(message);
        System.out.println("[Slack] -> #" + channel + " : " + message);
    }
}
