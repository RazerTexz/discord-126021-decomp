package com.discord.api.message.activity;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageActivityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageActivityType$Companion {
    public MessageActivityType$Companion() {
    }

    public final MessageActivityType a(Integer num) {
        MessageActivityType messageActivityType = MessageActivityType.JOIN;
        int apiInt = messageActivityType.getApiInt();
        if (num != null && num.intValue() == apiInt) {
            return messageActivityType;
        }
        MessageActivityType messageActivityType2 = MessageActivityType.SPECTATE;
        int apiInt2 = messageActivityType2.getApiInt();
        if (num == null || num.intValue() != apiInt2) {
            messageActivityType2 = MessageActivityType.LISTEN;
            int apiInt3 = messageActivityType2.getApiInt();
            if (num == null || num.intValue() != apiInt3) {
                messageActivityType2 = MessageActivityType.WATCH;
                int apiInt4 = messageActivityType2.getApiInt();
                if (num == null || num.intValue() != apiInt4) {
                    messageActivityType2 = MessageActivityType.REQUEST;
                    int apiInt5 = messageActivityType2.getApiInt();
                    if (num == null || num.intValue() != apiInt5) {
                        return messageActivityType;
                    }
                }
            }
        }
        return messageActivityType2;
    }

    public MessageActivityType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
