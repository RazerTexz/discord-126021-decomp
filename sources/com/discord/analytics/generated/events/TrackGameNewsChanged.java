package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.changeCount, trackGameNewsChanged.changeCount) && m.areEqual(this.newsUrl, trackGameNewsChanged.newsUrl) && m.areEqual(this.newsToIndex, trackGameNewsChanged.newsToIndex) && m.areEqual(this.newsFromIndex, trackGameNewsChanged.newsFromIndex) && m.areEqual(this.newsChangeType, trackGameNewsChanged.newsChangeType);
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
        StringBuilder sbU = a.U("TrackGameNewsChanged(changeCount=");
        sbU.append(this.changeCount);
        sbU.append(", newsUrl=");
        sbU.append(this.newsUrl);
        sbU.append(", newsToIndex=");
        sbU.append(this.newsToIndex);
        sbU.append(", newsFromIndex=");
        sbU.append(this.newsFromIndex);
        sbU.append(", newsChangeType=");
        return a.E(sbU, this.newsChangeType, ")");
    }
}
