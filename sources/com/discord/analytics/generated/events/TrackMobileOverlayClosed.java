package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.type, trackMobileOverlayClosed.type) && m.areEqual(this.rtcConnectionId, trackMobileOverlayClosed.rtcConnectionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMobileOverlayClosed(type=");
        sbU.append(this.type);
        sbU.append(", rtcConnectionId=");
        return a.E(sbU, this.rtcConnectionId, ")");
    }
}
