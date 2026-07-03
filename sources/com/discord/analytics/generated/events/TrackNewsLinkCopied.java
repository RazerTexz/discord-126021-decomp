package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNewsLinkCopied.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNewsLinkCopied implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence newsUrl = null;
    private final Long newsId = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final transient String analyticsSchemaTypeName = "news_link_copied";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNewsLinkCopied)) {
            return false;
        }
        TrackNewsLinkCopied trackNewsLinkCopied = (TrackNewsLinkCopied) other;
        return C12238m.areEqual(this.newsUrl, trackNewsLinkCopied.newsUrl) && C12238m.areEqual(this.newsId, trackNewsLinkCopied.newsId) && C12238m.areEqual(this.applicationId, trackNewsLinkCopied.applicationId) && C12238m.areEqual(this.applicationName, trackNewsLinkCopied.applicationName);
    }

    public int hashCode() {
        CharSequence charSequence = this.newsUrl;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.newsId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.applicationName;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNewsLinkCopied(newsUrl=");
        sbM833U.append(this.newsUrl);
        sbM833U.append(", newsId=");
        sbM833U.append(this.newsId);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", applicationName=");
        return C1643a.m817E(sbM833U, this.applicationName, ")");
    }
}
