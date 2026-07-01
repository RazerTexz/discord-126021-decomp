package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNuoGuildInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNuoGuildInfo implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence evaluatedStep = null;
    private final Long invitedGuildId = null;
    private final Long guildCount = null;
    private final Long memberCount = null;
    private final Boolean hasSplash = null;
    private final Long channelType = null;
    private final Boolean verificationLevelEnabled = null;
    private final transient String analyticsSchemaTypeName = "nuo_guild_info";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNuoGuildInfo)) {
            return false;
        }
        TrackNuoGuildInfo trackNuoGuildInfo = (TrackNuoGuildInfo) other;
        return m.areEqual(this.evaluatedStep, trackNuoGuildInfo.evaluatedStep) && m.areEqual(this.invitedGuildId, trackNuoGuildInfo.invitedGuildId) && m.areEqual(this.guildCount, trackNuoGuildInfo.guildCount) && m.areEqual(this.memberCount, trackNuoGuildInfo.memberCount) && m.areEqual(this.hasSplash, trackNuoGuildInfo.hasSplash) && m.areEqual(this.channelType, trackNuoGuildInfo.channelType) && m.areEqual(this.verificationLevelEnabled, trackNuoGuildInfo.verificationLevelEnabled);
    }

    public int hashCode() {
        CharSequence charSequence = this.evaluatedStep;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.invitedGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildCount;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.memberCount;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.hasSplash;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool2 = this.verificationLevelEnabled;
        return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNuoGuildInfo(evaluatedStep=");
        sbU.append(this.evaluatedStep);
        sbU.append(", invitedGuildId=");
        sbU.append(this.invitedGuildId);
        sbU.append(", guildCount=");
        sbU.append(this.guildCount);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", hasSplash=");
        sbU.append(this.hasSplash);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", verificationLevelEnabled=");
        return a.D(sbU, this.verificationLevelEnabled, ")");
    }
}
