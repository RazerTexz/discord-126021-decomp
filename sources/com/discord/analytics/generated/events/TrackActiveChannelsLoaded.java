package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActiveChannelsLoaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActiveChannelsLoaded implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long textChannelsShown = null;
    private final Long voiceChannelsShown = null;
    private final CharSequence homeSessionId = null;
    private final transient String analyticsSchemaTypeName = "active_channels_loaded";

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
        if (!(other instanceof TrackActiveChannelsLoaded)) {
            return false;
        }
        TrackActiveChannelsLoaded trackActiveChannelsLoaded = (TrackActiveChannelsLoaded) other;
        return C12238m.areEqual(this.textChannelsShown, trackActiveChannelsLoaded.textChannelsShown) && C12238m.areEqual(this.voiceChannelsShown, trackActiveChannelsLoaded.voiceChannelsShown) && C12238m.areEqual(this.homeSessionId, trackActiveChannelsLoaded.homeSessionId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActiveChannelsLoaded(textChannelsShown=");
        sbM833U.append(this.textChannelsShown);
        sbM833U.append(", voiceChannelsShown=");
        sbM833U.append(this.voiceChannelsShown);
        sbM833U.append(", homeSessionId=");
        return C1643a.m817E(sbM833U, this.homeSessionId, ")");
    }
}
