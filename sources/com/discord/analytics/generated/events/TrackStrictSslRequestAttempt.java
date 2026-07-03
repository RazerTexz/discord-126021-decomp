package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStrictSslRequestAttempt.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStrictSslRequestAttempt implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final CharSequence method = null;
    private final transient String analyticsSchemaTypeName = "strict_ssl_request_attempt";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStrictSslRequestAttempt)) {
            return false;
        }
        TrackStrictSslRequestAttempt trackStrictSslRequestAttempt = (TrackStrictSslRequestAttempt) other;
        return C12238m.areEqual(this.success, trackStrictSslRequestAttempt.success) && C12238m.areEqual(this.method, trackStrictSslRequestAttempt.method);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.method;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStrictSslRequestAttempt(success=");
        sbM833U.append(this.success);
        sbM833U.append(", method=");
        return C1643a.m817E(sbM833U, this.method, ")");
    }
}
