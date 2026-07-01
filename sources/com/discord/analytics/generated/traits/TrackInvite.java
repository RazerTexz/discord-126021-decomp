package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInvite {
    private final CharSequence inviteCode = null;
    private final Long inviteGuildId = null;
    private final Long inviteChannelId = null;
    private final Long inviteChannelType = null;
    private final Long inviteInviterId = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInvite)) {
            return false;
        }
        TrackInvite trackInvite = (TrackInvite) other;
        return m.areEqual(this.inviteCode, trackInvite.inviteCode) && m.areEqual(this.inviteGuildId, trackInvite.inviteGuildId) && m.areEqual(this.inviteChannelId, trackInvite.inviteChannelId) && m.areEqual(this.inviteChannelType, trackInvite.inviteChannelType) && m.areEqual(this.inviteInviterId, trackInvite.inviteInviterId);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.inviteGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.inviteChannelId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.inviteChannelType;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviteInviterId;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackInvite(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", inviteGuildId=");
        sbU.append(this.inviteGuildId);
        sbU.append(", inviteChannelId=");
        sbU.append(this.inviteChannelId);
        sbU.append(", inviteChannelType=");
        sbU.append(this.inviteChannelType);
        sbU.append(", inviteInviterId=");
        return a.G(sbU, this.inviteInviterId, ")");
    }
}
