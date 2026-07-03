package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDeleteGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDeleteGuild implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final Long guildSizeTotal = null;
    private final Long guildNumChannels = null;
    private final Long guildNumTextChannels = null;
    private final Long guildNumVoiceChannels = null;
    private final Long guildNumRoles = null;
    private final Boolean guildIsVip = null;
    private final transient String analyticsSchemaTypeName = "delete_guild";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDeleteGuild)) {
            return false;
        }
        TrackDeleteGuild trackDeleteGuild = (TrackDeleteGuild) other;
        return C12238m.areEqual(this.guildId, trackDeleteGuild.guildId) && C12238m.areEqual(this.guildName, trackDeleteGuild.guildName) && C12238m.areEqual(this.guildSizeTotal, trackDeleteGuild.guildSizeTotal) && C12238m.areEqual(this.guildNumChannels, trackDeleteGuild.guildNumChannels) && C12238m.areEqual(this.guildNumTextChannels, trackDeleteGuild.guildNumTextChannels) && C12238m.areEqual(this.guildNumVoiceChannels, trackDeleteGuild.guildNumVoiceChannels) && C12238m.areEqual(this.guildNumRoles, trackDeleteGuild.guildNumRoles) && C12238m.areEqual(this.guildIsVip, trackDeleteGuild.guildIsVip);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.guildSizeTotal;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildNumChannels;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildNumTextChannels;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildNumVoiceChannels;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.guildNumRoles;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.guildIsVip;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDeleteGuild(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", guildSizeTotal=");
        sbM833U.append(this.guildSizeTotal);
        sbM833U.append(", guildNumChannels=");
        sbM833U.append(this.guildNumChannels);
        sbM833U.append(", guildNumTextChannels=");
        sbM833U.append(this.guildNumTextChannels);
        sbM833U.append(", guildNumVoiceChannels=");
        sbM833U.append(this.guildNumVoiceChannels);
        sbM833U.append(", guildNumRoles=");
        sbM833U.append(this.guildNumRoles);
        sbM833U.append(", guildIsVip=");
        return C1643a.m816D(sbM833U, this.guildIsVip, ")");
    }
}
