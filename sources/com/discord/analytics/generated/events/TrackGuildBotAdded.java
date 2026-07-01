package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildBotAdded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildBotAdded implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long botId = null;
    private final CharSequence botName = null;
    private final Long botPermissions = null;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final Long guildOwnerId = null;
    private final Long applicationId = null;
    private final transient String analyticsSchemaTypeName = "guild_bot_added";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildBotAdded)) {
            return false;
        }
        TrackGuildBotAdded trackGuildBotAdded = (TrackGuildBotAdded) other;
        return m.areEqual(this.botId, trackGuildBotAdded.botId) && m.areEqual(this.botName, trackGuildBotAdded.botName) && m.areEqual(this.botPermissions, trackGuildBotAdded.botPermissions) && m.areEqual(this.guildId, trackGuildBotAdded.guildId) && m.areEqual(this.guildName, trackGuildBotAdded.guildName) && m.areEqual(this.guildOwnerId, trackGuildBotAdded.guildOwnerId) && m.areEqual(this.applicationId, trackGuildBotAdded.applicationId);
    }

    public int hashCode() {
        Long l = this.botId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.botName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.botPermissions;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.guildName;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.guildOwnerId;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.applicationId;
        return iHashCode6 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildBotAdded(botId=");
        sbU.append(this.botId);
        sbU.append(", botName=");
        sbU.append(this.botName);
        sbU.append(", botPermissions=");
        sbU.append(this.botPermissions);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildOwnerId=");
        sbU.append(this.guildOwnerId);
        sbU.append(", applicationId=");
        return a.G(sbU, this.applicationId, ")");
    }
}
