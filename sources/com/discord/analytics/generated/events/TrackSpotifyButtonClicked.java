package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSpotifyButtonClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSpotifyButtonClicked implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.type, trackSpotifyButtonClicked.type) && C12238m.areEqual(this.isPremium, trackSpotifyButtonClicked.isPremium) && C12238m.areEqual(this.partyId, trackSpotifyButtonClicked.partyId) && C12238m.areEqual(this.otherUserId, trackSpotifyButtonClicked.otherUserId) && C12238m.areEqual(this.source, trackSpotifyButtonClicked.source);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSpotifyButtonClicked(type=");
        sbM833U.append(this.type);
        sbM833U.append(", isPremium=");
        sbM833U.append(this.isPremium);
        sbM833U.append(", partyId=");
        sbM833U.append(this.partyId);
        sbM833U.append(", otherUserId=");
        sbM833U.append(this.otherUserId);
        sbM833U.append(", source=");
        return C1643a.m817E(sbM833U, this.source, ")");
    }
}
