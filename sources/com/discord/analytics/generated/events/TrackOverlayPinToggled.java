package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackOverlayPinToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayPinToggled implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
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
        return C12238m.areEqual(this.pinned, trackOverlayPinToggled.pinned) && C12238m.areEqual(this.guildId, trackOverlayPinToggled.guildId) && C12238m.areEqual(this.channelId, trackOverlayPinToggled.channelId) && C12238m.areEqual(this.channelType, trackOverlayPinToggled.channelType) && C12238m.areEqual(this.widgetType, trackOverlayPinToggled.widgetType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackOverlayPinToggled(pinned=");
        sbM833U.append(this.pinned);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", widgetType=");
        return C1643a.m817E(sbM833U, this.widgetType, ")");
    }
}
