package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLaunchGame.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLaunchGame implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.game, trackLaunchGame.game) && C12238m.areEqual(this.gameId, trackLaunchGame.gameId) && C12238m.areEqual(this.verified, trackLaunchGame.verified) && C12238m.areEqual(this.elevated, trackLaunchGame.elevated) && C12238m.areEqual(this.customName, trackLaunchGame.customName) && C12238m.areEqual(this.platformType, trackLaunchGame.platformType) && C12238m.areEqual(this.gamePlatform, trackLaunchGame.gamePlatform) && C12238m.areEqual(this.distributor, trackLaunchGame.distributor);
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
        StringBuilder sbM833U = C1643a.m833U("TrackLaunchGame(game=");
        sbM833U.append(this.game);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", verified=");
        sbM833U.append(this.verified);
        sbM833U.append(", elevated=");
        sbM833U.append(this.elevated);
        sbM833U.append(", customName=");
        sbM833U.append(this.customName);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", distributor=");
        return C1643a.m817E(sbM833U, this.distributor, ")");
    }
}
