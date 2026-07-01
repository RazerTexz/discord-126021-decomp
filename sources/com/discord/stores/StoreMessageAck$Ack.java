package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelReadState;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageAck$Ack {
    private final boolean isLockedAck;
    private final long messageId;
    private final boolean viewed;

    public StoreMessageAck$Ack(long j, boolean z2, boolean z3) {
        this.messageId = j;
        this.viewed = z2;
        this.isLockedAck = z3;
    }

    public static /* synthetic */ StoreMessageAck$Ack copy$default(StoreMessageAck$Ack storeMessageAck$Ack, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeMessageAck$Ack.messageId;
        }
        if ((i & 2) != 0) {
            z2 = storeMessageAck$Ack.viewed;
        }
        if ((i & 4) != 0) {
            z3 = storeMessageAck$Ack.isLockedAck;
        }
        return storeMessageAck$Ack.copy(j, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getViewed() {
        return this.viewed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLockedAck() {
        return this.isLockedAck;
    }

    public final StoreMessageAck$Ack copy(long messageId, boolean viewed, boolean isLockedAck) {
        return new StoreMessageAck$Ack(messageId, viewed, isLockedAck);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessageAck$Ack)) {
            return false;
        }
        StoreMessageAck$Ack storeMessageAck$Ack = (StoreMessageAck$Ack) other;
        return this.messageId == storeMessageAck$Ack.messageId && this.viewed == storeMessageAck$Ack.viewed && this.isLockedAck == storeMessageAck$Ack.isLockedAck;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final boolean getViewed() {
        return this.viewed;
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
        int iA = b.a(this.messageId) * 31;
        boolean z2 = this.viewed;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iA + r1) * 31;
        boolean z3 = this.isLockedAck;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isLockedAck() {
        return this.isLockedAck;
    }

    public String toString() {
        StringBuilder sbU = a.U("Ack(messageId=");
        sbU.append(this.messageId);
        sbU.append(", viewed=");
        sbU.append(this.viewed);
        sbU.append(", isLockedAck=");
        return a.O(sbU, this.isLockedAck, ")");
    }

    public StoreMessageAck$Ack(ModelReadState modelReadState, boolean z2, boolean z3) {
        this(modelReadState != null ? modelReadState.getLastMessageId() : 0L, z2, z3);
    }
}
