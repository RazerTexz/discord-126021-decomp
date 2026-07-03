package com.discord.widgets.forums;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: compiled from: ForumPostReadState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ForumPostReadState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final boolean hasSeenBefore;
    private final boolean hasUnread;

    /* JADX INFO: compiled from: ForumPostReadState.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ForumPostReadState createDefault(long channelId) {
            return new ForumPostReadState(channelId, true, false);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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
        int iM3a = C0002b.m3a(this.channelId) * 31;
        boolean z2 = this.hasSeenBefore;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iM3a + r1) * 31;
        boolean z3 = this.hasUnread;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ForumPostReadState(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", hasSeenBefore=");
        sbM833U.append(this.hasSeenBefore);
        sbM833U.append(", hasUnread=");
        return C1643a.m827O(sbM833U, this.hasUnread, ")");
    }
}
