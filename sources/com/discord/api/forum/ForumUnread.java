package com.discord.api.forum;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ForumUnread.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumUnread {
    private final Integer count;
    private final boolean missing;
    private final long threadId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumUnread)) {
            return false;
        }
        ForumUnread forumUnread = (ForumUnread) other;
        return this.threadId == forumUnread.threadId && this.missing == forumUnread.missing && C12238m.areEqual(this.count, forumUnread.count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public int hashCode() {
        long j = this.threadId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.missing;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (i + r0) * 31;
        Integer num = this.count;
        return i2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ForumUnread(threadId=");
        sbM833U.append(this.threadId);
        sbM833U.append(", missing=");
        sbM833U.append(this.missing);
        sbM833U.append(", count=");
        return C1643a.m818F(sbM833U, this.count, ")");
    }
}
