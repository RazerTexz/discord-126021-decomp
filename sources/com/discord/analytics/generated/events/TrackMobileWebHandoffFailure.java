package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMobileWebHandoffFailure.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMobileWebHandoffFailure implements AnalyticsSchema, TrackBaseReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long fingerprint;
    private final CharSequence reason;
    private TrackBase trackBase;

    public TrackMobileWebHandoffFailure() {
        this(null, null, 3);
    }

    public TrackMobileWebHandoffFailure(CharSequence charSequence, Long l, int i) {
        int i2 = i & 2;
        this.reason = (i & 1) != 0 ? null : charSequence;
        this.fingerprint = null;
        this.analyticsSchemaTypeName = "mobile_web_handoff_failure";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMobileWebHandoffFailure)) {
            return false;
        }
        TrackMobileWebHandoffFailure trackMobileWebHandoffFailure = (TrackMobileWebHandoffFailure) other;
        return C12238m.areEqual(this.reason, trackMobileWebHandoffFailure.reason) && C12238m.areEqual(this.fingerprint, trackMobileWebHandoffFailure.fingerprint);
    }

    public int hashCode() {
        CharSequence charSequence = this.reason;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.fingerprint;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMobileWebHandoffFailure(reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", fingerprint=");
        return C1643a.m819G(sbM833U, this.fingerprint, ")");
    }
}
