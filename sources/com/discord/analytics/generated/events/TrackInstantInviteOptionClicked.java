package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackInstantInviteOptionClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInstantInviteOptionClicked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence inviteType = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence inviteCode = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;
    private final transient String analyticsSchemaTypeName = "instant_invite_option_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInstantInviteOptionClicked)) {
            return false;
        }
        TrackInstantInviteOptionClicked trackInstantInviteOptionClicked = (TrackInstantInviteOptionClicked) other;
        return C12238m.areEqual(this.inviteType, trackInstantInviteOptionClicked.inviteType) && C12238m.areEqual(this.guildId, trackInstantInviteOptionClicked.guildId) && C12238m.areEqual(this.channelId, trackInstantInviteOptionClicked.channelId) && C12238m.areEqual(this.inviteCode, trackInstantInviteOptionClicked.inviteCode) && C12238m.areEqual(this.inviteChannelType, trackInstantInviteOptionClicked.inviteChannelType) && C12238m.areEqual(this.inviteInviterId, trackInstantInviteOptionClicked.inviteInviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteCode;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackInstantInviteOptionClicked(inviteType=");
        sbM833U.append(this.inviteType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", inviteChannelType=");
        sbM833U.append(this.inviteChannelType);
        sbM833U.append(", inviteInviterId=");
        return C1643a.m819G(sbM833U, this.inviteInviterId, ")");
    }
}
