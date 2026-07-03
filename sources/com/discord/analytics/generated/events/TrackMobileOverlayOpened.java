package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMobileOverlayOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMobileOverlayOpened implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence type = null;
    private final CharSequence rtcConnectionId = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "mobile_overlay_opened";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMobileOverlayOpened)) {
            return false;
        }
        TrackMobileOverlayOpened trackMobileOverlayOpened = (TrackMobileOverlayOpened) other;
        return C12238m.areEqual(this.type, trackMobileOverlayOpened.type) && C12238m.areEqual(this.rtcConnectionId, trackMobileOverlayOpened.rtcConnectionId) && C12238m.areEqual(this.previewEnabled, trackMobileOverlayOpened.previewEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMobileOverlayOpened(type=");
        sbM833U.append(this.type);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", previewEnabled=");
        return C1643a.m816D(sbM833U, this.previewEnabled, ")");
    }
}
