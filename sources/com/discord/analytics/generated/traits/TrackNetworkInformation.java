package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.connectionType, trackNetworkInformation.connectionType) && Intrinsics3.areEqual(this.effectiveConnectionSpeed, trackNetworkInformation.effectiveConnectionSpeed) && Intrinsics3.areEqual(this.serviceProvider, trackNetworkInformation.serviceProvider);
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
        StringBuilder sbU = outline.U("TrackNetworkInformation(connectionType=");
        sbU.append(this.connectionType);
        sbU.append(", effectiveConnectionSpeed=");
        sbU.append(this.effectiveConnectionSpeed);
        sbU.append(", serviceProvider=");
        return outline.E(sbU, this.serviceProvider, ")");
    }
}
