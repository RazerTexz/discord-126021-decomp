package com.discord.api.forum;

import com.discord.api.message.Message;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            return (other instanceof ForumPostFirstMessage) && C12238m.areEqual(this.firstMessage, ((ForumPostFirstMessage) other).firstMessage);
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
        StringBuilder sbM833U = C1643a.m833U("ForumPostFirstMessage(firstMessage=");
        sbM833U.append(this.firstMessage);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
