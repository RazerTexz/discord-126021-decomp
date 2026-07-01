package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDeepLinkReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDeepLinkReceived implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence source = null;
    private final CharSequence type = null;
    private final Boolean voiceAction = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "deep_link_received";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
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
        return Intrinsics3.areEqual(this.source, trackDeepLinkReceived.source) && Intrinsics3.areEqual(this.type, trackDeepLinkReceived.type) && Intrinsics3.areEqual(this.voiceAction, trackDeepLinkReceived.voiceAction) && Intrinsics3.areEqual(this.previewEnabled, trackDeepLinkReceived.previewEnabled);
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
        StringBuilder sbU = outline.U("TrackDeepLinkReceived(source=");
        sbU.append(this.source);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", voiceAction=");
        sbU.append(this.voiceAction);
        sbU.append(", previewEnabled=");
        return outline.D(sbU, this.previewEnabled, ")");
    }
}
