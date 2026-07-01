package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessagesLoader$ChannelLoadedState {
    private final boolean isInitialMessagesLoaded;
    private final boolean isLoadingMessages;
    private final boolean isOldestMessagesLoaded;
    private final boolean isTouchedSinceLastJump;
    private final Long newestSentByUserMessageId;

    public StoreMessagesLoader$ChannelLoadedState() {
        this(false, false, false, false, null, 31, null);
    }

    public StoreMessagesLoader$ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l) {
        this.isInitialMessagesLoaded = z2;
        this.isOldestMessagesLoaded = z3;
        this.isLoadingMessages = z4;
        this.isTouchedSinceLastJump = z5;
        this.newestSentByUserMessageId = l;
    }

    public static /* synthetic */ StoreMessagesLoader$ChannelLoadedState copy$default(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState, boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = storeMessagesLoader$ChannelLoadedState.isInitialMessagesLoaded;
        }
        if ((i & 2) != 0) {
            z3 = storeMessagesLoader$ChannelLoadedState.isOldestMessagesLoaded;
        }
        boolean z6 = z3;
        if ((i & 4) != 0) {
            z4 = storeMessagesLoader$ChannelLoadedState.isLoadingMessages;
        }
        boolean z7 = z4;
        if ((i & 8) != 0) {
            z5 = storeMessagesLoader$ChannelLoadedState.isTouchedSinceLastJump;
        }
        boolean z8 = z5;
        if ((i & 16) != 0) {
            l = storeMessagesLoader$ChannelLoadedState.newestSentByUserMessageId;
        }
        return storeMessagesLoader$ChannelLoadedState.copy(z2, z6, z7, z8, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsInitialMessagesLoaded() {
        return this.isInitialMessagesLoaded;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsOldestMessagesLoaded() {
        return this.isOldestMessagesLoaded;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLoadingMessages() {
        return this.isLoadingMessages;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsTouchedSinceLastJump() {
        return this.isTouchedSinceLastJump;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    public final StoreMessagesLoader$ChannelLoadedState copy(boolean isInitialMessagesLoaded, boolean isOldestMessagesLoaded, boolean isLoadingMessages, boolean isTouchedSinceLastJump, Long newestSentByUserMessageId) {
        return new StoreMessagesLoader$ChannelLoadedState(isInitialMessagesLoaded, isOldestMessagesLoaded, isLoadingMessages, isTouchedSinceLastJump, newestSentByUserMessageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessagesLoader$ChannelLoadedState)) {
            return false;
        }
        StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState = (StoreMessagesLoader$ChannelLoadedState) other;
        return this.isInitialMessagesLoaded == storeMessagesLoader$ChannelLoadedState.isInitialMessagesLoaded && this.isOldestMessagesLoaded == storeMessagesLoader$ChannelLoadedState.isOldestMessagesLoaded && this.isLoadingMessages == storeMessagesLoader$ChannelLoadedState.isLoadingMessages && this.isTouchedSinceLastJump == storeMessagesLoader$ChannelLoadedState.isTouchedSinceLastJump && m.areEqual(this.newestSentByUserMessageId, storeMessagesLoader$ChannelLoadedState.newestSentByUserMessageId);
    }

    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z2 = this.isInitialMessagesLoaded;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isOldestMessagesLoaded;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isLoadingMessages;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isTouchedSinceLastJump;
        int i4 = (i3 + (z5 ? 1 : z5)) * 31;
        Long l = this.newestSentByUserMessageId;
        return i4 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isInitialMessagesLoaded() {
        return this.isInitialMessagesLoaded;
    }

    public final boolean isLoadingMessages() {
        return this.isLoadingMessages;
    }

    public final boolean isOldestMessagesLoaded() {
        return this.isOldestMessagesLoaded;
    }

    public final boolean isTouchedSinceLastJump() {
        return this.isTouchedSinceLastJump;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelLoadedState(isInitialMessagesLoaded=");
        sbU.append(this.isInitialMessagesLoaded);
        sbU.append(", isOldestMessagesLoaded=");
        sbU.append(this.isOldestMessagesLoaded);
        sbU.append(", isLoadingMessages=");
        sbU.append(this.isLoadingMessages);
        sbU.append(", isTouchedSinceLastJump=");
        sbU.append(this.isTouchedSinceLastJump);
        sbU.append(", newestSentByUserMessageId=");
        return a.G(sbU, this.newestSentByUserMessageId, ")");
    }

    public /* synthetic */ StoreMessagesLoader$ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) == 0 ? z5 : false, (i & 16) != 0 ? null : l);
    }
}
