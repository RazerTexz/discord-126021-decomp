package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLeaveGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLeaveGuild implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final transient String analyticsSchemaTypeName = "leave_guild";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLeaveGuild)) {
            return false;
        }
        TrackLeaveGuild trackLeaveGuild = (TrackLeaveGuild) other;
        return m.areEqual(this.guildId, trackLeaveGuild.guildId) && m.areEqual(this.guildName, trackLeaveGuild.guildName);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLeaveGuild(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        return a.E(sbU, this.guildName, ")");
    }
}
