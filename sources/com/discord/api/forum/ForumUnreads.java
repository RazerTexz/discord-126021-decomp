package com.discord.api.forum;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ForumUnreads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumUnreads {
    private final long channelId;
    private final boolean permissionDenied;
    private final List<ForumUnread> threads;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getPermissionDenied() {
        return this.permissionDenied;
    }

    /* JADX INFO: renamed from: b */
    public final List<ForumUnread> m7825b() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumUnreads)) {
            return false;
        }
        ForumUnreads forumUnreads = (ForumUnreads) other;
        return this.channelId == forumUnreads.channelId && this.permissionDenied == forumUnreads.permissionDenied && C12238m.areEqual(this.threads, forumUnreads.threads);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.permissionDenied;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (i + r0) * 31;
        List<ForumUnread> list = this.threads;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ForumUnreads(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", permissionDenied=");
        sbM833U.append(this.permissionDenied);
        sbM833U.append(", threads=");
        return C1643a.m824L(sbM833U, this.threads, ")");
    }
}
