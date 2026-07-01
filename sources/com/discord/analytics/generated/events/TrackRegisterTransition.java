package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackRegisterTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterTransition implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence step = null;
    private final CharSequence actionType = null;
    private final List<CharSequence> actionTypeDetails = null;
    private final List<CharSequence> actionDetails = null;
    private final CharSequence identityType = null;
    private final CharSequence registrationSource = null;
    private final Boolean isUnclaimed = null;
    private final CharSequence inviteCode = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final transient String analyticsSchemaTypeName = "register_transition";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRegisterTransition)) {
            return false;
        }
        TrackRegisterTransition trackRegisterTransition = (TrackRegisterTransition) other;
        return Intrinsics3.areEqual(this.step, trackRegisterTransition.step) && Intrinsics3.areEqual(this.actionType, trackRegisterTransition.actionType) && Intrinsics3.areEqual(this.actionTypeDetails, trackRegisterTransition.actionTypeDetails) && Intrinsics3.areEqual(this.actionDetails, trackRegisterTransition.actionDetails) && Intrinsics3.areEqual(this.identityType, trackRegisterTransition.identityType) && Intrinsics3.areEqual(this.registrationSource, trackRegisterTransition.registrationSource) && Intrinsics3.areEqual(this.isUnclaimed, trackRegisterTransition.isUnclaimed) && Intrinsics3.areEqual(this.inviteCode, trackRegisterTransition.inviteCode) && Intrinsics3.areEqual(this.inviteGuildId, trackRegisterTransition.inviteGuildId) && Intrinsics3.areEqual(this.inviteChannelId, trackRegisterTransition.inviteChannelId) && Intrinsics3.areEqual(this.inviteChannelType, trackRegisterTransition.inviteChannelType) && Intrinsics3.areEqual(this.inviteInviterId, trackRegisterTransition.inviteInviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.step;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.actionType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        List<CharSequence> list = this.actionTypeDetails;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.actionDetails;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.identityType;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.registrationSource;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.isUnclaimed;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.inviteCode;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l = this.inviteGuildId;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteChannelId;
        int iHashCode10 = (iHashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        return iHashCode11 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRegisterTransition(step=");
        sbU.append(this.step);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", actionTypeDetails=");
        sbU.append(this.actionTypeDetails);
        sbU.append(", actionDetails=");
        sbU.append(this.actionDetails);
        sbU.append(", identityType=");
        sbU.append(this.identityType);
        sbU.append(", registrationSource=");
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
