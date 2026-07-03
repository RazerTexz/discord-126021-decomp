package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRegisterViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterViewed implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver {
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
        return C12238m.areEqual(this.registrationSource, trackRegisterViewed.registrationSource) && C12238m.areEqual(this.isUnclaimed, trackRegisterViewed.isUnclaimed) && C12238m.areEqual(this.inviteCode, trackRegisterViewed.inviteCode) && C12238m.areEqual(this.inviteGuildId, trackRegisterViewed.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackRegisterViewed.inviteChannelId) && C12238m.areEqual(this.inviteChannelType, trackRegisterViewed.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackRegisterViewed.inviteInviterId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRegisterViewed(registrationSource=");
        sbM833U.append(this.registrationSource);
        sbM833U.append(", isUnclaimed=");
        sbM833U.append(this.isUnclaimed);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", inviteGuildId=");
        sbM833U.append(this.inviteGuildId);
        sbM833U.append(", inviteChannelId=");
        sbM833U.append(this.inviteChannelId);
        sbM833U.append(", inviteChannelType=");
        sbM833U.append(this.inviteChannelType);
        sbM833U.append(", inviteInviterId=");
        return C1643a.m819G(sbM833U, this.inviteInviterId, ")");
    }
}
