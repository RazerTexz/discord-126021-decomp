package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAfLoaded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfLoaded implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
        return C12238m.areEqual(this.loadId, trackAfLoaded.loadId) && C12238m.areEqual(this.gameIds, trackAfLoaded.gameIds) && C12238m.areEqual(this.numCards, trackAfLoaded.numCards) && C12238m.areEqual(this.numCardsVisible, trackAfLoaded.numCardsVisible) && C12238m.areEqual(this.numCardsGameNews, trackAfLoaded.numCardsGameNews) && C12238m.areEqual(this.numCardsGamePlayable, trackAfLoaded.numCardsGamePlayable) && C12238m.areEqual(this.numGameParties, trackAfLoaded.numGameParties) && C12238m.areEqual(this.numGamePartiesVoice, trackAfLoaded.numGamePartiesVoice) && C12238m.areEqual(this.numGamePartiesSolo, trackAfLoaded.numGamePartiesSolo) && C12238m.areEqual(this.numGamePartiesRecentlyPlayed, trackAfLoaded.numGamePartiesRecentlyPlayed) && C12238m.areEqual(this.numGamePartiesRichPresence, trackAfLoaded.numGamePartiesRichPresence) && C12238m.areEqual(this.numGamePartiesCollapsed, trackAfLoaded.numGamePartiesCollapsed) && C12238m.areEqual(this.numSoloCollapsed, trackAfLoaded.numSoloCollapsed) && C12238m.areEqual(this.numRecentlyPlayedCollapsed, trackAfLoaded.numRecentlyPlayedCollapsed) && C12238m.areEqual(this.numUsersSubscribed, trackAfLoaded.numUsersSubscribed) && C12238m.areEqual(this.numLauncherApplications, trackAfLoaded.numLauncherApplications) && C12238m.areEqual(this.windowWidth, trackAfLoaded.windowWidth) && C12238m.areEqual(this.windowHeight, trackAfLoaded.windowHeight) && C12238m.areEqual(this.feedLayout, trackAfLoaded.feedLayout) && C12238m.areEqual(this.subscribedGames, trackAfLoaded.subscribedGames) && C12238m.areEqual(this.numItemsNowPlaying, trackAfLoaded.numItemsNowPlaying) && C12238m.areEqual(this.numItemsRecentlyPlayed, trackAfLoaded.numItemsRecentlyPlayed) && C12238m.areEqual(this.newsIdsViewed, trackAfLoaded.newsIdsViewed) && C12238m.areEqual(this.guildIdsViewed, trackAfLoaded.guildIdsViewed);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAfLoaded(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", gameIds=");
        sbM833U.append(this.gameIds);
        sbM833U.append(", numCards=");
        sbM833U.append(this.numCards);
        sbM833U.append(", numCardsVisible=");
        sbM833U.append(this.numCardsVisible);
        sbM833U.append(", numCardsGameNews=");
        sbM833U.append(this.numCardsGameNews);
        sbM833U.append(", numCardsGamePlayable=");
        sbM833U.append(this.numCardsGamePlayable);
        sbM833U.append(", numGameParties=");
        sbM833U.append(this.numGameParties);
        sbM833U.append(", numGamePartiesVoice=");
        sbM833U.append(this.numGamePartiesVoice);
        sbM833U.append(", numGamePartiesSolo=");
        sbM833U.append(this.numGamePartiesSolo);
        sbM833U.append(", numGamePartiesRecentlyPlayed=");
        sbM833U.append(this.numGamePartiesRecentlyPlayed);
        sbM833U.append(", numGamePartiesRichPresence=");
        sbM833U.append(this.numGamePartiesRichPresence);
        sbM833U.append(", numGamePartiesCollapsed=");
        sbM833U.append(this.numGamePartiesCollapsed);
        sbM833U.append(", numSoloCollapsed=");
        sbM833U.append(this.numSoloCollapsed);
        sbM833U.append(", numRecentlyPlayedCollapsed=");
        sbM833U.append(this.numRecentlyPlayedCollapsed);
        sbM833U.append(", numUsersSubscribed=");
        sbM833U.append(this.numUsersSubscribed);
        sbM833U.append(", numLauncherApplications=");
        sbM833U.append(this.numLauncherApplications);
        sbM833U.append(", windowWidth=");
        sbM833U.append(this.windowWidth);
        sbM833U.append(", windowHeight=");
        sbM833U.append(this.windowHeight);
        sbM833U.append(", feedLayout=");
        sbM833U.append(this.feedLayout);
        sbM833U.append(", subscribedGames=");
        sbM833U.append(this.subscribedGames);
        sbM833U.append(", numItemsNowPlaying=");
        sbM833U.append(this.numItemsNowPlaying);
        sbM833U.append(", numItemsRecentlyPlayed=");
        sbM833U.append(this.numItemsRecentlyPlayed);
        sbM833U.append(", newsIdsViewed=");
        sbM833U.append(this.newsIdsViewed);
        sbM833U.append(", guildIdsViewed=");
        return C1643a.m824L(sbM833U, this.guildIdsViewed, ")");
    }
}
