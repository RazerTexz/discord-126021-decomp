package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNotificationSentGameLaunched.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationSentGameLaunched implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long launchingUserId = null;
    private final CharSequence gameName = null;
    private final Boolean desktop = null;
    private final Boolean mobile = null;
    private final transient String analyticsSchemaTypeName = "notification_sent_game_launched";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationSentGameLaunched)) {
            return false;
        }
        TrackNotificationSentGameLaunched trackNotificationSentGameLaunched = (TrackNotificationSentGameLaunched) other;
        return C12238m.areEqual(this.launchingUserId, trackNotificationSentGameLaunched.launchingUserId) && C12238m.areEqual(this.gameName, trackNotificationSentGameLaunched.gameName) && C12238m.areEqual(this.desktop, trackNotificationSentGameLaunched.desktop) && C12238m.areEqual(this.mobile, trackNotificationSentGameLaunched.mobile);
    }

    public int hashCode() {
        Long l = this.launchingUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.desktop;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.mobile;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNotificationSentGameLaunched(launchingUserId=");
        sbM833U.append(this.launchingUserId);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", desktop=");
        sbM833U.append(this.desktop);
        sbM833U.append(", mobile=");
        return C1643a.m816D(sbM833U, this.mobile, ")");
    }
}
