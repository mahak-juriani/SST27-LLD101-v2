package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");
        Notifier emailSms = new SmsDecorator(base, "981739202876");
        emailSms.notify("this is emailSms is the!");

        Notifier emailWp = new WhatsappDecorator(base, "98371937153");
        emailWp.notify("this is emailWp is the!");

        Notifier emailSlack = new SlackDecorator(base, "mahakkaslack");
        emailSlack.notify("this is emailSlack is the!");
        // === YOUR TASKS ===
        // 1) Create a base decorator class: NotifierDecorator implements Notifier and wraps another Notifier.
        // 2) Create concrete decorators:
        //      - SmsDecorator (adds SMS send)
        //      - WhatsAppDecorator (adds WhatsApp send)
        //      - SlackDecorator (adds Slack send)
        // 3) Compose at runtime to achieve these combinations:
        //      a) Email + SMS
        //      b) Email + WhatsApp
        //      c) Email + Slack
        //      d) Email + WhatsApp + Slack
        //
        // Example (after you implement):
        Notifier smsAndEmail = new SmsDecorator(base, "+91-99999-11111");
        smsAndEmail.notify("Build green ✅");
        
        Notifier full = new SlackDecorator(new WhatsappDecorator(base, "user_wa"), "deployments");
        full.notify("Deployment completed 🚀");
    }
}
