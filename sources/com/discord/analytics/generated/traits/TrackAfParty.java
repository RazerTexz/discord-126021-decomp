package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

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
        return m.areEqual(this.afVoiceChat, trackAfParty.afVoiceChat) && m.areEqual(this.afPeopleCount, trackAfParty.afPeopleCount) && m.areEqual(this.afRecentlyPlayed, trackAfParty.afRecentlyPlayed) && m.areEqual(this.afRichPresence, trackAfParty.afRichPresence);
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
        StringBuilder sbU = a.U("TrackAfParty(afVoiceChat=");
        sbU.append(this.afVoiceChat);
        sbU.append(", afPeopleCount=");
        sbU.append(this.afPeopleCount);
        sbU.append(", afRecentlyPlayed=");
        sbU.append(this.afRecentlyPlayed);
        sbU.append(", afRichPresence=");
        return a.D(sbU, this.afRichPresence, ")");
    }
}
