package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOverlayLayoutUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayLayoutUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean wasResized = null;
    private final Boolean wasDragged = null;
    private final CharSequence widgetType = null;
    private final Long windowWidth = null;
    private final Long windowHeight = null;
    private final Long widgetWidth = null;
    private final Long widgetHeight = null;
    private final Long widgetLeft = null;
    private final Long widgetTop = null;
    private final transient String analyticsSchemaTypeName = "overlay_layout_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayLayoutUpdated)) {
            return false;
        }
        TrackOverlayLayoutUpdated trackOverlayLayoutUpdated = (TrackOverlayLayoutUpdated) other;
        return m.areEqual(this.wasResized, trackOverlayLayoutUpdated.wasResized) && m.areEqual(this.wasDragged, trackOverlayLayoutUpdated.wasDragged) && m.areEqual(this.widgetType, trackOverlayLayoutUpdated.widgetType) && m.areEqual(this.windowWidth, trackOverlayLayoutUpdated.windowWidth) && m.areEqual(this.windowHeight, trackOverlayLayoutUpdated.windowHeight) && m.areEqual(this.widgetWidth, trackOverlayLayoutUpdated.widgetWidth) && m.areEqual(this.widgetHeight, trackOverlayLayoutUpdated.widgetHeight) && m.areEqual(this.widgetLeft, trackOverlayLayoutUpdated.widgetLeft) && m.areEqual(this.widgetTop, trackOverlayLayoutUpdated.widgetTop);
    }

    public int hashCode() {
        Boolean bool = this.wasResized;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.wasDragged;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.widgetType;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.windowWidth;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.windowHeight;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.widgetWidth;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.widgetHeight;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.widgetLeft;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.widgetTop;
        return iHashCode8 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackOverlayLayoutUpdated(wasResized=");
        sbU.append(this.wasResized);
        sbU.append(", wasDragged=");
        sbU.append(this.wasDragged);
        sbU.append(", widgetType=");
        sbU.append(this.widgetType);
        sbU.append(", windowWidth=");
        sbU.append(this.windowWidth);
        sbU.append(", windowHeight=");
        sbU.append(this.windowHeight);
        sbU.append(", widgetWidth=");
        sbU.append(this.widgetWidth);
        sbU.append(", widgetHeight=");
        sbU.append(this.widgetHeight);
        sbU.append(", widgetLeft=");
        sbU.append(this.widgetLeft);
        sbU.append(", widgetTop=");
        return a.G(sbU, this.widgetTop, ")");
    }
}
