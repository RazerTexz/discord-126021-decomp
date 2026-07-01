package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSearchResultSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSearchResultSelected implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackSourceMetadataReceiver, TrackLocationMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long indexNum;
    private final Long limit;
    private final CharSequence loadId;
    private final long modifiers;
    private final Long numModifiers;
    private final Long offset;
    private final Long page;
    private final Long pageResults;
    private final Boolean previewEnabled;
    private final CharSequence query;
    private final CharSequence searchId;
    private final CharSequence searchType;
    private final Long totalResults;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
        if (!(other instanceof TrackSearchResultSelected)) {
            return false;
        }
        TrackSearchResultSelected trackSearchResultSelected = (TrackSearchResultSelected) other;
        return m.areEqual(this.searchType, trackSearchResultSelected.searchType) && m.areEqual(this.loadId, trackSearchResultSelected.loadId) && m.areEqual(this.searchId, trackSearchResultSelected.searchId) && m.areEqual(this.indexNum, trackSearchResultSelected.indexNum) && m.areEqual(this.limit, trackSearchResultSelected.limit) && m.areEqual(this.offset, trackSearchResultSelected.offset) && m.areEqual(this.page, trackSearchResultSelected.page) && m.areEqual(this.totalResults, trackSearchResultSelected.totalResults) && m.areEqual(this.pageResults, trackSearchResultSelected.pageResults) && this.modifiers == trackSearchResultSelected.modifiers && m.areEqual(this.numModifiers, trackSearchResultSelected.numModifiers) && m.areEqual(this.previewEnabled, trackSearchResultSelected.previewEnabled) && m.areEqual(this.query, trackSearchResultSelected.query);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.loadId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.searchId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.indexNum;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.limit;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.offset;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.page;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalResults;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.pageResults;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        long j = this.modifiers;
        int i = (iHashCode9 + ((int) (j ^ (j >>> 32)))) * 31;
        Long l7 = this.numModifiers;
        int iHashCode10 = (i + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.previewEnabled;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.query;
        return iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSearchResultSelected(searchType=");
        sbU.append(this.searchType);
        sbU.append(", loadId=");
        sbU.append(this.loadId);
        sbU.append(", searchId=");
        sbU.append(this.searchId);
        sbU.append(", indexNum=");
        sbU.append(this.indexNum);
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
        sbU.append(", modifiers=");
        sbU.append(this.modifiers);
        sbU.append(", numModifiers=");
        sbU.append(this.numModifiers);
        sbU.append(", previewEnabled=");
        sbU.append(this.previewEnabled);
        sbU.append(", query=");
        return a.E(sbU, this.query, ")");
    }
}
