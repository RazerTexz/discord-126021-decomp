package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageAck$PendingAck {
    public static final StoreMessageAck$PendingAck$Companion Companion = new StoreMessageAck$PendingAck$Companion(null);
    private static final StoreMessageAck$PendingAck EMPTY = new StoreMessageAck$PendingAck(0, new StoreMessageAck$Ack(0L, false, false));
    private final StoreMessageAck$Ack ack;
    private final long channelId;

    public StoreMessageAck$PendingAck(long j, StoreMessageAck$Ack storeMessageAck$Ack) {
        m.checkNotNullParameter(storeMessageAck$Ack, "ack");
        this.channelId = j;
        this.ack = storeMessageAck$Ack;
    }

    public static final /* synthetic */ StoreMessageAck$PendingAck access$getEMPTY$cp() {
        return EMPTY;
    }

    public static /* synthetic */ StoreMessageAck$PendingAck copy$default(StoreMessageAck$PendingAck storeMessageAck$PendingAck, long j, StoreMessageAck$Ack storeMessageAck$Ack, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeMessageAck$PendingAck.channelId;
        }
        if ((i & 2) != 0) {
            storeMessageAck$Ack = storeMessageAck$PendingAck.ack;
        }
        return storeMessageAck$PendingAck.copy(j, storeMessageAck$Ack);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreMessageAck$Ack getAck() {
        return this.ack;
    }

    public final StoreMessageAck$PendingAck copy(long channelId, StoreMessageAck$Ack ack) {
        m.checkNotNullParameter(ack, "ack");
        return new StoreMessageAck$PendingAck(channelId, ack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessageAck$PendingAck)) {
            return false;
        }
        StoreMessageAck$PendingAck storeMessageAck$PendingAck = (StoreMessageAck$PendingAck) other;
        return this.channelId == storeMessageAck$PendingAck.channelId && m.areEqual(this.ack, storeMessageAck$PendingAck.ack);
    }

    public final StoreMessageAck$Ack getAck() {
        return this.ack;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        StoreMessageAck$Ack storeMessageAck$Ack = this.ack;
        return iA + (storeMessageAck$Ack != null ? storeMessageAck$Ack.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PendingAck(channelId=");
        sbU.append(this.channelId);
        sbU.append(", ack=");
        sbU.append(this.ack);
        sbU.append(")");
        return sbU.toString();
    }
}
