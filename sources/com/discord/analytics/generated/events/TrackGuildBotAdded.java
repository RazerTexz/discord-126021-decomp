package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.botId, trackGuildBotAdded.botId) && C12238m.areEqual(this.botName, trackGuildBotAdded.botName) && C12238m.areEqual(this.botPermissions, trackGuildBotAdded.botPermissions) && C12238m.areEqual(this.guildId, trackGuildBotAdded.guildId) && C12238m.areEqual(this.guildName, trackGuildBotAdded.guildName) && C12238m.areEqual(this.guildOwnerId, trackGuildBotAdded.guildOwnerId) && C12238m.areEqual(this.applicationId, trackGuildBotAdded.applicationId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildBotAdded(botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", botName=");
        sbM833U.append(this.botName);
        sbM833U.append(", botPermissions=");
        sbM833U.append(this.botPermissions);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", guildOwnerId=");
        sbM833U.append(this.guildOwnerId);
        sbM833U.append(", applicationId=");
        return C1643a.m819G(sbM833U, this.applicationId, ")");
    }
}
