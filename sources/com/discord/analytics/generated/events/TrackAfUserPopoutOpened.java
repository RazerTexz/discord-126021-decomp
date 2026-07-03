package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackAfParty;
import com.discord.analytics.generated.traits.TrackAfPartyReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAfUserPopoutOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfUserPopoutOpened implements AnalyticsSchema, TrackBaseReceiver, TrackAfCardReceiver, TrackAfGameReceiver, TrackAfPartyReceiver {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackAfParty trackAfParty;
    private TrackBase trackBase;
    private final Long popoutUserId = null;
    private final Long avatarPosition = null;
    private final transient String analyticsSchemaTypeName = "af_user_popout_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfUserPopoutOpened)) {
            return false;
        }
        TrackAfUserPopoutOpened trackAfUserPopoutOpened = (TrackAfUserPopoutOpened) other;
        return C12238m.areEqual(this.popoutUserId, trackAfUserPopoutOpened.popoutUserId) && C12238m.areEqual(this.avatarPosition, trackAfUserPopoutOpened.avatarPosition);
    }

    public int hashCode() {
        Long l = this.popoutUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.avatarPosition;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAfUserPopoutOpened(popoutUserId=");
        sbM833U.append(this.popoutUserId);
        sbM833U.append(", avatarPosition=");
        return C1643a.m819G(sbM833U, this.avatarPosition, ")");
    }
}
