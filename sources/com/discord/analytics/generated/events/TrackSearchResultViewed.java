package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackSearchResultViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSearchResultViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackGuild2, TrackChannel2 {
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
        if (!(other instanceof TrackSearchResultViewed)) {
            return false;
        }
        TrackSearchResultViewed trackSearchResultViewed = (TrackSearchResultViewed) other;
        return Intrinsics3.areEqual(this.searchType, trackSearchResultViewed.searchType) && Intrinsics3.areEqual(this.loadId, trackSearchResultViewed.loadId) && Intrinsics3.areEqual(this.loadDurationMs, trackSearchResultViewed.loadDurationMs) && Intrinsics3.areEqual(this.searchId, trackSearchResultViewed.searchId) && Intrinsics3.areEqual(this.prevSearchId, trackSearchResultViewed.prevSearchId) && Intrinsics3.areEqual(this.isError, trackSearchResultViewed.isError) && Intrinsics3.areEqual(this.limit, trackSearchResultViewed.limit) && Intrinsics3.areEqual(this.offset, trackSearchResultViewed.offset) && Intrinsics3.areEqual(this.page, trackSearchResultViewed.page) && Intrinsics3.areEqual(this.totalResults, trackSearchResultViewed.totalResults) && Intrinsics3.areEqual(this.pageResults, trackSearchResultViewed.pageResults) && Intrinsics3.areEqual(this.isIndexing, trackSearchResultViewed.isIndexing) && Intrinsics3.areEqual(this.pageNumMessages, trackSearchResultViewed.pageNumMessages) && Intrinsics3.areEqual(this.pageNumLinks, trackSearchResultViewed.pageNumLinks) && Intrinsics3.areEqual(this.pageNumEmbeds, trackSearchResultViewed.pageNumEmbeds) && Intrinsics3.areEqual(this.pageNumAttach, trackSearchResultViewed.pageNumAttach) && this.modifiers == trackSearchResultViewed.modifiers && Intrinsics3.areEqual(this.numModifiers, trackSearchResultViewed.numModifiers) && Intrinsics3.areEqual(this.query, trackSearchResultViewed.query) && Intrinsics3.areEqual(this.guildIds, trackSearchResultViewed.guildIds) && Intrinsics3.areEqual(this.categoryId, trackSearchResultViewed.categoryId) && Intrinsics3.areEqual(this.previewEnabled, trackSearchResultViewed.previewEnabled) && Intrinsics3.areEqual(this.numResultsLocked, trackSearchResultViewed.numResultsLocked) && Intrinsics3.areEqual(this.isSuggestion, trackSearchResultViewed.isSuggestion);
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
        StringBuilder sbU = outline.U("TrackSearchResultViewed(searchType=");
        sbU.append(this.searchType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", loadDurationMs=");
        sbU.append(this.loadDurationMs);
        sbU.append(", searchId=");
        sbU.append(this.searchId);
        sbU.append(", prevSearchId=");
        sbU.append(this.prevSearchId);
        sbU.append(", isError=");
        sbU.append(this.isError);
        sbU.append(", limit=");
        sbU.append(this.limit);
        sbU.append(", offset=");
        sbU.append(this.offset);
        sbU.append(", page=");
        sbU.append(this.page);
        sbU.append(", totalResults=");
        sbU.append(this.totalResults);
        sbU.append(", pageResults=");
        sbU.append(this.pageResults);
        sbU.append(", isIndexing=");
        sbU.append(this.isIndexing);
        sbU.append(", pageNumMessages=");
        sbU.append(this.pageNumMessages);
        sbU.append(", pageNumLinks=");
        sbU.append(this.pageNumLinks);
        sbU.append(", pageNumEmbeds=");
        sbU.append(this.pageNumEmbeds);
        sbU.append(", pageNumAttach=");
        sbU.append(this.pageNumAttach);
        sbU.append(", modifiers=");
        sbU.append(this.modifiers);
        sbU.append(", numModifiers=");
        sbU.append(this.numModifiers);
        sbU.append(", query=");
        sbU.append(this.query);
        sbU.append(", guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", categoryId=");
        sbU.append(this.categoryId);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", numResultsLocked=");
        sbU.append(this.numResultsLocked);
        sbU.append(", isSuggestion=");
        return outline.D(sbU, this.isSuggestion, ")");
    }
}
