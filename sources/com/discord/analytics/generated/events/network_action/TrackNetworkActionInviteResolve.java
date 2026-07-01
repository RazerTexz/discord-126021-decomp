package com.discord.analytics.generated.events.network_action;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNetworkActionInviteResolve.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkActionInviteResolve implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean authenticated;
    private final Long channelId;
    private final Long channelType;
    private final CharSequence code;
    private final Long destinationUserId;
    private final Long guildId;
    private final CharSequence inputValue;
    private final CharSequence inviteType;
    private final Long inviterId;
    private final Boolean resolved;
    private final Long sizeOnline;
    private final Long sizeTotal;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final Boolean userBanned;

    public TrackNetworkActionInviteResolve(Boolean bool, CharSequence charSequence, Boolean bool2, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, CharSequence charSequence2, Long l7, Boolean bool3, CharSequence charSequence3) {
        this.resolved = bool;
        this.code = charSequence;
        this.authenticated = bool2;
        this.guildId = l;
        this.channelId = l2;
        this.channelType = l3;
        this.inviterId = l4;
        this.sizeTotal = l5;
        this.sizeOnline = l6;
        this.inviteType = charSequence2;
        this.destinationUserId = l7;
        this.userBanned = bool3;
        this.inputValue = charSequence3;
        this.analyticsSchemaTypeName = "network_action_invite_resolve";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    public void b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkActionInviteResolve)) {
            return false;
        }
        TrackNetworkActionInviteResolve trackNetworkActionInviteResolve = (TrackNetworkActionInviteResolve) other;
        return Intrinsics3.areEqual(this.resolved, trackNetworkActionInviteResolve.resolved) && Intrinsics3.areEqual(this.code, trackNetworkActionInviteResolve.code) && Intrinsics3.areEqual(this.authenticated, trackNetworkActionInviteResolve.authenticated) && Intrinsics3.areEqual(this.guildId, trackNetworkActionInviteResolve.guildId) && Intrinsics3.areEqual(this.channelId, trackNetworkActionInviteResolve.channelId) && Intrinsics3.areEqual(this.channelType, trackNetworkActionInviteResolve.channelType) && Intrinsics3.areEqual(this.inviterId, trackNetworkActionInviteResolve.inviterId) && Intrinsics3.areEqual(this.sizeTotal, trackNetworkActionInviteResolve.sizeTotal) && Intrinsics3.areEqual(this.sizeOnline, trackNetworkActionInviteResolve.sizeOnline) && Intrinsics3.areEqual(this.inviteType, trackNetworkActionInviteResolve.inviteType) && Intrinsics3.areEqual(this.destinationUserId, trackNetworkActionInviteResolve.destinationUserId) && Intrinsics3.areEqual(this.userBanned, trackNetworkActionInviteResolve.userBanned) && Intrinsics3.areEqual(this.inputValue, trackNetworkActionInviteResolve.inputValue);
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
        return iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkActionInviteResolve(resolved=");
        sbU.append(this.resolved);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", authenticated=");
        sbU.append(this.authenticated);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", inviterId=");
        sbU.append(this.inviterId);
        sbU.append(", sizeTotal=");
        sbU.append(this.sizeTotal);
        sbU.append(", sizeOnline=");
        sbU.append(this.sizeOnline);
        sbU.append(", inviteType=");
        sbU.append(this.inviteType);
        sbU.append(", destinationUserId=");
        sbU.append(this.destinationUserId);
        sbU.append(", userBanned=");
        sbU.append(this.userBanned);
        sbU.append(", inputValue=");
        return outline.E(sbU, this.inputValue, ")");
    }

    public TrackNetworkActionInviteResolve() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
