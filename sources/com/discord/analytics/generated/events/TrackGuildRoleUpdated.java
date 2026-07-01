package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildRoleUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildRoleUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence action = null;
    private final Long guildId = null;
    private final Long roleId = null;
    private final Long rolePermissions = null;
    private final Boolean roleMentionable = null;
    private final Boolean roleHoist = null;
    private final CharSequence iconHash = null;
    private final CharSequence unicodeEmoji = null;
    private final transient String analyticsSchemaTypeName = "guild_role_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildRoleUpdated)) {
            return false;
        }
        TrackGuildRoleUpdated trackGuildRoleUpdated = (TrackGuildRoleUpdated) other;
        return m.areEqual(this.action, trackGuildRoleUpdated.action) && m.areEqual(this.guildId, trackGuildRoleUpdated.guildId) && m.areEqual(this.roleId, trackGuildRoleUpdated.roleId) && m.areEqual(this.rolePermissions, trackGuildRoleUpdated.rolePermissions) && m.areEqual(this.roleMentionable, trackGuildRoleUpdated.roleMentionable) && m.areEqual(this.roleHoist, trackGuildRoleUpdated.roleHoist) && m.areEqual(this.iconHash, trackGuildRoleUpdated.iconHash) && m.areEqual(this.unicodeEmoji, trackGuildRoleUpdated.unicodeEmoji);
    }

    public int hashCode() {
        CharSequence charSequence = this.action;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.roleId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.rolePermissions;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.roleMentionable;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.roleHoist;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.iconHash;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.unicodeEmoji;
        return iHashCode7 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildRoleUpdated(action=");
        sbU.append(this.action);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", rolePermissions=");
        sbU.append(this.rolePermissions);
        sbU.append(", roleMentionable=");
        sbU.append(this.roleMentionable);
        sbU.append(", roleHoist=");
        sbU.append(this.roleHoist);
        sbU.append(", iconHash=");
        sbU.append(this.iconHash);
        sbU.append(", unicodeEmoji=");
        return a.E(sbU, this.unicodeEmoji, ")");
    }
}
