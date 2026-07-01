package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNewsLinkShared.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNewsLinkShared implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2, TrackSourceMetadata2 {
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
        if (!(other instanceof TrackNewsLinkShared)) {
            return false;
        }
        TrackNewsLinkShared trackNewsLinkShared = (TrackNewsLinkShared) other;
        return Intrinsics3.areEqual(this.newsUrl, trackNewsLinkShared.newsUrl) && Intrinsics3.areEqual(this.newsId, trackNewsLinkShared.newsId) && Intrinsics3.areEqual(this.applicationId, trackNewsLinkShared.applicationId) && Intrinsics3.areEqual(this.applicationName, trackNewsLinkShared.applicationName) && Intrinsics3.areEqual(this.recipientId, trackNewsLinkShared.recipientId);
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
        StringBuilder sbU = outline.U("TrackNewsLinkShared(newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsId=");
        sbU.append(this.newsId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", recipientId=");
        return outline.G(sbU, this.recipientId, ")");
    }
}
