package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMessageReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageReplies$MessageState$Loaded extends StoreMessageReplies$MessageState {
    private final Message message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReplies$MessageState$Loaded(Message message) {
        super(null);
        m.checkNotNullParameter(message, "message");
        this.message = message;
    }

    public static /* synthetic */ StoreMessageReplies$MessageState$Loaded copy$default(StoreMessageReplies$MessageState$Loaded storeMessageReplies$MessageState$Loaded, Message message, int i, Object obj) {
        if ((i & 1) != 0) {
            message = storeMessageReplies$MessageState$Loaded.message;
        }
        return storeMessageReplies$MessageState$Loaded.copy(message);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageReplies$MessageState$Loaded copy(Message message) {
        m.checkNotNullParameter(message, "message");
        return new StoreMessageReplies$MessageState$Loaded(message);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreMessageReplies$MessageState$Loaded) && m.areEqual(this.message, ((StoreMessageReplies$MessageState$Loaded) other).message);
        }
        return true;
    }

    public final Message getMessage() {
        return this.message;
    }

    public int hashCode() {
        Message message = this.message;
        if (message != null) {
            return message.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(message=");
        sbU.append(this.message);
        sbU.append(")");
        return sbU.toString();
    }
}
