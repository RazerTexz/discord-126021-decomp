package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackHookResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHookResult implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final CharSequence error = null;
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final CharSequence soundshareSession = null;
    private final transient String analyticsSchemaTypeName = "hook_result";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackHookResult)) {
            return false;
        }
        TrackHookResult trackHookResult = (TrackHookResult) other;
        return Intrinsics3.areEqual(this.success, trackHookResult.success) && Intrinsics3.areEqual(this.error, trackHookResult.error) && Intrinsics3.areEqual(this.gameName, trackHookResult.gameName) && Intrinsics3.areEqual(this.gameId, trackHookResult.gameId) && Intrinsics3.areEqual(this.soundshareSession, trackHookResult.soundshareSession);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.error;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gameName;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.gameId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.soundshareSession;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackHookResult(success=");
        sbU.append(this.success);
        sbU.append(", error=");
        sbU.append(this.error);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", soundshareSession=");
        return outline.E(sbU, this.soundshareSession, ")");
    }
}
