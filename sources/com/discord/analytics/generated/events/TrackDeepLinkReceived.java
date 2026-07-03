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

/* JADX INFO: compiled from: TrackDeepLinkReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDeepLinkReceived implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence source = null;
    private final CharSequence type = null;
    private final Boolean voiceAction = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "deep_link_received";

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
        if (!(other instanceof TrackDeepLinkReceived)) {
            return false;
        }
        TrackDeepLinkReceived trackDeepLinkReceived = (TrackDeepLinkReceived) other;
        return C12238m.areEqual(this.source, trackDeepLinkReceived.source) && C12238m.areEqual(this.type, trackDeepLinkReceived.type) && C12238m.areEqual(this.voiceAction, trackDeepLinkReceived.voiceAction) && C12238m.areEqual(this.previewEnabled, trackDeepLinkReceived.previewEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.type;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.voiceAction;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.previewEnabled;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDeepLinkReceived(source=");
        sbM833U.append(this.source);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", voiceAction=");
        sbM833U.append(this.voiceAction);
        sbM833U.append(", previewEnabled=");
        return C1643a.m816D(sbM833U, this.previewEnabled, ")");
    }
}
