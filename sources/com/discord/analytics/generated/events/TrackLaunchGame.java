package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackLaunchGame.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLaunchGame implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence game = null;
    private final Long gameId = null;
    private final Boolean verified = null;
    private final Boolean elevated = null;
    private final CharSequence customName = null;
    private final CharSequence platformType = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence distributor = null;
    private final transient String analyticsSchemaTypeName = "launch_game";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLaunchGame)) {
            return false;
        }
        TrackLaunchGame trackLaunchGame = (TrackLaunchGame) other;
        return Intrinsics3.areEqual(this.game, trackLaunchGame.game) && Intrinsics3.areEqual(this.gameId, trackLaunchGame.gameId) && Intrinsics3.areEqual(this.verified, trackLaunchGame.verified) && Intrinsics3.areEqual(this.elevated, trackLaunchGame.elevated) && Intrinsics3.areEqual(this.customName, trackLaunchGame.customName) && Intrinsics3.areEqual(this.platformType, trackLaunchGame.platformType) && Intrinsics3.areEqual(this.gamePlatform, trackLaunchGame.gamePlatform) && Intrinsics3.areEqual(this.distributor, trackLaunchGame.distributor);
    }

    public int hashCode() {
        CharSequence charSequence = this.game;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.gameId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.verified;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.elevated;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.customName;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.platformType;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gamePlatform;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.distributor;
        return iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLaunchGame(game=");
        sbU.append(this.game);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", verified=");
        sbU.append(this.verified);
        sbU.append(", elevated=");
        sbU.append(this.elevated);
        sbU.append(", customName=");
        sbU.append(this.customName);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", distributor=");
        return outline.E(sbU, this.distributor, ")");
    }
}
