package com.discord.api.forum;

import b.d.b.a.a;
import com.discord.api.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: ForumPostFirstMessages.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessage {
    private final Message firstMessage;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Message getFirstMessage() {
        return this.firstMessage;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessage) && m.areEqual(this.firstMessage, ((ForumPostFirstMessage) other).firstMessage);
        }
        return true;
    }

    public int hashCode() {
        Message message = this.firstMessage;
        if (message != null) {
            return message.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ForumPostFirstMessage(firstMessage=");
        sbU.append(this.firstMessage);
        sbU.append(")");
        return sbU.toString();
    }
}
