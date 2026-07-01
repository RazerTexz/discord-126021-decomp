package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEditMemberRolesAdapter$RoleItem implements MGRecyclerDataPayload {
    public static final WidgetServerSettingsEditMemberRolesAdapter$RoleItem$Companion Companion = new WidgetServerSettingsEditMemberRolesAdapter$RoleItem$Companion(null);
    public static final int TYPE_ROLE = 1;
    private final boolean isManageable;
    private final boolean isUserHasRole;
    private final String key;
    private final GuildRole role;
    private final int type;

    public WidgetServerSettingsEditMemberRolesAdapter$RoleItem(GuildRole guildRole, boolean z2, boolean z3) {
        m.checkNotNullParameter(guildRole, "role");
        this.role = guildRole;
        this.isUserHasRole = z2;
        this.isManageable = z3;
        this.type = 1;
        this.key = String.valueOf(guildRole.getId());
    }

    public static /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter$RoleItem copy$default(WidgetServerSettingsEditMemberRolesAdapter$RoleItem widgetServerSettingsEditMemberRolesAdapter$RoleItem, GuildRole guildRole, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = widgetServerSettingsEditMemberRolesAdapter$RoleItem.role;
        }
        if ((i & 2) != 0) {
            z2 = widgetServerSettingsEditMemberRolesAdapter$RoleItem.isUserHasRole;
        }
        if ((i & 4) != 0) {
            z3 = widgetServerSettingsEditMemberRolesAdapter$RoleItem.isManageable;
        }
        return widgetServerSettingsEditMemberRolesAdapter$RoleItem.copy(guildRole, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsUserHasRole() {
        return this.isUserHasRole;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsManageable() {
        return this.isManageable;
    }

    public final WidgetServerSettingsEditMemberRolesAdapter$RoleItem copy(GuildRole role, boolean isUserHasRole, boolean isManageable) {
        m.checkNotNullParameter(role, "role");
        return new WidgetServerSettingsEditMemberRolesAdapter$RoleItem(role, isUserHasRole, isManageable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEditMemberRolesAdapter$RoleItem)) {
            return false;
        }
        WidgetServerSettingsEditMemberRolesAdapter$RoleItem widgetServerSettingsEditMemberRolesAdapter$RoleItem = (WidgetServerSettingsEditMemberRolesAdapter$RoleItem) other;
        return m.areEqual(this.role, widgetServerSettingsEditMemberRolesAdapter$RoleItem.role) && this.isUserHasRole == widgetServerSettingsEditMemberRolesAdapter$RoleItem.isUserHasRole && this.isManageable == widgetServerSettingsEditMemberRolesAdapter$RoleItem.isManageable;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        GuildRole guildRole = this.role;
        int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
        boolean z2 = this.isUserHasRole;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isManageable;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isManageable() {
        return this.isManageable;
    }

    public final boolean isRoleManaged() {
        return this.role.getManaged();
    }

    public final boolean isUserHasRole() {
        return this.isUserHasRole;
    }

    public String toString() {
        StringBuilder sbU = a.U("RoleItem(role=");
        sbU.append(this.role);
        sbU.append(", isUserHasRole=");
        sbU.append(this.isUserHasRole);
        sbU.append(", isManageable=");
        return a.O(sbU, this.isManageable, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditMemberRolesAdapter$RoleItem(GuildRole guildRole, boolean z2, GuildRole guildRole2, boolean z3, boolean z4) {
        this(guildRole, z2, !guildRole.getManaged() && (z3 || RoleUtils.rankIsHigher(guildRole2, guildRole)) && z4);
        m.checkNotNullParameter(guildRole, "role");
    }
}
