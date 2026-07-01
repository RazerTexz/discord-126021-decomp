package com.discord.api.message.activity;


/* JADX INFO: compiled from: MessageActivityType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MessageActivityType {
    JOIN(1),
    SPECTATE(2),
    LISTEN(3),
    WATCH(4),
    REQUEST(5);

    public static final MessageActivityType$Companion Companion = new MessageActivityType$Companion(null);
    private final int apiInt;

    MessageActivityType(int i) {
        this.apiInt = i;
    }

    public final int getApiInt() {
        return this.apiInt;
    }
}
