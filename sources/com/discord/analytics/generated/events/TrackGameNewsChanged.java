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

/* JADX INFO: compiled from: TrackGameNewsChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGameNewsChanged implements AnalyticsSchema, TrackBase2, TrackAfGame2, TrackAfCard2 {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackBase trackBase;
    private final Long changeCount = null;
    private final CharSequence newsUrl = null;
    private final Long newsToIndex = null;
    private final Long newsFromIndex = null;
    private final CharSequence newsChangeType = null;
    private final transient String analyticsSchemaTypeName = "game_news_changed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGameNewsChanged)) {
            return false;
        }
        TrackGameNewsChanged trackGameNewsChanged = (TrackGameNewsChanged) other;
        return Intrinsics3.areEqual(this.changeCount, trackGameNewsChanged.changeCount) && Intrinsics3.areEqual(this.newsUrl, trackGameNewsChanged.newsUrl) && Intrinsics3.areEqual(this.newsToIndex, trackGameNewsChanged.newsToIndex) && Intrinsics3.areEqual(this.newsFromIndex, trackGameNewsChanged.newsFromIndex) && Intrinsics3.areEqual(this.newsChangeType, trackGameNewsChanged.newsChangeType);
    }

    public int hashCode() {
        Long l = this.changeCount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.newsUrl;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.newsToIndex;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.newsFromIndex;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.newsChangeType;
        return iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGameNewsChanged(changeCount=");
        sbU.append(this.changeCount);
        sbU.append(", newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsToIndex=");
        sbU.append(this.newsToIndex);
        sbU.append(", newsFromIndex=");
        sbU.append(this.newsFromIndex);
        sbU.append(", newsChangeType=");
        return outline.E(sbU, this.newsChangeType, ")");
    }
}
