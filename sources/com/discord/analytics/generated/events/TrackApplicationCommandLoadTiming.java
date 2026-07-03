package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.durationMs, trackApplicationCommandLoadTiming.durationMs) && C12238m.areEqual(this.method, trackApplicationCommandLoadTiming.method) && C12238m.areEqual(this.area, trackApplicationCommandLoadTiming.area);
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
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationCommandLoadTiming(durationMs=");
        sbM833U.append(this.durationMs);
        sbM833U.append(", method=");
        sbM833U.append(this.method);
        sbM833U.append(", area=");
        return C1643a.m817E(sbM833U, this.area, ")");
    }
}
