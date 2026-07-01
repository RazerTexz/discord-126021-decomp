package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsRolesAdapter$RoleItem implements DragAndDropAdapter$Payload {
    private final boolean elevated;
    private final boolean everyoneRole;
    private final long guildId;
    private final String key;
    private final boolean locked;
    private final GuildRole role;
    private final int type;
    private final boolean userAbleToManageRoles;

    public WidgetServerSettingsRolesAdapter$RoleItem(GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j) {
        m.checkNotNullParameter(guildRole, "role");
        this.role = guildRole;
        this.everyoneRole = z2;
        this.locked = z3;
        this.userAbleToManageRoles = z4;
        this.elevated = z5;
        this.guildId = j;
        this.key = String.valueOf(guildRole.getId());
        this.type = 1;
    }

    public static /* synthetic */ WidgetServerSettingsRolesAdapter$RoleItem copy$default(WidgetServerSettingsRolesAdapter$RoleItem widgetServerSettingsRolesAdapter$RoleItem, GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = widgetServerSettingsRolesAdapter$RoleItem.role;
        }
        if ((i & 2) != 0) {
            z2 = widgetServerSettingsRolesAdapter$RoleItem.everyoneRole;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = widgetServerSettingsRolesAdapter$RoleItem.locked;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = widgetServerSettingsRolesAdapter$RoleItem.userAbleToManageRoles;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            z5 = widgetServerSettingsRolesAdapter$RoleItem.elevated;
        }
        boolean z9 = z5;
        if ((i & 32) != 0) {
            j = widgetServerSettingsRolesAdapter$RoleItem.guildId;
        }
        return widgetServerSettingsRolesAdapter$RoleItem.copy(guildRole, z6, z7, z8, z9, j);
    }

    public final boolean canReorder() {
        return !this.everyoneRole && !this.locked && this.userAbleToManageRoles && this.elevated;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEveryoneRole() {
        return this.everyoneRole;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getUserAbleToManageRoles() {
        return this.userAbleToManageRoles;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getElevated() {
        return this.elevated;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetServerSettingsRolesAdapter$RoleItem copy(GuildRole role, boolean everyoneRole, boolean locked, boolean userAbleToManageRoles, boolean elevated, long guildId) {
        m.checkNotNullParameter(role, "role");
        return new WidgetServerSettingsRolesAdapter$RoleItem(role, everyoneRole, locked, userAbleToManageRoles, elevated, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsRolesAdapter$RoleItem)) {
            return false;
        }
        WidgetServerSettingsRolesAdapter$RoleItem widgetServerSettingsRolesAdapter$RoleItem = (WidgetServerSettingsRolesAdapter$RoleItem) other;
        return m.areEqual(this.role, widgetServerSettingsRolesAdapter$RoleItem.role) && this.everyoneRole == widgetServerSettingsRolesAdapter$RoleItem.everyoneRole && this.locked == widgetServerSettingsRolesAdapter$RoleItem.locked && this.userAbleToManageRoles == widgetServerSettingsRolesAdapter$RoleItem.userAbleToManageRoles && this.elevated == widgetServerSettingsRolesAdapter$RoleItem.elevated && this.guildId == widgetServerSettingsRolesAdapter$RoleItem.guildId;
    }

    public final boolean getElevated() {
        return this.elevated;
    }

    public final boolean getEveryoneRole() {
        return this.everyoneRole;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload
    public int getPosition() {
        return this.role.getPosition();
    }

    public final GuildRole getRole() {
        return this.role;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final boolean getUserAbleToManageRoles() {
        return this.userAbleToManageRoles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        GuildRole guildRole = this.role;
        int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
        boolean z2 = this.everyoneRole;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.locked;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.userAbleToManageRoles;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.elevated;
        return b.a(this.guildId) + ((i3 + (z5 ? 1 : z5)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("RoleItem(role=");
        sbU.append(this.role);
        sbU.append(", everyoneRole=");
        sbU.append(this.everyoneRole);
        sbU.append(", locked=");
        sbU.append(this.locked);
        sbU.append(", userAbleToManageRoles=");
        sbU.append(this.userAbleToManageRoles);
        sbU.append(", elevated=");
        sbU.append(this.elevated);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }

    public /* synthetic */ WidgetServerSettingsRolesAdapter$RoleItem(GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildRole, z2, (i & 4) != 0 ? false : z3, z4, z5, j);
    }
}
