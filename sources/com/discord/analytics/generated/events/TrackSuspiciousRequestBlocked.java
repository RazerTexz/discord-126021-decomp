package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSuspiciousRequestBlocked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSuspiciousRequestBlocked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence email = null;
    private final CharSequence headers = null;
    private final CharSequence path = null;
    private final CharSequence host = null;
    private final CharSequence endpoint = null;
    private final Boolean wasVerified = null;
    private final Boolean wasEmailVerificationNeeded = null;
    private final transient String analyticsSchemaTypeName = "suspicious_request_blocked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSuspiciousRequestBlocked)) {
            return false;
        }
        TrackSuspiciousRequestBlocked trackSuspiciousRequestBlocked = (TrackSuspiciousRequestBlocked) other;
        return Intrinsics3.areEqual(this.email, trackSuspiciousRequestBlocked.email) && Intrinsics3.areEqual(this.headers, trackSuspiciousRequestBlocked.headers) && Intrinsics3.areEqual(this.path, trackSuspiciousRequestBlocked.path) && Intrinsics3.areEqual(this.host, trackSuspiciousRequestBlocked.host) && Intrinsics3.areEqual(this.endpoint, trackSuspiciousRequestBlocked.endpoint) && Intrinsics3.areEqual(this.wasVerified, trackSuspiciousRequestBlocked.wasVerified) && Intrinsics3.areEqual(this.wasEmailVerificationNeeded, trackSuspiciousRequestBlocked.wasEmailVerificationNeeded);
    }

    public int hashCode() {
        CharSequence charSequence = this.email;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.headers;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.path;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.host;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.endpoint;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool = this.wasVerified;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.wasEmailVerificationNeeded;
        return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSuspiciousRequestBlocked(email=");
        sbU.append(this.email);
        sbU.append(", headers=");
        sbU.append(this.headers);
        sbU.append(", path=");
        sbU.append(this.path);
        sbU.append(", host=");
        sbU.append(this.host);
        sbU.append(", endpoint=");
        sbU.append(this.endpoint);
        sbU.append(", wasVerified=");
        sbU.append(this.wasVerified);
        sbU.append(", wasEmailVerificationNeeded=");
        return outline.D(sbU, this.wasEmailVerificationNeeded, ")");
    }
}
