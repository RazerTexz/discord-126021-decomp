package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackAfParty;
import com.discord.analytics.generated.traits.TrackAfPartyReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.popoutUserId, trackAfUserPopoutOpened.popoutUserId) && m.areEqual(this.avatarPosition, trackAfUserPopoutOpened.avatarPosition);
    }

    public int hashCode() {
        Long l = this.popoutUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.avatarPosition;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAfUserPopoutOpened(popoutUserId=");
        sbU.append(this.popoutUserId);
        sbU.append(", avatarPosition=");
        return a.G(sbU, this.avatarPosition, ")");
    }
}
