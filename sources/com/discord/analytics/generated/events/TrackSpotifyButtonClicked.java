package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSpotifyButtonClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSpotifyButtonClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final Boolean isPremium = null;
    private final CharSequence partyId = null;
    private final Long otherUserId = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "spotify_button_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSpotifyButtonClicked)) {
            return false;
        }
        TrackSpotifyButtonClicked trackSpotifyButtonClicked = (TrackSpotifyButtonClicked) other;
        return Intrinsics3.areEqual(this.type, trackSpotifyButtonClicked.type) && Intrinsics3.areEqual(this.isPremium, trackSpotifyButtonClicked.isPremium) && Intrinsics3.areEqual(this.partyId, trackSpotifyButtonClicked.partyId) && Intrinsics3.areEqual(this.otherUserId, trackSpotifyButtonClicked.otherUserId) && Intrinsics3.areEqual(this.source, trackSpotifyButtonClicked.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isPremium;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.partyId;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.otherUserId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.source;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSpotifyButtonClicked(type=");
        sbU.append(this.type);
        sbU.append(", isPremium=");
        sbU.append(this.isPremium);
        sbU.append(", partyId=");
        sbU.append(this.partyId);
        sbU.append(", otherUserId=");
        sbU.append(this.otherUserId);
        sbU.append(", source=");
        return outline.E(sbU, this.source, ")");
    }
}
