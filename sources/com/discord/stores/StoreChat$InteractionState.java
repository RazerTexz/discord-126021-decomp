package com.discord.stores;

import a0.a.a.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreChat$InteractionState {
    public static final StoreChat$InteractionState$Companion Companion = new StoreChat$InteractionState$Companion(null);
    private static final int NEAR_EDGE_THRESHOLD = 15;
    private static final int SCROLLED = 0;
    private static final int SCROLLED_BOTTOM = 1;
    private static final int SCROLLED_NEAR_BOTTOM = 4;
    private static final int SCROLLED_TOP = 2;
    private final long channelId;
    private final boolean isAtBottom;
    private final boolean isAtTop;
    private final boolean isTouchedSinceLastJump;
    private final long lastMessageId;

    /* JADX INFO: renamed from: scrollState$1, reason: from kotlin metadata */
    private final int scrollState;

    public StoreChat$InteractionState(long j, long j2, boolean z2, int i) {
        this.channelId = j;
        this.lastMessageId = j2;
        this.isTouchedSinceLastJump = z2;
        this.scrollState = i;
        this.isAtTop = z2 && isAtTopIgnoringTouch();
        this.isAtBottom = z2 && isAtBottomIgnoringTouch();
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final int getScrollState() {
        return this.scrollState;
    }

    public static /* synthetic */ StoreChat$InteractionState copy$default(StoreChat$InteractionState storeChat$InteractionState, long j, long j2, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = storeChat$InteractionState.channelId;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = storeChat$InteractionState.lastMessageId;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            z2 = storeChat$InteractionState.isTouchedSinceLastJump;
        }
        boolean z3 = z2;
        if ((i2 & 8) != 0) {
            i = storeChat$InteractionState.scrollState;
        }
        return storeChat$InteractionState.copy(j3, j4, z3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsTouchedSinceLastJump() {
        return this.isTouchedSinceLastJump;
    }

    public final StoreChat$InteractionState copy(long channelId, long lastMessageId, boolean isTouchedSinceLastJump, int scrollState) {
        return new StoreChat$InteractionState(channelId, lastMessageId, isTouchedSinceLastJump, scrollState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreChat$InteractionState)) {
            return false;
        }
        StoreChat$InteractionState storeChat$InteractionState = (StoreChat$InteractionState) other;
        return this.channelId == storeChat$InteractionState.channelId && this.lastMessageId == storeChat$InteractionState.lastMessageId && this.isTouchedSinceLastJump == storeChat$InteractionState.isTouchedSinceLastJump && this.scrollState == storeChat$InteractionState.scrollState;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iA = (b.a(this.lastMessageId) + (b.a(this.channelId) * 31)) * 31;
        boolean z2 = this.isTouchedSinceLastJump;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return ((iA + r0) * 31) + this.scrollState;
    }

    /* JADX INFO: renamed from: isAtBottom, reason: from getter */
    public final boolean getIsAtBottom() {
        return this.isAtBottom;
    }

    public final boolean isAtBottomIgnoringTouch() {
        return (this.scrollState & 1) != 0;
    }

    /* JADX INFO: renamed from: isAtTop, reason: from getter */
    public final boolean getIsAtTop() {
        return this.isAtTop;
    }

    public final boolean isAtTopIgnoringTouch() {
        return (this.scrollState & 2) != 0;
    }

    public final boolean isNearBottomIgnoringTouch() {
        return (this.scrollState & 4) != 0;
    }

    public final boolean isTouchedSinceLastJump() {
        return this.isTouchedSinceLastJump;
    }

    public String toString() {
        StringBuilder sbU = a.U("InteractionState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", lastMessageId=");
        sbU.append(this.lastMessageId);
        sbU.append(", isTouchedSinceLastJump=");
        sbU.append(this.isTouchedSinceLastJump);
        sbU.append(", scrollState=");
        return a.B(sbU, this.scrollState, ")");
    }

    public StoreChat$InteractionState(long j, long j2, boolean z2, LinearLayoutManager linearLayoutManager) {
        this(j, j2, z2, StoreChat$InteractionState$Companion.access$getScrollState$p(Companion, linearLayoutManager));
    }
}
