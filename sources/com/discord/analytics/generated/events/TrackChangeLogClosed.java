package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackChangeLogClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChangeLogClosed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence changeLogId = null;
    private final Float secondsOpen = null;
    private final Float maxScrolledPercentage = null;
    private final transient String analyticsSchemaTypeName = "change_log_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChangeLogClosed)) {
            return false;
        }
        TrackChangeLogClosed trackChangeLogClosed = (TrackChangeLogClosed) other;
        return Intrinsics3.areEqual(this.changeLogId, trackChangeLogClosed.changeLogId) && Intrinsics3.areEqual(this.secondsOpen, trackChangeLogClosed.secondsOpen) && Intrinsics3.areEqual(this.maxScrolledPercentage, trackChangeLogClosed.maxScrolledPercentage);
    }

    public int hashCode() {
        CharSequence charSequence = this.changeLogId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Float f = this.secondsOpen;
        int iHashCode2 = (iHashCode + (f != null ? f.hashCode() : 0)) * 31;
        Float f2 = this.maxScrolledPercentage;
        return iHashCode2 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackChangeLogClosed(changeLogId=");
        sbU.append(this.changeLogId);
        sbU.append(", secondsOpen=");
        sbU.append(this.secondsOpen);
        sbU.append(", maxScrolledPercentage=");
        sbU.append(this.maxScrolledPercentage);
        sbU.append(")");
        return sbU.toString();
    }
}
