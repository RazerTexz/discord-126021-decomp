package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackLoginAttempted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLoginAttempted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long fingerprint = null;
    private final CharSequence identityType = null;
    private final transient String analyticsSchemaTypeName = "login_attempted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLoginAttempted)) {
            return false;
        }
        TrackLoginAttempted trackLoginAttempted = (TrackLoginAttempted) other;
        return Intrinsics3.areEqual(this.fingerprint, trackLoginAttempted.fingerprint) && Intrinsics3.areEqual(this.identityType, trackLoginAttempted.identityType);
    }

    public int hashCode() {
        Long l = this.fingerprint;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.identityType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLoginAttempted(fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", identityType=");
        return outline.E(sbU, this.identityType, ")");
    }
}
