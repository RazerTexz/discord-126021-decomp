package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackOverlayHooked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayHooked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence nonce = null;
    private final CharSequence graphicsApi = null;
    private final transient String analyticsSchemaTypeName = "overlay_hooked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayHooked)) {
            return false;
        }
        TrackOverlayHooked trackOverlayHooked = (TrackOverlayHooked) other;
        return Intrinsics3.areEqual(this.nonce, trackOverlayHooked.nonce) && Intrinsics3.areEqual(this.graphicsApi, trackOverlayHooked.graphicsApi);
    }

    public int hashCode() {
        CharSequence charSequence = this.nonce;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.graphicsApi;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayHooked(nonce=");
        sbU.append(this.nonce);
        sbU.append(", graphicsApi=");
        return outline.E(sbU, this.graphicsApi, ")");
    }
}
