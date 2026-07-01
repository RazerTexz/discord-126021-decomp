package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackOverlayPinToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayPinToggled implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean pinned = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final CharSequence widgetType = null;
    private final transient String analyticsSchemaTypeName = "overlay_pin_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayPinToggled)) {
            return false;
        }
        TrackOverlayPinToggled trackOverlayPinToggled = (TrackOverlayPinToggled) other;
        return Intrinsics3.areEqual(this.pinned, trackOverlayPinToggled.pinned) && Intrinsics3.areEqual(this.guildId, trackOverlayPinToggled.guildId) && Intrinsics3.areEqual(this.channelId, trackOverlayPinToggled.channelId) && Intrinsics3.areEqual(this.channelType, trackOverlayPinToggled.channelType) && Intrinsics3.areEqual(this.widgetType, trackOverlayPinToggled.widgetType);
    }

    public int hashCode() {
        Boolean bool = this.pinned;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.widgetType;
        return iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayPinToggled(pinned=");
        sbU.append(this.pinned);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", widgetType=");
        return outline.E(sbU, this.widgetType, ")");
    }
}
