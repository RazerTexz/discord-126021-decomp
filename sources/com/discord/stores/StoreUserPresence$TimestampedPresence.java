package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.presence.Presence;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreUserPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreUserPresence$TimestampedPresence {
    private final Presence presence;
    private final long timestamp;

    public StoreUserPresence$TimestampedPresence(Presence presence, long j) {
        m.checkNotNullParameter(presence, "presence");
        this.presence = presence;
        this.timestamp = j;
    }

    public static /* synthetic */ StoreUserPresence$TimestampedPresence copy$default(StoreUserPresence$TimestampedPresence storeUserPresence$TimestampedPresence, Presence presence, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            presence = storeUserPresence$TimestampedPresence.presence;
        }
        if ((i & 2) != 0) {
            j = storeUserPresence$TimestampedPresence.timestamp;
        }
        return storeUserPresence$TimestampedPresence.copy(presence, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final StoreUserPresence$TimestampedPresence copy(Presence presence, long timestamp) {
        m.checkNotNullParameter(presence, "presence");
        return new StoreUserPresence$TimestampedPresence(presence, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreUserPresence$TimestampedPresence)) {
            return false;
        }
        StoreUserPresence$TimestampedPresence storeUserPresence$TimestampedPresence = (StoreUserPresence$TimestampedPresence) other;
        return m.areEqual(this.presence, storeUserPresence$TimestampedPresence.presence) && this.timestamp == storeUserPresence$TimestampedPresence.timestamp;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        Presence presence = this.presence;
        return b.a(this.timestamp) + ((presence != null ? presence.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("TimestampedPresence(presence=");
        sbU.append(this.presence);
        sbU.append(", timestamp=");
        return a.C(sbU, this.timestamp, ")");
    }
}
