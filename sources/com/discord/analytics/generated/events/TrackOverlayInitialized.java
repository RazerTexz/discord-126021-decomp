package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackOverlayInitialized.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayInitialized implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean voiceWidgetConnected = null;
    private final Boolean textWidgetConnected = null;
    private final transient String analyticsSchemaTypeName = "overlay_initialized";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayInitialized)) {
            return false;
        }
        TrackOverlayInitialized trackOverlayInitialized = (TrackOverlayInitialized) other;
        return C12238m.areEqual(this.voiceWidgetConnected, trackOverlayInitialized.voiceWidgetConnected) && C12238m.areEqual(this.textWidgetConnected, trackOverlayInitialized.textWidgetConnected);
    }

    public int hashCode() {
        Boolean bool = this.voiceWidgetConnected;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.textWidgetConnected;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackOverlayInitialized(voiceWidgetConnected=");
        sbM833U.append(this.voiceWidgetConnected);
        sbM833U.append(", textWidgetConnected=");
        return C1643a.m816D(sbM833U, this.textWidgetConnected, ")");
    }
}
