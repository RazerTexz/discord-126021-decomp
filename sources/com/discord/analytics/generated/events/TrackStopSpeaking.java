package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStopSpeaking.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStopSpeaking implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.duration, trackStopSpeaking.duration) && Intrinsics3.areEqual(this.gamePlatform, trackStopSpeaking.gamePlatform) && Intrinsics3.areEqual(this.gameName, trackStopSpeaking.gameName) && Intrinsics3.areEqual(this.gameId, trackStopSpeaking.gameId);
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
        StringBuilder sbU = outline.U("TrackStopSpeaking(duration=");
        sbU.append(this.duration);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameId=");
        return outline.G(sbU, this.gameId, ")");
    }
}
