package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackLoginViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLoginViewed implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2 {
    private TrackBase trackBase;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence loginSource = null;
    private final CharSequence inviteCode = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final transient String analyticsSchemaTypeName = "login_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLoginViewed)) {
            return false;
        }
        TrackLoginViewed trackLoginViewed = (TrackLoginViewed) other;
        return Intrinsics3.areEqual(this.loginSource, trackLoginViewed.loginSource) && Intrinsics3.areEqual(this.inviteCode, trackLoginViewed.inviteCode) && Intrinsics3.areEqual(this.inviteGuildId, trackLoginViewed.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackLoginViewed.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackLoginViewed.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackLoginViewed.inviteInviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loginSource;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.inviteGuildId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteChannelId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLoginViewed(loginSource=");
        sbU.append(this.loginSource);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        return outline.G(sbU, this.inviteInviterId, ")");
    }
}
