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
        if (!(other instanceof TrackNewsCardUpdated)) {
            return false;
        }
        TrackNewsCardUpdated trackNewsCardUpdated = (TrackNewsCardUpdated) other;
        return C12238m.areEqual(this.applicationName, trackNewsCardUpdated.applicationName) && C12238m.areEqual(this.applicationId, trackNewsCardUpdated.applicationId) && C12238m.areEqual(this.messageId, trackNewsCardUpdated.messageId) && C12238m.areEqual(this.newsId, trackNewsCardUpdated.newsId) && C12238m.areEqual(this.newsUrl, trackNewsCardUpdated.newsUrl) && C12238m.areEqual(this.newsCardBodyLength, trackNewsCardUpdated.newsCardBodyLength) && C12238m.areEqual(this.updateType, trackNewsCardUpdated.updateType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNewsCardUpdated(applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", newsId=");
        sbM833U.append(this.newsId);
        sbM833U.append(", newsUrl=");
        sbM833U.append(this.newsUrl);
        sbM833U.append(", newsCardBodyLength=");
        sbM833U.append(this.newsCardBodyLength);
        sbM833U.append(", updateType=");
        return C1643a.m817E(sbM833U, this.updateType, ")");
    }
}
