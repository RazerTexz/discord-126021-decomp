package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAppExternalViewClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppExternalViewClosed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final Long durationOpenMs = null;
    private final transient String analyticsSchemaTypeName = "app_external_view_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppExternalViewClosed)) {
            return false;
        }
        TrackAppExternalViewClosed trackAppExternalViewClosed = (TrackAppExternalViewClosed) other;
        return m.areEqual(this.type, trackAppExternalViewClosed.type) && m.areEqual(this.durationOpenMs, trackAppExternalViewClosed.durationOpenMs);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.durationOpenMs;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAppExternalViewClosed(type=");
        sbU.append(this.type);
        sbU.append(", durationOpenMs=");
        return a.G(sbU, this.durationOpenMs, ")");
    }
}
