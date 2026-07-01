package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGameOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGameOpened implements AnalyticsSchema, TrackBase2, TrackAfCard2, TrackAfGame2 {
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
        return Intrinsics3.areEqual(this.type, trackGameOpened.type) && Intrinsics3.areEqual(this.source, trackGameOpened.source) && Intrinsics3.areEqual(this.applicationId, trackGameOpened.applicationId) && Intrinsics3.areEqual(this.partyId, trackGameOpened.partyId) && Intrinsics3.areEqual(this.otherUserId, trackGameOpened.otherUserId) && Intrinsics3.areEqual(this.messageId, trackGameOpened.messageId) && Intrinsics3.areEqual(this.numLauncherApplications, trackGameOpened.numLauncherApplications);
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
        StringBuilder sbU = outline.U("TrackGameOpened(type=");
        sbU.append(this.type);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", partyId=");
        sbU.append(this.partyId);
        sbU.append(", otherUserId=");
        sbU.append(this.otherUserId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", numLauncherApplications=");
        return outline.G(sbU, this.numLauncherApplications, ")");
    }
}
