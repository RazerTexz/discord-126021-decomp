package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAfGame.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfGame {
    private final Long gameId = null;
    private final CharSequence gameName = null;
    private final Boolean afNews = null;
    private final CharSequence gamePlatform = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfGame)) {
            return false;
        }
        TrackAfGame trackAfGame = (TrackAfGame) other;
        return m.areEqual(this.gameId, trackAfGame.gameId) && m.areEqual(this.gameName, trackAfGame.gameName) && m.areEqual(this.afNews, trackAfGame.afNews) && m.areEqual(this.gamePlatform, trackAfGame.gamePlatform);
    }

    public int hashCode() {
        Long l = this.gameId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.afNews;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gamePlatform;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAfGame(gameId=");
        sbU.append(this.gameId);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", afNews=");
        sbU.append(this.afNews);
        sbU.append(", gamePlatform=");
        return a.E(sbU, this.gamePlatform, ")");
    }
}
