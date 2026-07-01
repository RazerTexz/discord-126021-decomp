package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackRegisterViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterViewed implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2 {
    private TrackBase trackBase;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence registrationSource = null;
    private final Boolean isUnclaimed = null;
    private final CharSequence inviteCode = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final transient String analyticsSchemaTypeName = "register_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRegisterViewed)) {
            return false;
        }
        TrackRegisterViewed trackRegisterViewed = (TrackRegisterViewed) other;
        return Intrinsics3.areEqual(this.registrationSource, trackRegisterViewed.registrationSource) && Intrinsics3.areEqual(this.isUnclaimed, trackRegisterViewed.isUnclaimed) && Intrinsics3.areEqual(this.inviteCode, trackRegisterViewed.inviteCode) && Intrinsics3.areEqual(this.inviteGuildId, trackRegisterViewed.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackRegisterViewed.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackRegisterViewed.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackRegisterViewed.inviteInviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.registrationSource;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isUnclaimed;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.inviteGuildId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteChannelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        return iHashCode6 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRegisterViewed(registrationSource=");
        sbU.append(this.registrationSource);
        sbU.append(", isUnclaimed=");
        sbU.append(this.isUnclaimed);
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
