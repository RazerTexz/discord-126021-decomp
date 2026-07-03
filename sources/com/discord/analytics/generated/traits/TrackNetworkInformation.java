package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.connectionType, trackNetworkInformation.connectionType) && C12238m.areEqual(this.effectiveConnectionSpeed, trackNetworkInformation.effectiveConnectionSpeed) && C12238m.areEqual(this.serviceProvider, trackNetworkInformation.serviceProvider);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkInformation(connectionType=");
        sbM833U.append(this.connectionType);
        sbM833U.append(", effectiveConnectionSpeed=");
        sbM833U.append(this.effectiveConnectionSpeed);
        sbM833U.append(", serviceProvider=");
        return C1643a.m817E(sbM833U, this.serviceProvider, ")");
    }
}
