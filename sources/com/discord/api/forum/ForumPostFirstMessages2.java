package com.discord.api.forum;

import b.d.b.a.outline;
import com.discord.api.message.Message;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.forum.ForumPostFirstMessage, reason: use source file name */
/* JADX INFO: compiled from: ForumPostFirstMessages.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessages2 {
    private final Message firstMessage;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Message getFirstMessage() {
        return this.firstMessage;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessages2) && Intrinsics3.areEqual(this.firstMessage, ((ForumPostFirstMessages2) other).firstMessage);
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
        StringBuilder sbU = outline.U("ForumPostFirstMessage(firstMessage=");
        sbU.append(this.firstMessage);
        sbU.append(")");
        return sbU.toString();
    }
}
