package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        if (!(other instanceof TrackSearchResultExpanded)) {
            return false;
        }
        TrackSearchResultExpanded trackSearchResultExpanded = (TrackSearchResultExpanded) other;
        return m.areEqual(this.searchId, trackSearchResultExpanded.searchId) && m.areEqual(this.messageId, trackSearchResultExpanded.messageId) && m.areEqual(this.limit, trackSearchResultExpanded.limit) && m.areEqual(this.offset, trackSearchResultExpanded.offset) && m.areEqual(this.page, trackSearchResultExpanded.page) && m.areEqual(this.pageResults, trackSearchResultExpanded.pageResults) && m.areEqual(this.resultIndex, trackSearchResultExpanded.resultIndex);
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
        StringBuilder sbU = a.U("TrackSearchResultExpanded(searchId=");
        sbU.append(this.searchId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", limit=");
        sbU.append(this.limit);
        sbU.append(", offset=");
        sbU.append(this.offset);
        sbU.append(", page=");
        sbU.append(this.page);
        sbU.append(", pageResults=");
        sbU.append(this.pageResults);
        sbU.append(", resultIndex=");
        return a.G(sbU, this.resultIndex, ")");
    }
}
