package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackQuickswitcherClosed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackQuickswitcherClosed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long currentChannelId = null;
    private final Long currentChannelType = null;
    private final Long currentGuildId = null;
    private final CharSequence queryMode = null;
    private final Long queryLength = null;
    private final Long maxQueryLength = null;
    private final CharSequence topResultType = null;
    private final Float topResultScore = null;
    private final Long numResultsTotal = null;
    private final Long numResultsUsers = null;
    private final Long numResultsTextChannels = null;
    private final Long numResultsVoiceChannels = null;
    private final Long numResultsGuilds = null;
    private final Long numResultsGroupDms = null;
    private final CharSequence selectedType = null;
    private final Float selectedScore = null;
    private final Long selectedIndex = null;
    private final Long selectedGuildId = null;
    private final Long selectedChannelId = null;
    private final Long selectedUserId = null;
    private final Boolean isEmailLike = null;
    private final Boolean isPhoneLike = null;
    private final Boolean isUsernameLike = null;
    private final CharSequence query = null;
    private final transient String analyticsSchemaTypeName = "quickswitcher_closed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackQuickswitcherClosed)) {
            return false;
        }
        TrackQuickswitcherClosed trackQuickswitcherClosed = (TrackQuickswitcherClosed) other;
        return m.areEqual(this.currentChannelId, trackQuickswitcherClosed.currentChannelId) && m.areEqual(this.currentChannelType, trackQuickswitcherClosed.currentChannelType) && m.areEqual(this.currentGuildId, trackQuickswitcherClosed.currentGuildId) && m.areEqual(this.queryMode, trackQuickswitcherClosed.queryMode) && m.areEqual(this.queryLength, trackQuickswitcherClosed.queryLength) && m.areEqual(this.maxQueryLength, trackQuickswitcherClosed.maxQueryLength) && m.areEqual(this.topResultType, trackQuickswitcherClosed.topResultType) && m.areEqual(this.topResultScore, trackQuickswitcherClosed.topResultScore) && m.areEqual(this.numResultsTotal, trackQuickswitcherClosed.numResultsTotal) && m.areEqual(this.numResultsUsers, trackQuickswitcherClosed.numResultsUsers) && m.areEqual(this.numResultsTextChannels, trackQuickswitcherClosed.numResultsTextChannels) && m.areEqual(this.numResultsVoiceChannels, trackQuickswitcherClosed.numResultsVoiceChannels) && m.areEqual(this.numResultsGuilds, trackQuickswitcherClosed.numResultsGuilds) && m.areEqual(this.numResultsGroupDms, trackQuickswitcherClosed.numResultsGroupDms) && m.areEqual(this.selectedType, trackQuickswitcherClosed.selectedType) && m.areEqual(this.selectedScore, trackQuickswitcherClosed.selectedScore) && m.areEqual(this.selectedIndex, trackQuickswitcherClosed.selectedIndex) && m.areEqual(this.selectedGuildId, trackQuickswitcherClosed.selectedGuildId) && m.areEqual(this.selectedChannelId, trackQuickswitcherClosed.selectedChannelId) && m.areEqual(this.selectedUserId, trackQuickswitcherClosed.selectedUserId) && m.areEqual(this.isEmailLike, trackQuickswitcherClosed.isEmailLike) && m.areEqual(this.isPhoneLike, trackQuickswitcherClosed.isPhoneLike) && m.areEqual(this.isUsernameLike, trackQuickswitcherClosed.isUsernameLike) && m.areEqual(this.query, trackQuickswitcherClosed.query);
    }

    public int hashCode() {
        Long l = this.currentChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.currentChannelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentGuildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.queryMode;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.queryLength;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.maxQueryLength;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.topResultType;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Float f = this.topResultScore;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        Long l6 = this.numResultsTotal;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.numResultsUsers;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.numResultsTextChannels;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numResultsVoiceChannels;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.numResultsGuilds;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.numResultsGroupDms;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.selectedType;
        int iHashCode15 = (iHashCode14 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Float f2 = this.selectedScore;
        int iHashCode16 = (iHashCode15 + (f2 != null ? f2.hashCode() : 0)) * 31;
        Long l12 = this.selectedIndex;
        int iHashCode17 = (iHashCode16 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.selectedGuildId;
        int iHashCode18 = (iHashCode17 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.selectedChannelId;
        int iHashCode19 = (iHashCode18 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.selectedUserId;
        int iHashCode20 = (iHashCode19 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Boolean bool = this.isEmailLike;
        int iHashCode21 = (iHashCode20 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isPhoneLike;
        int iHashCode22 = (iHashCode21 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isUsernameLike;
        int iHashCode23 = (iHashCode22 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.query;
        return iHashCode23 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackQuickswitcherClosed(currentChannelId=");
        sbU.append(this.currentChannelId);
        sbU.append(", currentChannelType=");
        sbU.append(this.currentChannelType);
        sbU.append(", currentGuildId=");
        sbU.append(this.currentGuildId);
        sbU.append(", queryMode=");
        sbU.append(this.queryMode);
        sbU.append(", queryLength=");
        sbU.append(this.queryLength);
        sbU.append(", maxQueryLength=");
        sbU.append(this.maxQueryLength);
        sbU.append(", topResultType=");
        sbU.append(this.topResultType);
        sbU.append(", topResultScore=");
        sbU.append(this.topResultScore);
        sbU.append(", numResultsTotal=");
        sbU.append(this.numResultsTotal);
        sbU.append(", numResultsUsers=");
        sbU.append(this.numResultsUsers);
        sbU.append(", numResultsTextChannels=");
        sbU.append(this.numResultsTextChannels);
        sbU.append(", numResultsVoiceChannels=");
        sbU.append(this.numResultsVoiceChannels);
        sbU.append(", numResultsGuilds=");
        sbU.append(this.numResultsGuilds);
        sbU.append(", numResultsGroupDms=");
        sbU.append(this.numResultsGroupDms);
        sbU.append(", selectedType=");
        sbU.append(this.selectedType);
        sbU.append(", selectedScore=");
        sbU.append(this.selectedScore);
        sbU.append(", selectedIndex=");
        sbU.append(this.selectedIndex);
        sbU.append(", selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", selectedChannelId=");
        sbU.append(this.selectedChannelId);
        sbU.append(", selectedUserId=");
        sbU.append(this.selectedUserId);
        sbU.append(", isEmailLike=");
        sbU.append(this.isEmailLike);
        sbU.append(", isPhoneLike=");
        sbU.append(this.isPhoneLike);
        sbU.append(", isUsernameLike=");
        sbU.append(this.isUsernameLike);
        sbU.append(", query=");
        return a.E(sbU, this.query, ")");
    }
}
