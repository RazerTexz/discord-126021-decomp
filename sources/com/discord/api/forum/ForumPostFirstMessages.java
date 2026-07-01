package com.discord.api.forum;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* JADX INFO: compiled from: ForumPostFirstMessages.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessages {
    private final Map<Long, ForumPostFirstMessages2> threads;

    public final Map<Long, ForumPostFirstMessages2> a() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessages) && Intrinsics3.areEqual(this.threads, ((ForumPostFirstMessages) other).threads);
        }
        return true;
    }

    public int hashCode() {
        Map<Long, ForumPostFirstMessages2> map = this.threads;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.M(outline.U("ForumPostFirstMessages(threads="), this.threads, ")");
    }
}
