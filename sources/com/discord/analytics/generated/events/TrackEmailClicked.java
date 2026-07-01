package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmail2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackEmailClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmailClicked implements AnalyticsSchema, TrackBase2, TrackEmail2 {
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
        return Intrinsics3.areEqual(this.trackingId, trackEmailClicked.trackingId) && Intrinsics3.areEqual(this.guildId, trackEmailClicked.guildId) && Intrinsics3.areEqual(this.channelId, trackEmailClicked.channelId) && Intrinsics3.areEqual(this.path, trackEmailClicked.path) && Intrinsics3.areEqual(this.actionType, trackEmailClicked.actionType) && Intrinsics3.areEqual(this.target, trackEmailClicked.target) && Intrinsics3.areEqual(this.targetGuildId, trackEmailClicked.targetGuildId) && Intrinsics3.areEqual(this.targetChannelId, trackEmailClicked.targetChannelId);
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
        StringBuilder sbU = outline.U("TrackEmailClicked(trackingId=");
        sbU.append(this.trackingId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", path=");
        sbU.append(this.path);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", target=");
        sbU.append(this.target);
        sbU.append(", targetGuildId=");
        sbU.append(this.targetGuildId);
        sbU.append(", targetChannelId=");
        return outline.G(sbU, this.targetChannelId, ")");
    }
}
