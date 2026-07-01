package com.discord.widgets.forums;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: ForumPostReadState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ForumPostReadState {
    public static final ForumPostReadState$Companion Companion = new ForumPostReadState$Companion(null);
    private final long channelId;
    private final boolean hasSeenBefore;
    private final boolean hasUnread;

    public ForumPostReadState(long j, boolean z2, boolean z3) {
        this.channelId = j;
        this.hasSeenBefore = z2;
        this.hasUnread = z3;
    }

    public static /* synthetic */ ForumPostReadState copy$default(ForumPostReadState forumPostReadState, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = forumPostReadState.channelId;
        }
        if ((i & 2) != 0) {
            z2 = forumPostReadState.hasSeenBefore;
        }
        if ((i & 4) != 0) {
            z3 = forumPostReadState.hasUnread;
        }
        return forumPostReadState.copy(j, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasSeenBefore() {
        return this.hasSeenBefore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasUnread() {
        return this.hasUnread;
    }

    public final ForumPostReadState copy(long channelId, boolean hasSeenBefore, boolean hasUnread) {
        return new ForumPostReadState(channelId, hasSeenBefore, hasUnread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumPostReadState)) {
            return false;
        }
        ForumPostReadState forumPostReadState = (ForumPostReadState) other;
        return this.channelId == forumPostReadState.channelId && this.hasSeenBefore == forumPostReadState.hasSeenBefore && this.hasUnread == forumPostReadState.hasUnread;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final boolean getHasSeenBefore() {
        return this.hasSeenBefore;
    }

    public final boolean getHasUnread() {
        return this.hasUnread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        boolean z2 = this.hasSeenBefore;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iA + r1) * 31;
        boolean z3 = this.hasUnread;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("ForumPostReadState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", hasSeenBefore=");
        sbU.append(this.hasSeenBefore);
        sbU.append(", hasUnread=");
        return a.O(sbU, this.hasUnread, ")");
    }
}
