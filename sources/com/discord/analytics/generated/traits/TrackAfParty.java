package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAfParty.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfParty {
    private final Boolean afVoiceChat = null;
    private final Long afPeopleCount = null;
    private final Boolean afRecentlyPlayed = null;
    private final Boolean afRichPresence = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfParty)) {
            return false;
        }
        TrackAfParty trackAfParty = (TrackAfParty) other;
        return C12238m.areEqual(this.afVoiceChat, trackAfParty.afVoiceChat) && C12238m.areEqual(this.afPeopleCount, trackAfParty.afPeopleCount) && C12238m.areEqual(this.afRecentlyPlayed, trackAfParty.afRecentlyPlayed) && C12238m.areEqual(this.afRichPresence, trackAfParty.afRichPresence);
    }

    public int hashCode() {
        Boolean bool = this.afVoiceChat;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.afPeopleCount;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.afRecentlyPlayed;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.afRichPresence;
        return iHashCode3 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAfParty(afVoiceChat=");
        sbM833U.append(this.afVoiceChat);
        sbM833U.append(", afPeopleCount=");
        sbM833U.append(this.afPeopleCount);
        sbM833U.append(", afRecentlyPlayed=");
        sbM833U.append(this.afRecentlyPlayed);
        sbM833U.append(", afRichPresence=");
        return C1643a.m816D(sbM833U, this.afRichPresence, ")");
    }
}
