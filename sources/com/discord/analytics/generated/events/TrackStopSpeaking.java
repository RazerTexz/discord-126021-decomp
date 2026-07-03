package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStopSpeaking.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStopSpeaking implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long duration = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final transient String analyticsSchemaTypeName = "stop_speaking";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStopSpeaking)) {
            return false;
        }
        TrackStopSpeaking trackStopSpeaking = (TrackStopSpeaking) other;
        return C12238m.areEqual(this.duration, trackStopSpeaking.duration) && C12238m.areEqual(this.gamePlatform, trackStopSpeaking.gamePlatform) && C12238m.areEqual(this.gameName, trackStopSpeaking.gameName) && C12238m.areEqual(this.gameId, trackStopSpeaking.gameId);
    }

    public int hashCode() {
        Long l = this.duration;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gamePlatform;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gameName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.gameId;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStopSpeaking(duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gameId=");
        return C1643a.m819G(sbM833U, this.gameId, ")");
    }
}
