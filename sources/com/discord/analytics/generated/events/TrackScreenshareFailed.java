package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackScreenshareFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackScreenshareFailed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.sourceId, trackScreenshareFailed.sourceId) && C12238m.areEqual(this.screens, trackScreenshareFailed.screens) && C12238m.areEqual(this.windows, trackScreenshareFailed.windows);
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
        StringBuilder sbM833U = C1643a.m833U("TrackScreenshareFailed(sourceId=");
        sbM833U.append(this.sourceId);
        sbM833U.append(", screens=");
        sbM833U.append(this.screens);
        sbM833U.append(", windows=");
        return C1643a.m819G(sbM833U, this.windows, ")");
    }
}
