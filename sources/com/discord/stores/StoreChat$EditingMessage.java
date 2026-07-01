package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChat$EditingMessage {
    private final CharSequence content;
    private final Message message;

    public StoreChat$EditingMessage(Message message, CharSequence charSequence) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(charSequence, "content");
        this.message = message;
        this.content = charSequence;
    }

    public static /* synthetic */ StoreChat$EditingMessage copy$default(StoreChat$EditingMessage storeChat$EditingMessage, Message message, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            message = storeChat$EditingMessage.message;
        }
        if ((i & 2) != 0) {
            charSequence = storeChat$EditingMessage.content;
        }
        return storeChat$EditingMessage.copy(message, charSequence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getContent() {
        return this.content;
    }

    public final StoreChat$EditingMessage copy(Message message, CharSequence content) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(content, "content");
        return new StoreChat$EditingMessage(message, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreChat$EditingMessage)) {
            return false;
        }
        StoreChat$EditingMessage storeChat$EditingMessage = (StoreChat$EditingMessage) other;
        return m.areEqual(this.message, storeChat$EditingMessage.message) && m.areEqual(this.content, storeChat$EditingMessage.content);
    }

    public final CharSequence getContent() {
        return this.content;
    }

    public final Message getMessage() {
        return this.message;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        CharSequence charSequence = this.content;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("EditingMessage(message=");
        sbU.append(this.message);
        sbU.append(", content=");
        return a.E(sbU, this.content, ")");
    }
}
