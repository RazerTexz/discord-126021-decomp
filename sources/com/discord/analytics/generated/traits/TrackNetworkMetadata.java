package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

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
        return m.areEqual(this.url, trackNetworkMetadata.url) && m.areEqual(this.requestMethod, trackNetworkMetadata.requestMethod) && m.areEqual(this.statusCode, trackNetworkMetadata.statusCode) && m.areEqual(this.errorCode, trackNetworkMetadata.errorCode) && m.areEqual(this.errorMessage, trackNetworkMetadata.errorMessage);
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
        StringBuilder sbU = a.U("TrackNetworkMetadata(url=");
        sbU.append(this.url);
        sbU.append(", requestMethod=");
        sbU.append(this.requestMethod);
        sbU.append(", statusCode=");
        sbU.append(this.statusCode);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", errorMessage=");
        return a.E(sbU, this.errorMessage, ")");
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
