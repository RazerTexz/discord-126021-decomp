package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEditRole$Model {
    public static final WidgetServerSettingsEditRole$Model$Companion Companion = new WidgetServerSettingsEditRole$Model$Companion(null);
    private final long guildId;
    private final boolean hasGuildCommunicationDisabledFeature;
    private final boolean isCommunityServer;
    private final WidgetServerSettingsEditRole$Model$ManageStatus manageStatus;
    private final Long myPermissions;
    private final long myPermissionsFromOtherRoles;
    private final boolean owner;
    private final GuildRole role;
    private final boolean useNewThreadPermissions;

    public WidgetServerSettingsEditRole$Model(boolean z2, long j, GuildRole guildRole, WidgetServerSettingsEditRole$Model$ManageStatus widgetServerSettingsEditRole$Model$ManageStatus, Long l, long j2, boolean z3, boolean z4, boolean z5) {
        m.checkNotNullParameter(guildRole, "role");
        this.owner = z2;
        this.guildId = j;
        this.role = guildRole;
        this.manageStatus = widgetServerSettingsEditRole$Model$ManageStatus;
        this.myPermissions = l;
        this.myPermissionsFromOtherRoles = j2;
        this.isCommunityServer = z3;
        this.useNewThreadPermissions = z4;
        this.hasGuildCommunicationDisabledFeature = z5;
    }

    public static /* synthetic */ WidgetServerSettingsEditRole$Model copy$default(WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model, boolean z2, long j, GuildRole guildRole, WidgetServerSettingsEditRole$Model$ManageStatus widgetServerSettingsEditRole$Model$ManageStatus, Long l, long j2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        return widgetServerSettingsEditRole$Model.copy((i & 1) != 0 ? widgetServerSettingsEditRole$Model.owner : z2, (i & 2) != 0 ? widgetServerSettingsEditRole$Model.guildId : j, (i & 4) != 0 ? widgetServerSettingsEditRole$Model.role : guildRole, (i & 8) != 0 ? widgetServerSettingsEditRole$Model.manageStatus : widgetServerSettingsEditRole$Model$ManageStatus, (i & 16) != 0 ? widgetServerSettingsEditRole$Model.myPermissions : l, (i & 32) != 0 ? widgetServerSettingsEditRole$Model.myPermissionsFromOtherRoles : j2, (i & 64) != 0 ? widgetServerSettingsEditRole$Model.isCommunityServer : z3, (i & 128) != 0 ? widgetServerSettingsEditRole$Model.useNewThreadPermissions : z4, (i & 256) != 0 ? widgetServerSettingsEditRole$Model.hasGuildCommunicationDisabledFeature : z5);
    }

    public final boolean canManage() {
        WidgetServerSettingsEditRole$Model$ManageStatus widgetServerSettingsEditRole$Model$ManageStatus = this.manageStatus;
        return widgetServerSettingsEditRole$Model$ManageStatus == WidgetServerSettingsEditRole$Model$ManageStatus.CAN_MANAGE_CONDITIONAL || widgetServerSettingsEditRole$Model$ManageStatus == WidgetServerSettingsEditRole$Model$ManageStatus.CAN_MANAGE_ADMIN;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final WidgetServerSettingsEditRole$Model$ManageStatus getManageStatus() {
        return this.manageStatus;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getMyPermissions() {
        return this.myPermissions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getMyPermissionsFromOtherRoles() {
        return this.myPermissionsFromOtherRoles;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsCommunityServer() {
        return this.isCommunityServer;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getUseNewThreadPermissions() {
        return this.useNewThreadPermissions;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getHasGuildCommunicationDisabledFeature() {
        return this.hasGuildCommunicationDisabledFeature;
    }

    public final WidgetServerSettingsEditRole$Model copy(boolean owner, long guildId, GuildRole role, WidgetServerSettingsEditRole$Model$ManageStatus manageStatus, Long myPermissions, long myPermissionsFromOtherRoles, boolean isCommunityServer, boolean useNewThreadPermissions, boolean hasGuildCommunicationDisabledFeature) {
        m.checkNotNullParameter(role, "role");
        return new WidgetServerSettingsEditRole$Model(owner, guildId, role, manageStatus, myPermissions, myPermissionsFromOtherRoles, isCommunityServer, useNewThreadPermissions, hasGuildCommunicationDisabledFeature);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEditRole$Model)) {
            return false;
        }
        WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model = (WidgetServerSettingsEditRole$Model) other;
        return this.owner == widgetServerSettingsEditRole$Model.owner && this.guildId == widgetServerSettingsEditRole$Model.guildId && m.areEqual(this.role, widgetServerSettingsEditRole$Model.role) && m.areEqual(this.manageStatus, widgetServerSettingsEditRole$Model.manageStatus) && m.areEqual(this.myPermissions, widgetServerSettingsEditRole$Model.myPermissions) && this.myPermissionsFromOtherRoles == widgetServerSettingsEditRole$Model.myPermissionsFromOtherRoles && this.isCommunityServer == widgetServerSettingsEditRole$Model.isCommunityServer && this.useNewThreadPermissions == widgetServerSettingsEditRole$Model.useNewThreadPermissions && this.hasGuildCommunicationDisabledFeature == widgetServerSettingsEditRole$Model.hasGuildCommunicationDisabledFeature;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getHasGuildCommunicationDisabledFeature() {
        return this.hasGuildCommunicationDisabledFeature;
    }

    public final WidgetServerSettingsEditRole$Model$ManageStatus getManageStatus() {
        return this.manageStatus;
    }

    public final Long getMyPermissions() {
        return this.myPermissions;
    }

    public final long getMyPermissionsFromOtherRoles() {
        return this.myPermissionsFromOtherRoles;
    }

    public final boolean getOwner() {
        return this.owner;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    public final boolean getUseNewThreadPermissions() {
        return this.useNewThreadPermissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    public int hashCode() {
        boolean z2 = this.owner;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iA = (b.a(this.guildId) + (r0 * 31)) * 31;
        GuildRole guildRole = this.role;
        int iHashCode = (iA + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        WidgetServerSettingsEditRole$Model$ManageStatus widgetServerSettingsEditRole$Model$ManageStatus = this.manageStatus;
        int iHashCode2 = (iHashCode + (widgetServerSettingsEditRole$Model$ManageStatus != null ? widgetServerSettingsEditRole$Model$ManageStatus.hashCode() : 0)) * 31;
        Long l = this.myPermissions;
        int iA2 = (b.a(this.myPermissionsFromOtherRoles) + ((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        boolean z3 = this.isCommunityServer;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i = (iA2 + r2) * 31;
        boolean z4 = this.useNewThreadPermissions;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z5 = this.hasGuildCommunicationDisabledFeature;
        return i2 + (z5 ? 1 : z5);
    }

    public final boolean isCommunityServer() {
        return this.isCommunityServer;
    }

    public final boolean isEveryoneRole() {
        return this.role.getId() == this.guildId;
    }

    public final boolean isSingular(long permission) {
        return (this.owner || (this.myPermissionsFromOtherRoles & permission) == permission) ? false : true;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(owner=");
        sbU.append(this.owner);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", role=");
        sbU.append(this.role);
        sbU.append(", manageStatus=");
        sbU.append(this.manageStatus);
        sbU.append(", myPermissions=");
        sbU.append(this.myPermissions);
        sbU.append(", myPermissionsFromOtherRoles=");
        sbU.append(this.myPermissionsFromOtherRoles);
        sbU.append(", isCommunityServer=");
        sbU.append(this.isCommunityServer);
        sbU.append(", useNewThreadPermissions=");
        sbU.append(this.useNewThreadPermissions);
        sbU.append(", hasGuildCommunicationDisabledFeature=");
        return a.O(sbU, this.hasGuildCommunicationDisabledFeature, ")");
    }
}
