package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackApplicationCommandLoadTiming.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandLoadTiming implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long durationMs = null;
    private final CharSequence method = null;
    private final CharSequence area = null;
    private final transient String analyticsSchemaTypeName = "application_command_load_timing";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationCommandLoadTiming)) {
            return false;
        }
        TrackApplicationCommandLoadTiming trackApplicationCommandLoadTiming = (TrackApplicationCommandLoadTiming) other;
        return m.areEqual(this.durationMs, trackApplicationCommandLoadTiming.durationMs) && m.areEqual(this.method, trackApplicationCommandLoadTiming.method) && m.areEqual(this.area, trackApplicationCommandLoadTiming.area);
    }

    public int hashCode() {
        Long l = this.durationMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.method;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.area;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackApplicationCommandLoadTiming(durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", method=");
        sbU.append(this.method);
        sbU.append(", area=");
        return a.E(sbU, this.area, ")");
    }
}
