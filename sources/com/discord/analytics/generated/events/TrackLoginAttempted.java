package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLoginAttempted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLoginAttempted implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.fingerprint, trackLoginAttempted.fingerprint) && C12238m.areEqual(this.identityType, trackLoginAttempted.identityType);
    }

    public int hashCode() {
        Long l = this.fingerprint;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.identityType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackLoginAttempted(fingerprint=");
        sbM833U.append(this.fingerprint);
        sbM833U.append(", identityType=");
        return C1643a.m817E(sbM833U, this.identityType, ")");
    }
}
