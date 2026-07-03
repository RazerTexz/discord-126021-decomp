package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.evaluatedStep, trackNuoGuildInfo.evaluatedStep) && C12238m.areEqual(this.invitedGuildId, trackNuoGuildInfo.invitedGuildId) && C12238m.areEqual(this.guildCount, trackNuoGuildInfo.guildCount) && C12238m.areEqual(this.memberCount, trackNuoGuildInfo.memberCount) && C12238m.areEqual(this.hasSplash, trackNuoGuildInfo.hasSplash) && C12238m.areEqual(this.channelType, trackNuoGuildInfo.channelType) && C12238m.areEqual(this.verificationLevelEnabled, trackNuoGuildInfo.verificationLevelEnabled);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNuoGuildInfo(evaluatedStep=");
        sbM833U.append(this.evaluatedStep);
        sbM833U.append(", invitedGuildId=");
        sbM833U.append(this.invitedGuildId);
        sbM833U.append(", guildCount=");
        sbM833U.append(this.guildCount);
        sbM833U.append(", memberCount=");
        sbM833U.append(this.memberCount);
        sbM833U.append(", hasSplash=");
        sbM833U.append(this.hasSplash);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", verificationLevelEnabled=");
        return C1643a.m816D(sbM833U, this.verificationLevelEnabled, ")");
    }
}
