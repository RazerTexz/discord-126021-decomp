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

/* JADX INFO: compiled from: TrackApplicationCommandUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationCommandUsed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long applicationId = null;
    private final Long commandId = null;
    private final Long commandType = null;
    private final transient String analyticsSchemaTypeName = "application_command_used";

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
        if (!(other instanceof TrackApplicationCommandUsed)) {
            return false;
        }
        TrackApplicationCommandUsed trackApplicationCommandUsed = (TrackApplicationCommandUsed) other;
        return Intrinsics3.areEqual(this.applicationId, trackApplicationCommandUsed.applicationId) && Intrinsics3.areEqual(this.commandId, trackApplicationCommandUsed.commandId) && Intrinsics3.areEqual(this.commandType, trackApplicationCommandUsed.commandType);
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
        StringBuilder sbU = outline.U("TrackApplicationCommandUsed(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", commandId=");
        sbU.append(this.commandId);
        sbU.append(", commandType=");
        return outline.G(sbU, this.commandType, ")");
    }
}
