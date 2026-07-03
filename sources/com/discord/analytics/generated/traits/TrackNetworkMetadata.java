package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNetworkMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkMetadata {
    private final Long errorCode;
    private final CharSequence errorMessage;
    private final CharSequence requestMethod;
    private final Long statusCode;
    private final CharSequence url;

    public TrackNetworkMetadata() {
        this(null, null, null, null, null, 31);
    }

    public TrackNetworkMetadata(CharSequence charSequence, CharSequence charSequence2, Long l, Long l2, CharSequence charSequence3) {
        this.url = charSequence;
        this.requestMethod = charSequence2;
        this.statusCode = l;
        this.errorCode = l2;
        this.errorMessage = charSequence3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkMetadata)) {
            return false;
        }
        TrackNetworkMetadata trackNetworkMetadata = (TrackNetworkMetadata) other;
        return C12238m.areEqual(this.url, trackNetworkMetadata.url) && C12238m.areEqual(this.requestMethod, trackNetworkMetadata.requestMethod) && C12238m.areEqual(this.statusCode, trackNetworkMetadata.statusCode) && C12238m.areEqual(this.errorCode, trackNetworkMetadata.errorCode) && C12238m.areEqual(this.errorMessage, trackNetworkMetadata.errorMessage);
    }

    public int hashCode() {
        CharSequence charSequence = this.url;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.requestMethod;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.statusCode;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.errorCode;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.errorMessage;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkMetadata(url=");
        sbM833U.append(this.url);
        sbM833U.append(", requestMethod=");
        sbM833U.append(this.requestMethod);
        sbM833U.append(", statusCode=");
        sbM833U.append(this.statusCode);
        sbM833U.append(", errorCode=");
        sbM833U.append(this.errorCode);
        sbM833U.append(", errorMessage=");
        return C1643a.m817E(sbM833U, this.errorMessage, ")");
    }

    public TrackNetworkMetadata(CharSequence charSequence, CharSequence charSequence2, Long l, Long l2, CharSequence charSequence3, int i) {
        charSequence = (i & 1) != 0 ? null : charSequence;
        charSequence2 = (i & 2) != 0 ? null : charSequence2;
        l = (i & 4) != 0 ? null : l;
        int i2 = i & 8;
        charSequence3 = (i & 16) != 0 ? null : charSequence3;
        this.url = charSequence;
        this.requestMethod = charSequence2;
        this.statusCode = l;
        this.errorCode = null;
        this.errorMessage = charSequence3;
    }
}
