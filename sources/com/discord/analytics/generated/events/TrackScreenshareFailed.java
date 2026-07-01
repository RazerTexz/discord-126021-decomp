package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackScreenshareFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackScreenshareFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence sourceId = null;
    private final Long screens = null;
    private final Long windows = null;
    private final transient String analyticsSchemaTypeName = "screenshare_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackScreenshareFailed)) {
            return false;
        }
        TrackScreenshareFailed trackScreenshareFailed = (TrackScreenshareFailed) other;
        return Intrinsics3.areEqual(this.sourceId, trackScreenshareFailed.sourceId) && Intrinsics3.areEqual(this.screens, trackScreenshareFailed.screens) && Intrinsics3.areEqual(this.windows, trackScreenshareFailed.windows);
    }

    public int hashCode() {
        CharSequence charSequence = this.sourceId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.screens;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.windows;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackScreenshareFailed(sourceId=");
        sbU.append(this.sourceId);
        sbU.append(", screens=");
        sbU.append(this.screens);
        sbU.append(", windows=");
        return outline.G(sbU, this.windows, ")");
    }
}
