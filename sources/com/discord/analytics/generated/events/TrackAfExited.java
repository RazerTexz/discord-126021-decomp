package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackAfExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfExited implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final List<Long> gameIdsViewed = null;
    private final List<Long> storeApplicationIdsViewed = null;
    private final List<Long> storeSkuIdsViewed = null;
    private final Long numGamesViewed = null;
    private final Long numCardsViewed = null;
    private final Long secondsSpent = null;
    private final CharSequence feedLayout = null;
    private final Long windowWidth = null;
    private final Long windowHeight = null;
    private final List<Long> subscribedGames = null;
    private final Long numCardsTotal = null;
    private final List<Long> newsIdsViewed = null;
    private final transient String analyticsSchemaTypeName = "af_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfExited)) {
            return false;
        }
        TrackAfExited trackAfExited = (TrackAfExited) other;
        return Intrinsics3.areEqual(this.loadId, trackAfExited.loadId) && Intrinsics3.areEqual(this.gameIdsViewed, trackAfExited.gameIdsViewed) && Intrinsics3.areEqual(this.storeApplicationIdsViewed, trackAfExited.storeApplicationIdsViewed) && Intrinsics3.areEqual(this.storeSkuIdsViewed, trackAfExited.storeSkuIdsViewed) && Intrinsics3.areEqual(this.numGamesViewed, trackAfExited.numGamesViewed) && Intrinsics3.areEqual(this.numCardsViewed, trackAfExited.numCardsViewed) && Intrinsics3.areEqual(this.secondsSpent, trackAfExited.secondsSpent) && Intrinsics3.areEqual(this.feedLayout, trackAfExited.feedLayout) && Intrinsics3.areEqual(this.windowWidth, trackAfExited.windowWidth) && Intrinsics3.areEqual(this.windowHeight, trackAfExited.windowHeight) && Intrinsics3.areEqual(this.subscribedGames, trackAfExited.subscribedGames) && Intrinsics3.areEqual(this.numCardsTotal, trackAfExited.numCardsTotal) && Intrinsics3.areEqual(this.newsIdsViewed, trackAfExited.newsIdsViewed);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.gameIdsViewed;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.storeApplicationIdsViewed;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.storeSkuIdsViewed;
        int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Long l = this.numGamesViewed;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numCardsViewed;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.secondsSpent;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.feedLayout;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.windowWidth;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.windowHeight;
        int iHashCode10 = (iHashCode9 + (l5 != null ? l5.hashCode() : 0)) * 31;
        List<Long> list4 = this.subscribedGames;
        int iHashCode11 = (iHashCode10 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Long l6 = this.numCardsTotal;
        int iHashCode12 = (iHashCode11 + (l6 != null ? l6.hashCode() : 0)) * 31;
        List<Long> list5 = this.newsIdsViewed;
        return iHashCode12 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfExited(loadId=");
        sbU.append(this.loadId);
        sbU.append(", gameIdsViewed=");
        sbU.append(this.gameIdsViewed);
        sbU.append(", storeApplicationIdsViewed=");
        sbU.append(this.storeApplicationIdsViewed);
        sbU.append(", storeSkuIdsViewed=");
        sbU.append(this.storeSkuIdsViewed);
        sbU.append(", numGamesViewed=");
        sbU.append(this.numGamesViewed);
        sbU.append(", numCardsViewed=");
        sbU.append(this.numCardsViewed);
        sbU.append(", secondsSpent=");
        sbU.append(this.secondsSpent);
        sbU.append(", feedLayout=");
        sbU.append(this.feedLayout);
        sbU.append(", windowWidth=");
        sbU.append(this.windowWidth);
        sbU.append(", windowHeight=");
        sbU.append(this.windowHeight);
        sbU.append(", subscribedGames=");
        sbU.append(this.subscribedGames);
        sbU.append(", numCardsTotal=");
        sbU.append(this.numCardsTotal);
        sbU.append(", newsIdsViewed=");
        return outline.L(sbU, this.newsIdsViewed, ")");
    }
}
