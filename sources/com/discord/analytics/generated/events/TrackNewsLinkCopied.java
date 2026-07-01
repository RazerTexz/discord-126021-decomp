package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNewsLinkCopied.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNewsLinkCopied implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
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
        return Intrinsics3.areEqual(this.newsUrl, trackNewsLinkCopied.newsUrl) && Intrinsics3.areEqual(this.newsId, trackNewsLinkCopied.newsId) && Intrinsics3.areEqual(this.applicationId, trackNewsLinkCopied.applicationId) && Intrinsics3.areEqual(this.applicationName, trackNewsLinkCopied.applicationName);
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
        StringBuilder sbU = outline.U("TrackNewsLinkCopied(newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsId=");
        sbU.append(this.newsId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        return outline.E(sbU, this.applicationName, ")");
    }
}
