package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLfgBrowserExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgBrowserExited implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long duration = null;
    private final Long numGroups = null;
    private final transient String analyticsSchemaTypeName = "lfg_browser_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgBrowserExited)) {
            return false;
        }
        TrackLfgBrowserExited trackLfgBrowserExited = (TrackLfgBrowserExited) other;
        return m.areEqual(this.duration, trackLfgBrowserExited.duration) && m.areEqual(this.numGroups, trackLfgBrowserExited.numGroups);
    }

    public int hashCode() {
        Long l = this.duration;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numGroups;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLfgBrowserExited(duration=");
        sbU.append(this.duration);
        sbU.append(", numGroups=");
        return a.G(sbU, this.numGroups, ")");
    }
}
