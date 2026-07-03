package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmailReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackEmailClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmailClicked implements AnalyticsSchema, TrackBaseReceiver, TrackEmailReceiver {
    private TrackBase trackBase;
    private TrackEmail trackEmail;
    private final CharSequence trackingId = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence path = null;
    private final CharSequence actionType = null;
    private final CharSequence target = null;
    private final Long targetGuildId = null;
    private final Long targetChannelId = null;
    private final transient String analyticsSchemaTypeName = "email_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmailClicked)) {
            return false;
        }
        TrackEmailClicked trackEmailClicked = (TrackEmailClicked) other;
        return C12238m.areEqual(this.trackingId, trackEmailClicked.trackingId) && C12238m.areEqual(this.guildId, trackEmailClicked.guildId) && C12238m.areEqual(this.channelId, trackEmailClicked.channelId) && C12238m.areEqual(this.path, trackEmailClicked.path) && C12238m.areEqual(this.actionType, trackEmailClicked.actionType) && C12238m.areEqual(this.target, trackEmailClicked.target) && C12238m.areEqual(this.targetGuildId, trackEmailClicked.targetGuildId) && C12238m.areEqual(this.targetChannelId, trackEmailClicked.targetChannelId);
    }

    public int hashCode() {
        CharSequence charSequence = this.trackingId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.path;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionType;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.target;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.targetGuildId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.targetChannelId;
        return iHashCode7 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackEmailClicked(trackingId=");
        sbM833U.append(this.trackingId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", path=");
        sbM833U.append(this.path);
        sbM833U.append(", actionType=");
        sbM833U.append(this.actionType);
        sbM833U.append(", target=");
        sbM833U.append(this.target);
        sbM833U.append(", targetGuildId=");
        sbM833U.append(this.targetGuildId);
        sbM833U.append(", targetChannelId=");
        return C1643a.m819G(sbM833U, this.targetChannelId, ")");
    }
}
