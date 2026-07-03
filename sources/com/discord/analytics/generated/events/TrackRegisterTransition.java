package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRegisterTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRegisterTransition implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.step, trackRegisterTransition.step) && C12238m.areEqual(this.actionType, trackRegisterTransition.actionType) && C12238m.areEqual(this.actionTypeDetails, trackRegisterTransition.actionTypeDetails) && C12238m.areEqual(this.actionDetails, trackRegisterTransition.actionDetails) && C12238m.areEqual(this.identityType, trackRegisterTransition.identityType) && C12238m.areEqual(this.registrationSource, trackRegisterTransition.registrationSource) && C12238m.areEqual(this.isUnclaimed, trackRegisterTransition.isUnclaimed) && C12238m.areEqual(this.inviteCode, trackRegisterTransition.inviteCode) && C12238m.areEqual(this.inviteGuildId, trackRegisterTransition.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackRegisterTransition.inviteChannelId) && C12238m.areEqual(this.inviteChannelType, trackRegisterTransition.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackRegisterTransition.inviteInviterId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRegisterTransition(step=");
        sbM833U.append(this.step);
        sbM833U.append(", actionType=");
        sbM833U.append(this.actionType);
        sbM833U.append(", actionTypeDetails=");
        sbM833U.append(this.actionTypeDetails);
        sbM833U.append(", actionDetails=");
        sbM833U.append(this.actionDetails);
        sbM833U.append(", identityType=");
        sbM833U.append(this.identityType);
        sbM833U.append(", registrationSource=");
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
