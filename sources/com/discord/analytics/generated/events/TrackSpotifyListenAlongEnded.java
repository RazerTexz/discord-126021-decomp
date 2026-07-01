package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSpotifyListenAlongEnded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSpotifyListenAlongEnded implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence partyId = null;
    private final Long otherUserId = null;
    private final transient String analyticsSchemaTypeName = "spotify_listen_along_ended";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSpotifyListenAlongEnded)) {
            return false;
        }
        TrackSpotifyListenAlongEnded trackSpotifyListenAlongEnded = (TrackSpotifyListenAlongEnded) other;
        return m.areEqual(this.partyId, trackSpotifyListenAlongEnded.partyId) && m.areEqual(this.otherUserId, trackSpotifyListenAlongEnded.otherUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.partyId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.otherUserId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSpotifyListenAlongEnded(partyId=");
        sbU.append(this.partyId);
        sbU.append(", otherUserId=");
        return a.G(sbU, this.otherUserId, ")");
    }
}
