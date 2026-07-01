package com.discord.stores;

import b.d.b.a.a;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageAck$Companion$ThreadAckState$Thread extends StoreMessageAck$Companion$ThreadAckState {
    private final boolean canAckThread;

    public StoreMessageAck$Companion$ThreadAckState$Thread(boolean z2) {
        super(null);
        this.canAckThread = z2;
    }

    public static /* synthetic */ StoreMessageAck$Companion$ThreadAckState$Thread copy$default(StoreMessageAck$Companion$ThreadAckState$Thread storeMessageAck$Companion$ThreadAckState$Thread, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = storeMessageAck$Companion$ThreadAckState$Thread.canAckThread;
        }
        return storeMessageAck$Companion$ThreadAckState$Thread.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanAckThread() {
        return this.canAckThread;
    }

    public final StoreMessageAck$Companion$ThreadAckState$Thread copy(boolean canAckThread) {
        return new StoreMessageAck$Companion$ThreadAckState$Thread(canAckThread);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreMessageAck$Companion$ThreadAckState$Thread) && this.canAckThread == ((StoreMessageAck$Companion$ThreadAckState$Thread) other).canAckThread;
        }
        return true;
    }

    public final boolean getCanAckThread() {
        return this.canAckThread;
    }

    public int hashCode() {
        boolean z2 = this.canAckThread;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return a.O(a.U("Thread(canAckThread="), this.canAckThread, ")");
    }
}
