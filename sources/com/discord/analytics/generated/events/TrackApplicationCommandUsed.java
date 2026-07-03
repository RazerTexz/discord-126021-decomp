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

/* JADX INFO: compiled from: TrackApplicationCommandUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandUsed implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long applicationId = null;
    private final Long commandId = null;
    private final Long commandType = null;
    private final transient String analyticsSchemaTypeName = "application_command_used";

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
        if (!(other instanceof TrackApplicationCommandUsed)) {
            return false;
        }
        TrackApplicationCommandUsed trackApplicationCommandUsed = (TrackApplicationCommandUsed) other;
        return C12238m.areEqual(this.applicationId, trackApplicationCommandUsed.applicationId) && C12238m.areEqual(this.commandId, trackApplicationCommandUsed.commandId) && C12238m.areEqual(this.commandType, trackApplicationCommandUsed.commandType);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.commandId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.commandType;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackApplicationCommandUsed(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", commandId=");
        sbM833U.append(this.commandId);
        sbM833U.append(", commandType=");
        return C1643a.m819G(sbM833U, this.commandType, ")");
    }
}
