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

/* JADX INFO: compiled from: TrackGameNewsChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGameNewsChanged implements AnalyticsSchema, TrackBaseReceiver, TrackAfGameReceiver, TrackAfCardReceiver {
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
        return C12238m.areEqual(this.changeCount, trackGameNewsChanged.changeCount) && C12238m.areEqual(this.newsUrl, trackGameNewsChanged.newsUrl) && C12238m.areEqual(this.newsToIndex, trackGameNewsChanged.newsToIndex) && C12238m.areEqual(this.newsFromIndex, trackGameNewsChanged.newsFromIndex) && C12238m.areEqual(this.newsChangeType, trackGameNewsChanged.newsChangeType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGameNewsChanged(changeCount=");
        sbM833U.append(this.changeCount);
        sbM833U.append(", newsUrl=");
        sbM833U.append(this.newsUrl);
        sbM833U.append(", newsToIndex=");
        sbM833U.append(this.newsToIndex);
        sbM833U.append(", newsFromIndex=");
        sbM833U.append(this.newsFromIndex);
        sbM833U.append(", newsChangeType=");
        return C1643a.m817E(sbM833U, this.newsChangeType, ")");
    }
}
