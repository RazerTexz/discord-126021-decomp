package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGameOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGameOpened implements AnalyticsSchema, TrackBaseReceiver, TrackAfCardReceiver, TrackAfGameReceiver {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final CharSequence source = null;
    private final Long applicationId = null;
    private final CharSequence partyId = null;
    private final Long otherUserId = null;
    private final Long messageId = null;
    private final Long numLauncherApplications = null;
    private final transient String analyticsSchemaTypeName = "game_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGameOpened)) {
            return false;
        }
        TrackGameOpened trackGameOpened = (TrackGameOpened) other;
        return C12238m.areEqual(this.type, trackGameOpened.type) && C12238m.areEqual(this.source, trackGameOpened.source) && C12238m.areEqual(this.applicationId, trackGameOpened.applicationId) && C12238m.areEqual(this.partyId, trackGameOpened.partyId) && C12238m.areEqual(this.otherUserId, trackGameOpened.otherUserId) && C12238m.areEqual(this.messageId, trackGameOpened.messageId) && C12238m.areEqual(this.numLauncherApplications, trackGameOpened.numLauncherApplications);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.partyId;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.otherUserId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numLauncherApplications;
        return iHashCode6 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGameOpened(type=");
        sbM833U.append(this.type);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", partyId=");
        sbM833U.append(this.partyId);
        sbM833U.append(", otherUserId=");
        sbM833U.append(this.otherUserId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", numLauncherApplications=");
        return C1643a.m819G(sbM833U, this.numLauncherApplications, ")");
    }
}
