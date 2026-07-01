package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAfNewsChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfNewsChanged implements AnalyticsSchema, TrackBase2, TrackAfCard2, TrackAfGame2 {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackBase trackBase;
    private final CharSequence newsUrl = null;
    private final Long newsToIndex = null;
    private final Long newsFromIndex = null;
    private final CharSequence newsChangeType = null;
    private final transient String analyticsSchemaTypeName = "af_news_changed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfNewsChanged)) {
            return false;
        }
        TrackAfNewsChanged trackAfNewsChanged = (TrackAfNewsChanged) other;
        return Intrinsics3.areEqual(this.newsUrl, trackAfNewsChanged.newsUrl) && Intrinsics3.areEqual(this.newsToIndex, trackAfNewsChanged.newsToIndex) && Intrinsics3.areEqual(this.newsFromIndex, trackAfNewsChanged.newsFromIndex) && Intrinsics3.areEqual(this.newsChangeType, trackAfNewsChanged.newsChangeType);
    }

    public int hashCode() {
        CharSequence charSequence = this.newsUrl;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.newsToIndex;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.newsFromIndex;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newsChangeType;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfNewsChanged(newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsToIndex=");
        sbU.append(this.newsToIndex);
        sbU.append(", newsFromIndex=");
        sbU.append(this.newsFromIndex);
        sbU.append(", newsChangeType=");
        return outline.E(sbU, this.newsChangeType, ")");
    }
}
