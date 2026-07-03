package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNewsLinkShared.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNewsLinkShared implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence newsUrl = null;
    private final Long newsId = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final Long recipientId = null;
    private final transient String analyticsSchemaTypeName = "news_link_shared";

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
        if (!(other instanceof TrackNewsLinkShared)) {
            return false;
        }
        TrackNewsLinkShared trackNewsLinkShared = (TrackNewsLinkShared) other;
        return C12238m.areEqual(this.newsUrl, trackNewsLinkShared.newsUrl) && C12238m.areEqual(this.newsId, trackNewsLinkShared.newsId) && C12238m.areEqual(this.applicationId, trackNewsLinkShared.applicationId) && C12238m.areEqual(this.applicationName, trackNewsLinkShared.applicationName) && C12238m.areEqual(this.recipientId, trackNewsLinkShared.recipientId);
    }

    public int hashCode() {
        CharSequence charSequence = this.newsUrl;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.newsId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.applicationName;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.recipientId;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNewsLinkShared(newsUrl=");
        sbM833U.append(this.newsUrl);
        sbM833U.append(", newsId=");
        sbM833U.append(this.newsId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", recipientId=");
        return C1643a.m819G(sbM833U, this.recipientId, ")");
    }
}
