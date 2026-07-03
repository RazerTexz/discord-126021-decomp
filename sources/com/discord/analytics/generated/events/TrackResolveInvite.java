package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackResolveInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackResolveInvite implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean resolved = null;
    private final CharSequence code = null;
    private final Boolean authenticated = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long inviterId = null;
    private final Long sizeTotal = null;
    private final Long sizeOnline = null;
    private final CharSequence inviteType = null;
    private final Long destinationUserId = null;
    private final Boolean userBanned = null;
    private final CharSequence inputValue = null;
    private final Long errorCode = null;
    private final CharSequence errorMessage = null;
    private final transient String analyticsSchemaTypeName = "resolve_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackResolveInvite)) {
            return false;
        }
        TrackResolveInvite trackResolveInvite = (TrackResolveInvite) other;
        return C12238m.areEqual(this.resolved, trackResolveInvite.resolved) && C12238m.areEqual(this.code, trackResolveInvite.code) && C12238m.areEqual(this.authenticated, trackResolveInvite.authenticated) && C12238m.areEqual(this.guildId, trackResolveInvite.guildId) && C12238m.areEqual(this.channelId, trackResolveInvite.channelId) && C12238m.areEqual(this.channelType, trackResolveInvite.channelType) && C12238m.areEqual(this.inviterId, trackResolveInvite.inviterId) && C12238m.areEqual(this.sizeTotal, trackResolveInvite.sizeTotal) && C12238m.areEqual(this.sizeOnline, trackResolveInvite.sizeOnline) && C12238m.areEqual(this.inviteType, trackResolveInvite.inviteType) && C12238m.areEqual(this.destinationUserId, trackResolveInvite.destinationUserId) && C12238m.areEqual(this.userBanned, trackResolveInvite.userBanned) && C12238m.areEqual(this.inputValue, trackResolveInvite.inputValue) && C12238m.areEqual(this.errorCode, trackResolveInvite.errorCode) && C12238m.areEqual(this.errorMessage, trackResolveInvite.errorMessage);
    }

    public int hashCode() {
        Boolean bool = this.resolved;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.code;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool2 = this.authenticated;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.inviterId;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.sizeTotal;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.sizeOnline;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.inviteType;
        int iHashCode10 = (iHashCode9 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l7 = this.destinationUserId;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool3 = this.userBanned;
        int iHashCode12 = (iHashCode11 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.inputValue;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l8 = this.errorCode;
        int iHashCode14 = (iHashCode13 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.errorMessage;
        return iHashCode14 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackResolveInvite(resolved=");
        sbM833U.append(this.resolved);
        sbM833U.append(", code=");
        sbM833U.append(this.code);
        sbM833U.append(", authenticated=");
        sbM833U.append(this.authenticated);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", inviterId=");
        sbM833U.append(this.inviterId);
        sbM833U.append(", sizeTotal=");
        sbM833U.append(this.sizeTotal);
        sbM833U.append(", sizeOnline=");
        sbM833U.append(this.sizeOnline);
        sbM833U.append(", inviteType=");
        sbM833U.append(this.inviteType);
        sbM833U.append(", destinationUserId=");
        sbM833U.append(this.destinationUserId);
        sbM833U.append(", userBanned=");
        sbM833U.append(this.userBanned);
        sbM833U.append(", inputValue=");
        sbM833U.append(this.inputValue);
        sbM833U.append(", errorCode=");
        sbM833U.append(this.errorCode);
        sbM833U.append(", errorMessage=");
        return C1643a.m817E(sbM833U, this.errorMessage, ")");
    }
}
