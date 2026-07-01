package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackChannelPermissionsOverwriteUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelPermissionsOverwriteUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long targetRoleId = null;
    private final Long targetUserId = null;
    private final Long permissionsAllow = null;
    private final Long permissionsDeny = null;
    private final CharSequence updateType = null;
    private final transient String analyticsSchemaTypeName = "channel_permissions_overwrite_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChannelPermissionsOverwriteUpdated)) {
            return false;
        }
        TrackChannelPermissionsOverwriteUpdated trackChannelPermissionsOverwriteUpdated = (TrackChannelPermissionsOverwriteUpdated) other;
        return m.areEqual(this.guildId, trackChannelPermissionsOverwriteUpdated.guildId) && m.areEqual(this.channelId, trackChannelPermissionsOverwriteUpdated.channelId) && m.areEqual(this.targetRoleId, trackChannelPermissionsOverwriteUpdated.targetRoleId) && m.areEqual(this.targetUserId, trackChannelPermissionsOverwriteUpdated.targetUserId) && m.areEqual(this.permissionsAllow, trackChannelPermissionsOverwriteUpdated.permissionsAllow) && m.areEqual(this.permissionsDeny, trackChannelPermissionsOverwriteUpdated.permissionsDeny) && m.areEqual(this.updateType, trackChannelPermissionsOverwriteUpdated.updateType);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.targetRoleId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.targetUserId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.permissionsAllow;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.permissionsDeny;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence = this.updateType;
        return iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackChannelPermissionsOverwriteUpdated(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", targetRoleId=");
        sbU.append(this.targetRoleId);
        sbU.append(", targetUserId=");
        sbU.append(this.targetUserId);
        sbU.append(", permissionsAllow=");
        sbU.append(this.permissionsAllow);
        sbU.append(", permissionsDeny=");
        sbU.append(this.permissionsDeny);
        sbU.append(", updateType=");
        return a.E(sbU, this.updateType, ")");
    }
}
