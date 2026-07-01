package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreApplicationInteractions$ComponentLocation {
    private final int componentIndex;
    private final long messageId;

    public StoreApplicationInteractions$ComponentLocation(long j, int i) {
        this.messageId = j;
        this.componentIndex = i;
    }

    public static /* synthetic */ StoreApplicationInteractions$ComponentLocation copy$default(StoreApplicationInteractions$ComponentLocation storeApplicationInteractions$ComponentLocation, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = storeApplicationInteractions$ComponentLocation.messageId;
        }
        if ((i2 & 2) != 0) {
            i = storeApplicationInteractions$ComponentLocation.componentIndex;
        }
        return storeApplicationInteractions$ComponentLocation.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getComponentIndex() {
        return this.componentIndex;
    }

    public final StoreApplicationInteractions$ComponentLocation copy(long messageId, int componentIndex) {
        return new StoreApplicationInteractions$ComponentLocation(messageId, componentIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreApplicationInteractions$ComponentLocation)) {
            return false;
        }
        StoreApplicationInteractions$ComponentLocation storeApplicationInteractions$ComponentLocation = (StoreApplicationInteractions$ComponentLocation) other;
        return this.messageId == storeApplicationInteractions$ComponentLocation.messageId && this.componentIndex == storeApplicationInteractions$ComponentLocation.componentIndex;
    }

    public final int getComponentIndex() {
        return this.componentIndex;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        return (b.a(this.messageId) * 31) + this.componentIndex;
    }

    public String toString() {
        StringBuilder sbU = a.U("ComponentLocation(messageId=");
        sbU.append(this.messageId);
        sbU.append(", componentIndex=");
        return a.B(sbU, this.componentIndex, ")");
    }
}
