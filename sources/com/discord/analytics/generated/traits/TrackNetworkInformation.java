package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNetworkInformation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkInformation {
    private final CharSequence connectionType = null;
    private final CharSequence effectiveConnectionSpeed = null;
    private final CharSequence serviceProvider = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkInformation)) {
            return false;
        }
        TrackNetworkInformation trackNetworkInformation = (TrackNetworkInformation) other;
        return m.areEqual(this.connectionType, trackNetworkInformation.connectionType) && m.areEqual(this.effectiveConnectionSpeed, trackNetworkInformation.effectiveConnectionSpeed) && m.areEqual(this.serviceProvider, trackNetworkInformation.serviceProvider);
    }

    public int hashCode() {
        CharSequence charSequence = this.connectionType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.effectiveConnectionSpeed;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.serviceProvider;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNetworkInformation(connectionType=");
        sbU.append(this.connectionType);
        sbU.append(", effectiveConnectionSpeed=");
        sbU.append(this.effectiveConnectionSpeed);
        sbU.append(", serviceProvider=");
        return a.E(sbU, this.serviceProvider, ")");
    }
}
