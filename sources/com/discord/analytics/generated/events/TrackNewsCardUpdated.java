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

/* JADX INFO: compiled from: TrackNewsCardUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNewsCardUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence applicationName = null;
    private final Long applicationId = null;
    private final Long messageId = null;
    private final Long newsId = null;
    private final CharSequence newsUrl = null;
    private final Long newsCardBodyLength = null;
    private final CharSequence updateType = null;
    private final transient String analyticsSchemaTypeName = "news_card_updated";

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
        if (!(other instanceof TrackNewsCardUpdated)) {
            return false;
        }
        TrackNewsCardUpdated trackNewsCardUpdated = (TrackNewsCardUpdated) other;
        return m.areEqual(this.applicationName, trackNewsCardUpdated.applicationName) && m.areEqual(this.applicationId, trackNewsCardUpdated.applicationId) && m.areEqual(this.messageId, trackNewsCardUpdated.messageId) && m.areEqual(this.newsId, trackNewsCardUpdated.newsId) && m.areEqual(this.newsUrl, trackNewsCardUpdated.newsUrl) && m.areEqual(this.newsCardBodyLength, trackNewsCardUpdated.newsCardBodyLength) && m.areEqual(this.updateType, trackNewsCardUpdated.updateType);
    }

    public int hashCode() {
        CharSequence charSequence = this.applicationName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.newsId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newsUrl;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.newsCardBodyLength;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.updateType;
        return iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNewsCardUpdated(applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", newsId=");
        sbU.append(this.newsId);
        sbU.append(", newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsCardBodyLength=");
        sbU.append(this.newsCardBodyLength);
        sbU.append(", updateType=");
        return a.E(sbU, this.updateType, ")");
    }
}
