package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.guildId, trackChannelPermissionsOverwriteUpdated.guildId) && C12238m.areEqual(this.channelId, trackChannelPermissionsOverwriteUpdated.channelId) && C12238m.areEqual(this.targetRoleId, trackChannelPermissionsOverwriteUpdated.targetRoleId) && C12238m.areEqual(this.targetUserId, trackChannelPermissionsOverwriteUpdated.targetUserId) && C12238m.areEqual(this.permissionsAllow, trackChannelPermissionsOverwriteUpdated.permissionsAllow) && C12238m.areEqual(this.permissionsDeny, trackChannelPermissionsOverwriteUpdated.permissionsDeny) && C12238m.areEqual(this.updateType, trackChannelPermissionsOverwriteUpdated.updateType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelPermissionsOverwriteUpdated(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", targetRoleId=");
        sbM833U.append(this.targetRoleId);
        sbM833U.append(", targetUserId=");
        sbM833U.append(this.targetUserId);
        sbM833U.append(", permissionsAllow=");
        sbM833U.append(this.permissionsAllow);
        sbM833U.append(", permissionsDeny=");
        sbM833U.append(this.permissionsDeny);
        sbM833U.append(", updateType=");
        return C1643a.m817E(sbM833U, this.updateType, ")");
    }
}
