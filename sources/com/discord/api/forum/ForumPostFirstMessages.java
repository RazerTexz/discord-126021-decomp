package com.discord.api.forum;

import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ForumPostFirstMessages.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessages {
    private final Map<Long, ForumPostFirstMessage> threads;

    /* JADX INFO: renamed from: a */
    public final Map<Long, ForumPostFirstMessage> m7821a() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessages) && C12238m.areEqual(this.threads, ((ForumPostFirstMessages) other).threads);
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
        return C1643a.m825M(C1643a.m833U("ForumPostFirstMessages(threads="), this.threads, ")");
    }
}
