package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSpotifyListenAlongStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSpotifyListenAlongStarted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence partyId = null;
    private final Long otherUserId = null;
    private final transient String analyticsSchemaTypeName = "spotify_listen_along_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSpotifyListenAlongStarted)) {
            return false;
        }
        TrackSpotifyListenAlongStarted trackSpotifyListenAlongStarted = (TrackSpotifyListenAlongStarted) other;
        return m.areEqual(this.partyId, trackSpotifyListenAlongStarted.partyId) && m.areEqual(this.otherUserId, trackSpotifyListenAlongStarted.otherUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.partyId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.otherUserId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSpotifyListenAlongStarted(partyId=");
        sbU.append(this.partyId);
        sbU.append(", otherUserId=");
        return a.G(sbU, this.otherUserId, ")");
    }
}
