package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSearchResultViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSearchResultViewed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long categoryId;
    private final List<Long> guildIds;
    private final Boolean isError;
    private final Boolean isIndexing;
    private final Boolean isSuggestion;
    private final Long limit;
    private final Long loadDurationMs;
    private final CharSequence loadId;
    private final long modifiers;
    private final Long numModifiers;
    private final Long numResultsLocked;
    private final Long offset;
    private final Long page;
    private final Long pageNumAttach;
    private final Long pageNumEmbeds;
    private final Long pageNumLinks;
    private final Long pageNumMessages;
    private final Long pageResults;
    private final CharSequence prevSearchId;
    private final Boolean previewEnabled;
    private final CharSequence query;
    private final CharSequence searchId;
    private final CharSequence searchType;
    private final Long totalResults;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;

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
        if (!(other instanceof TrackSearchResultViewed)) {
            return false;
        }
        TrackSearchResultViewed trackSearchResultViewed = (TrackSearchResultViewed) other;
        return C12238m.areEqual(this.searchType, trackSearchResultViewed.searchType) && C12238m.areEqual(this.loadId, trackSearchResultViewed.loadId) && C12238m.areEqual(this.loadDurationMs, trackSearchResultViewed.loadDurationMs) && C12238m.areEqual(this.searchId, trackSearchResultViewed.searchId) && C12238m.areEqual(this.prevSearchId, trackSearchResultViewed.prevSearchId) && C12238m.areEqual(this.isError, trackSearchResultViewed.isError) && C12238m.areEqual(this.limit, trackSearchResultViewed.limit) && C12238m.areEqual(this.offset, trackSearchResultViewed.offset) && C12238m.areEqual(this.page, trackSearchResultViewed.page) && C12238m.areEqual(this.totalResults, trackSearchResultViewed.totalResults) && C12238m.areEqual(this.pageResults, trackSearchResultViewed.pageResults) && C12238m.areEqual(this.isIndexing, trackSearchResultViewed.isIndexing) && C12238m.areEqual(this.pageNumMessages, trackSearchResultViewed.pageNumMessages) && C12238m.areEqual(this.pageNumLinks, trackSearchResultViewed.pageNumLinks) && C12238m.areEqual(this.pageNumEmbeds, trackSearchResultViewed.pageNumEmbeds) && C12238m.areEqual(this.pageNumAttach, trackSearchResultViewed.pageNumAttach) && this.modifiers == trackSearchResultViewed.modifiers && C12238m.areEqual(this.numModifiers, trackSearchResultViewed.numModifiers) && C12238m.areEqual(this.query, trackSearchResultViewed.query) && C12238m.areEqual(this.guildIds, trackSearchResultViewed.guildIds) && C12238m.areEqual(this.categoryId, trackSearchResultViewed.categoryId) && C12238m.areEqual(this.previewEnabled, trackSearchResultViewed.previewEnabled) && C12238m.areEqual(this.numResultsLocked, trackSearchResultViewed.numResultsLocked) && C12238m.areEqual(this.isSuggestion, trackSearchResultViewed.isSuggestion);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.loadDurationMs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.searchId;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.prevSearchId;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.isError;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.limit;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.offset;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.page;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalResults;
        int iHashCode10 = (iHashCode9 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.pageResults;
        int iHashCode11 = (iHashCode10 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool2 = this.isIndexing;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l7 = this.pageNumMessages;
        int iHashCode13 = (iHashCode12 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.pageNumLinks;
        int iHashCode14 = (iHashCode13 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.pageNumEmbeds;
        int iHashCode15 = (iHashCode14 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.pageNumAttach;
        int iHashCode16 = (iHashCode15 + (l10 != null ? l10.hashCode() : 0)) * 31;
        long j = this.modifiers;
        int i = (iHashCode16 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l11 = this.numModifiers;
        int iHashCode17 = (i + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.query;
        int iHashCode18 = (iHashCode17 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        List<Long> list = this.guildIds;
        int iHashCode19 = (iHashCode18 + (list != null ? list.hashCode() : 0)) * 31;
        Long l12 = this.categoryId;
        int iHashCode20 = (iHashCode19 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Boolean bool3 = this.previewEnabled;
        int iHashCode21 = (iHashCode20 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l13 = this.numResultsLocked;
        int iHashCode22 = (iHashCode21 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Boolean bool4 = this.isSuggestion;
        return iHashCode22 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSearchResultViewed(searchType=");
        sbM833U.append(this.searchType);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", loadDurationMs=");
        sbM833U.append(this.loadDurationMs);
        sbM833U.append(", searchId=");
        sbM833U.append(this.searchId);
        sbM833U.append(", prevSearchId=");
        sbM833U.append(this.prevSearchId);
        sbM833U.append(", isError=");
        sbM833U.append(this.isError);
        sbM833U.append(", limit=");
        sbM833U.append(this.limit);
        sbM833U.append(", offset=");
        sbM833U.append(this.offset);
        sbM833U.append(", page=");
        sbM833U.append(this.page);
        sbM833U.append(", totalResults=");
        sbM833U.append(this.totalResults);
        sbM833U.append(", pageResults=");
        sbM833U.append(this.pageResults);
        sbM833U.append(", isIndexing=");
        sbM833U.append(this.isIndexing);
        sbM833U.append(", pageNumMessages=");
        sbM833U.append(this.pageNumMessages);
        sbM833U.append(", pageNumLinks=");
        sbM833U.append(this.pageNumLinks);
        sbM833U.append(", pageNumEmbeds=");
        sbM833U.append(this.pageNumEmbeds);
        sbM833U.append(", pageNumAttach=");
        sbM833U.append(this.pageNumAttach);
        sbM833U.append(", modifiers=");
        sbM833U.append(this.modifiers);
        sbM833U.append(", numModifiers=");
        sbM833U.append(this.numModifiers);
        sbM833U.append(", query=");
        sbM833U.append(this.query);
        sbM833U.append(", guildIds=");
        sbM833U.append(this.guildIds);
        sbM833U.append(", categoryId=");
        sbM833U.append(this.categoryId);
        sbM833U.append(", previewEnabled=");
        sbM833U.append(this.previewEnabled);
        sbM833U.append(", numResultsLocked=");
        sbM833U.append(this.numResultsLocked);
        sbM833U.append(", isSuggestion=");
        return C1643a.m816D(sbM833U, this.isSuggestion, ")");
    }
}
