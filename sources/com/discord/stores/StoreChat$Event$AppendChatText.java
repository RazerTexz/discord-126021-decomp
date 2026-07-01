package com.discord.stores;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChat$Event$AppendChatText extends StoreChat$Event {
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChat$Event$AppendChatText(String str) {
        super(null);
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.text = str;
    }

    public static /* synthetic */ StoreChat$Event$AppendChatText copy$default(StoreChat$Event$AppendChatText storeChat$Event$AppendChatText, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeChat$Event$AppendChatText.text;
        }
        return storeChat$Event$AppendChatText.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final StoreChat$Event$AppendChatText copy(String text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        return new StoreChat$Event$AppendChatText(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreChat$Event$AppendChatText) && m.areEqual(this.text, ((StoreChat$Event$AppendChatText) other).text);
        }
        return true;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("AppendChatText(text="), this.text, ")");
    }
}
