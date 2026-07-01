package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackAfLoaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfLoaded implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final List<Long> gameIds = null;
    private final Long numCards = null;
    private final Long numCardsVisible = null;
    private final Long numCardsGameNews = null;
    private final Long numCardsGamePlayable = null;
    private final Long numGameParties = null;
    private final Long numGamePartiesVoice = null;
    private final Long numGamePartiesSolo = null;
    private final Long numGamePartiesRecentlyPlayed = null;
    private final Long numGamePartiesRichPresence = null;
    private final Long numGamePartiesCollapsed = null;
    private final Long numSoloCollapsed = null;
    private final Long numRecentlyPlayedCollapsed = null;
    private final Long numUsersSubscribed = null;
    private final Long numLauncherApplications = null;
    private final Long windowWidth = null;
    private final Long windowHeight = null;
    private final CharSequence feedLayout = null;
    private final List<Long> subscribedGames = null;
    private final Long numItemsNowPlaying = null;
    private final Long numItemsRecentlyPlayed = null;
    private final List<Long> newsIdsViewed = null;
    private final List<Long> guildIdsViewed = null;
    private final transient String analyticsSchemaTypeName = "af_loaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfLoaded)) {
            return false;
        }
        TrackAfLoaded trackAfLoaded = (TrackAfLoaded) other;
        return Intrinsics3.areEqual(this.loadId, trackAfLoaded.loadId) && Intrinsics3.areEqual(this.gameIds, trackAfLoaded.gameIds) && Intrinsics3.areEqual(this.numCards, trackAfLoaded.numCards) && Intrinsics3.areEqual(this.numCardsVisible, trackAfLoaded.numCardsVisible) && Intrinsics3.areEqual(this.numCardsGameNews, trackAfLoaded.numCardsGameNews) && Intrinsics3.areEqual(this.numCardsGamePlayable, trackAfLoaded.numCardsGamePlayable) && Intrinsics3.areEqual(this.numGameParties, trackAfLoaded.numGameParties) && Intrinsics3.areEqual(this.numGamePartiesVoice, trackAfLoaded.numGamePartiesVoice) && Intrinsics3.areEqual(this.numGamePartiesSolo, trackAfLoaded.numGamePartiesSolo) && Intrinsics3.areEqual(this.numGamePartiesRecentlyPlayed, trackAfLoaded.numGamePartiesRecentlyPlayed) && Intrinsics3.areEqual(this.numGamePartiesRichPresence, trackAfLoaded.numGamePartiesRichPresence) && Intrinsics3.areEqual(this.numGamePartiesCollapsed, trackAfLoaded.numGamePartiesCollapsed) && Intrinsics3.areEqual(this.numSoloCollapsed, trackAfLoaded.numSoloCollapsed) && Intrinsics3.areEqual(this.numRecentlyPlayedCollapsed, trackAfLoaded.numRecentlyPlayedCollapsed) && Intrinsics3.areEqual(this.numUsersSubscribed, trackAfLoaded.numUsersSubscribed) && Intrinsics3.areEqual(this.numLauncherApplications, trackAfLoaded.numLauncherApplications) && Intrinsics3.areEqual(this.windowWidth, trackAfLoaded.windowWidth) && Intrinsics3.areEqual(this.windowHeight, trackAfLoaded.windowHeight) && Intrinsics3.areEqual(this.feedLayout, trackAfLoaded.feedLayout) && Intrinsics3.areEqual(this.subscribedGames, trackAfLoaded.subscribedGames) && Intrinsics3.areEqual(this.numItemsNowPlaying, trackAfLoaded.numItemsNowPlaying) && Intrinsics3.areEqual(this.numItemsRecentlyPlayed, trackAfLoaded.numItemsRecentlyPlayed) && Intrinsics3.areEqual(this.newsIdsViewed, trackAfLoaded.newsIdsViewed) && Intrinsics3.areEqual(this.guildIdsViewed, trackAfLoaded.guildIdsViewed);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.gameIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.numCards;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numCardsVisible;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numCardsGameNews;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numCardsGamePlayable;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numGameParties;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numGamePartiesVoice;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.numGamePartiesSolo;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.numGamePartiesRecentlyPlayed;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.numGamePartiesRichPresence;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.numGamePartiesCollapsed;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.numSoloCollapsed;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.numRecentlyPlayedCollapsed;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.numUsersSubscribed;
        int iHashCode15 = (iHashCode14 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.numLauncherApplications;
        int iHashCode16 = (iHashCode15 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.windowWidth;
        int iHashCode17 = (iHashCode16 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.windowHeight;
        int iHashCode18 = (iHashCode17 + (l16 != null ? l16.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.feedLayout;
        int iHashCode19 = (iHashCode18 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        List<Long> list2 = this.subscribedGames;
        int iHashCode20 = (iHashCode19 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l17 = this.numItemsNowPlaying;
        int iHashCode21 = (iHashCode20 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.numItemsRecentlyPlayed;
        int iHashCode22 = (iHashCode21 + (l18 != null ? l18.hashCode() : 0)) * 31;
        List<Long> list3 = this.newsIdsViewed;
        int iHashCode23 = (iHashCode22 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Long> list4 = this.guildIdsViewed;
        return iHashCode23 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfLoaded(loadId=");
        sbU.append(this.loadId);
        sbU.append(", gameIds=");
        sbU.append(this.gameIds);
        sbU.append(", numCards=");
        sbU.append(this.numCards);
        sbU.append(", numCardsVisible=");
        sbU.append(this.numCardsVisible);
        sbU.append(", numCardsGameNews=");
        sbU.append(this.numCardsGameNews);
        sbU.append(", numCardsGamePlayable=");
        sbU.append(this.numCardsGamePlayable);
        sbU.append(", numGameParties=");
        sbU.append(this.numGameParties);
        sbU.append(", numGamePartiesVoice=");
        sbU.append(this.numGamePartiesVoice);
        sbU.append(", numGamePartiesSolo=");
        sbU.append(this.numGamePartiesSolo);
        sbU.append(", numGamePartiesRecentlyPlayed=");
        sbU.append(this.numGamePartiesRecentlyPlayed);
        sbU.append(", numGamePartiesRichPresence=");
        sbU.append(this.numGamePartiesRichPresence);
        sbU.append(", numGamePartiesCollapsed=");
        sbU.append(this.numGamePartiesCollapsed);
        sbU.append(", numSoloCollapsed=");
        sbU.append(this.numSoloCollapsed);
        sbU.append(", numRecentlyPlayedCollapsed=");
        sbU.append(this.numRecentlyPlayedCollapsed);
        sbU.append(", numUsersSubscribed=");
        sbU.append(this.numUsersSubscribed);
        sbU.append(", numLauncherApplications=");
        sbU.append(this.numLauncherApplications);
        sbU.append(", windowWidth=");
        sbU.append(this.windowWidth);
        sbU.append(", windowHeight=");
        sbU.append(this.windowHeight);
        sbU.append(", feedLayout=");
        sbU.append(this.feedLayout);
        sbU.append(", subscribedGames=");
        sbU.append(this.subscribedGames);
        sbU.append(", numItemsNowPlaying=");
        sbU.append(this.numItemsNowPlaying);
        sbU.append(", numItemsRecentlyPlayed=");
        sbU.append(this.numItemsRecentlyPlayed);
        sbU.append(", newsIdsViewed=");
        sbU.append(this.newsIdsViewed);
        sbU.append(", guildIdsViewed=");
        return outline.L(sbU, this.guildIdsViewed, ")");
    }
}
