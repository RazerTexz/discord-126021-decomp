package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStarterChannelRowSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStarterChannelRowSelected implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long index = null;
    private final CharSequence starterChannelType = null;
    private final transient String analyticsSchemaTypeName = "starter_channel_row_selected";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
        if (!(other instanceof TrackStarterChannelRowSelected)) {
            return false;
        }
        TrackStarterChannelRowSelected trackStarterChannelRowSelected = (TrackStarterChannelRowSelected) other;
        return m.areEqual(this.index, trackStarterChannelRowSelected.index) && m.areEqual(this.starterChannelType, trackStarterChannelRowSelected.starterChannelType);
    }

    public int hashCode() {
        Long l = this.index;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.starterChannelType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStarterChannelRowSelected(index=");
        sbU.append(this.index);
        sbU.append(", starterChannelType=");
        return a.E(sbU, this.starterChannelType, ")");
    }
}
