package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackQuickswitcherResultSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackQuickswitcherResultSelected implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence selectedType = null;
    private final Float selectedScore = null;
    private final Long selectedIndex = null;
    private final Long selectedGuildId = null;
    private final Long selectedChannelId = null;
    private final Long selectedUserId = null;
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
    private final Boolean isEmailLike = null;
    private final Boolean isPhoneLike = null;
    private final Boolean isUsernameLike = null;
    private final CharSequence query = null;
    private final transient String analyticsSchemaTypeName = "quickswitcher_result_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackQuickswitcherResultSelected)) {
            return false;
        }
        TrackQuickswitcherResultSelected trackQuickswitcherResultSelected = (TrackQuickswitcherResultSelected) other;
        return C12238m.areEqual(this.selectedType, trackQuickswitcherResultSelected.selectedType) && C12238m.areEqual(this.selectedScore, trackQuickswitcherResultSelected.selectedScore) && C12238m.areEqual(this.selectedIndex, trackQuickswitcherResultSelected.selectedIndex) && C12238m.areEqual(this.selectedGuildId, trackQuickswitcherResultSelected.selectedGuildId) && C12238m.areEqual(this.selectedChannelId, trackQuickswitcherResultSelected.selectedChannelId) && C12238m.areEqual(this.selectedUserId, trackQuickswitcherResultSelected.selectedUserId) && C12238m.areEqual(this.currentChannelId, trackQuickswitcherResultSelected.currentChannelId) && C12238m.areEqual(this.currentChannelType, trackQuickswitcherResultSelected.currentChannelType) && C12238m.areEqual(this.currentGuildId, trackQuickswitcherResultSelected.currentGuildId) && C12238m.areEqual(this.queryMode, trackQuickswitcherResultSelected.queryMode) && C12238m.areEqual(this.queryLength, trackQuickswitcherResultSelected.queryLength) && C12238m.areEqual(this.maxQueryLength, trackQuickswitcherResultSelected.maxQueryLength) && C12238m.areEqual(this.topResultType, trackQuickswitcherResultSelected.topResultType) && C12238m.areEqual(this.topResultScore, trackQuickswitcherResultSelected.topResultScore) && C12238m.areEqual(this.numResultsTotal, trackQuickswitcherResultSelected.numResultsTotal) && C12238m.areEqual(this.numResultsUsers, trackQuickswitcherResultSelected.numResultsUsers) && C12238m.areEqual(this.numResultsTextChannels, trackQuickswitcherResultSelected.numResultsTextChannels) && C12238m.areEqual(this.numResultsVoiceChannels, trackQuickswitcherResultSelected.numResultsVoiceChannels) && C12238m.areEqual(this.numResultsGuilds, trackQuickswitcherResultSelected.numResultsGuilds) && C12238m.areEqual(this.numResultsGroupDms, trackQuickswitcherResultSelected.numResultsGroupDms) && C12238m.areEqual(this.isEmailLike, trackQuickswitcherResultSelected.isEmailLike) && C12238m.areEqual(this.isPhoneLike, trackQuickswitcherResultSelected.isPhoneLike) && C12238m.areEqual(this.isUsernameLike, trackQuickswitcherResultSelected.isUsernameLike) && C12238m.areEqual(this.query, trackQuickswitcherResultSelected.query);
    }

    public int hashCode() {
        CharSequence charSequence = this.selectedType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Float f = this.selectedScore;
        int iHashCode2 = (iHashCode + (f != null ? f.hashCode() : 0)) * 31;
        Long l = this.selectedIndex;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.selectedGuildId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.selectedChannelId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.selectedUserId;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.currentChannelId;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.currentChannelType;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.currentGuildId;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.queryMode;
        int iHashCode10 = (iHashCode9 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l8 = this.queryLength;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.maxQueryLength;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.topResultType;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Float f2 = this.topResultScore;
        int iHashCode14 = (iHashCode13 + (f2 != null ? f2.hashCode() : 0)) * 31;
        Long l10 = this.numResultsTotal;
        int iHashCode15 = (iHashCode14 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.numResultsUsers;
        int iHashCode16 = (iHashCode15 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.numResultsTextChannels;
        int iHashCode17 = (iHashCode16 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.numResultsVoiceChannels;
        int iHashCode18 = (iHashCode17 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.numResultsGuilds;
        int iHashCode19 = (iHashCode18 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.numResultsGroupDms;
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
        StringBuilder sbM833U = C1643a.m833U("TrackQuickswitcherResultSelected(selectedType=");
        sbM833U.append(this.selectedType);
        sbM833U.append(", selectedScore=");
        sbM833U.append(this.selectedScore);
        sbM833U.append(", selectedIndex=");
        sbM833U.append(this.selectedIndex);
        sbM833U.append(", selectedGuildId=");
        sbM833U.append(this.selectedGuildId);
        sbM833U.append(", selectedChannelId=");
        sbM833U.append(this.selectedChannelId);
        sbM833U.append(", selectedUserId=");
        sbM833U.append(this.selectedUserId);
        sbM833U.append(", currentChannelId=");
        sbM833U.append(this.currentChannelId);
        sbM833U.append(", currentChannelType=");
        sbM833U.append(this.currentChannelType);
        sbM833U.append(", currentGuildId=");
        sbM833U.append(this.currentGuildId);
        sbM833U.append(", queryMode=");
        sbM833U.append(this.queryMode);
        sbM833U.append(", queryLength=");
        sbM833U.append(this.queryLength);
        sbM833U.append(", maxQueryLength=");
        sbM833U.append(this.maxQueryLength);
        sbM833U.append(", topResultType=");
        sbM833U.append(this.topResultType);
        sbM833U.append(", topResultScore=");
        sbM833U.append(this.topResultScore);
        sbM833U.append(", numResultsTotal=");
        sbM833U.append(this.numResultsTotal);
        sbM833U.append(", numResultsUsers=");
        sbM833U.append(this.numResultsUsers);
        sbM833U.append(", numResultsTextChannels=");
        sbM833U.append(this.numResultsTextChannels);
        sbM833U.append(", numResultsVoiceChannels=");
        sbM833U.append(this.numResultsVoiceChannels);
        sbM833U.append(", numResultsGuilds=");
        sbM833U.append(this.numResultsGuilds);
        sbM833U.append(", numResultsGroupDms=");
        sbM833U.append(this.numResultsGroupDms);
        sbM833U.append(", isEmailLike=");
        sbM833U.append(this.isEmailLike);
        sbM833U.append(", isPhoneLike=");
        sbM833U.append(this.isPhoneLike);
        sbM833U.append(", isUsernameLike=");
        sbM833U.append(this.isUsernameLike);
        sbM833U.append(", query=");
        return C1643a.m817E(sbM833U, this.query, ")");
    }
}
