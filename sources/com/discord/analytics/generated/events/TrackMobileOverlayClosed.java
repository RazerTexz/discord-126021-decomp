package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMobileOverlayClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMobileOverlayClosed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final CharSequence rtcConnectionId = null;
    private final transient String analyticsSchemaTypeName = "mobile_overlay_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMobileOverlayClosed)) {
            return false;
        }
        TrackMobileOverlayClosed trackMobileOverlayClosed = (TrackMobileOverlayClosed) other;
        return C12238m.areEqual(this.type, trackMobileOverlayClosed.type) && C12238m.areEqual(this.rtcConnectionId, trackMobileOverlayClosed.rtcConnectionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMobileOverlayClosed(type=");
        sbM833U.append(this.type);
        sbM833U.append(", rtcConnectionId=");
        return C1643a.m817E(sbM833U, this.rtcConnectionId, ")");
    }
}
