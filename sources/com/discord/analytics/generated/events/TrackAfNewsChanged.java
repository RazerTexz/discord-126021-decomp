package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAfNewsChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfNewsChanged implements AnalyticsSchema, TrackBaseReceiver, TrackAfCardReceiver, TrackAfGameReceiver {
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
        return C12238m.areEqual(this.newsUrl, trackAfNewsChanged.newsUrl) && C12238m.areEqual(this.newsToIndex, trackAfNewsChanged.newsToIndex) && C12238m.areEqual(this.newsFromIndex, trackAfNewsChanged.newsFromIndex) && C12238m.areEqual(this.newsChangeType, trackAfNewsChanged.newsChangeType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAfNewsChanged(newsUrl=");
        sbM833U.append(this.newsUrl);
        sbM833U.append(", newsToIndex=");
        sbM833U.append(this.newsToIndex);
        sbM833U.append(", newsFromIndex=");
        sbM833U.append(this.newsFromIndex);
        sbM833U.append(", newsChangeType=");
        return C1643a.m817E(sbM833U, this.newsChangeType, ")");
    }
}
