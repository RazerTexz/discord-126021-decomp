package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSearchResultExpanded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSearchResultExpanded implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence searchId = null;
    private final Long messageId = null;
    private final Long limit = null;
    private final Long offset = null;
    private final Long page = null;
    private final Long pageResults = null;
    private final Long resultIndex = null;
    private final transient String analyticsSchemaTypeName = "search_result_expanded";

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
        if (!(other instanceof TrackSearchResultExpanded)) {
            return false;
        }
        TrackSearchResultExpanded trackSearchResultExpanded = (TrackSearchResultExpanded) other;
        return C12238m.areEqual(this.searchId, trackSearchResultExpanded.searchId) && C12238m.areEqual(this.messageId, trackSearchResultExpanded.messageId) && C12238m.areEqual(this.limit, trackSearchResultExpanded.limit) && C12238m.areEqual(this.offset, trackSearchResultExpanded.offset) && C12238m.areEqual(this.page, trackSearchResultExpanded.page) && C12238m.areEqual(this.pageResults, trackSearchResultExpanded.pageResults) && C12238m.areEqual(this.resultIndex, trackSearchResultExpanded.resultIndex);
    }

    public int hashCode() {
        CharSequence charSequence = this.searchId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.messageId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.limit;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.offset;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.page;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.pageResults;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.resultIndex;
        return iHashCode6 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSearchResultExpanded(searchId=");
        sbM833U.append(this.searchId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", limit=");
        sbM833U.append(this.limit);
        sbM833U.append(", offset=");
        sbM833U.append(this.offset);
        sbM833U.append(", page=");
        sbM833U.append(this.page);
        sbM833U.append(", pageResults=");
        sbM833U.append(this.pageResults);
        sbM833U.append(", resultIndex=");
        return C1643a.m819G(sbM833U, this.resultIndex, ")");
    }
}
