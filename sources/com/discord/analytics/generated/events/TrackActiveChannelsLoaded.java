package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActiveChannelsLoaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActiveChannelsLoaded implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long textChannelsShown = null;
    private final Long voiceChannelsShown = null;
    private final CharSequence homeSessionId = null;
    private final transient String analyticsSchemaTypeName = "active_channels_loaded";

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
        if (!(other instanceof TrackActiveChannelsLoaded)) {
            return false;
        }
        TrackActiveChannelsLoaded trackActiveChannelsLoaded = (TrackActiveChannelsLoaded) other;
        return Intrinsics3.areEqual(this.textChannelsShown, trackActiveChannelsLoaded.textChannelsShown) && Intrinsics3.areEqual(this.voiceChannelsShown, trackActiveChannelsLoaded.voiceChannelsShown) && Intrinsics3.areEqual(this.homeSessionId, trackActiveChannelsLoaded.homeSessionId);
    }

    public int hashCode() {
        Long l = this.textChannelsShown;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.voiceChannelsShown;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.homeSessionId;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActiveChannelsLoaded(textChannelsShown=");
        sbU.append(this.textChannelsShown);
        sbU.append(", voiceChannelsShown=");
        sbU.append(this.voiceChannelsShown);
        sbU.append(", homeSessionId=");
        return outline.E(sbU, this.homeSessionId, ")");
    }
}
