package com.discord.api.forum;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: ForumPostFirstMessages.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessages {
    private final Map<Long, ForumPostFirstMessage> threads;

    public final Map<Long, ForumPostFirstMessage> a() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessages) && m.areEqual(this.threads, ((ForumPostFirstMessages) other).threads);
        }
        return true;
    }

    public int hashCode() {
        Map<Long, ForumPostFirstMessage> map = this.threads;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.M(a.U("ForumPostFirstMessages(threads="), this.threads, ")");
    }
}
