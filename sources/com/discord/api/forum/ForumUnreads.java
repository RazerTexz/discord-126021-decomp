package com.discord.api.forum;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

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

    public final List<ForumUnread> b() {
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
        return this.channelId == forumUnreads.channelId && this.permissionDenied == forumUnreads.permissionDenied && m.areEqual(this.threads, forumUnreads.threads);
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
        StringBuilder sbU = a.U("ForumUnreads(channelId=");
        sbU.append(this.channelId);
        sbU.append(", permissionDenied=");
        sbU.append(this.permissionDenied);
        sbU.append(", threads=");
        return a.L(sbU, this.threads, ")");
    }
}
