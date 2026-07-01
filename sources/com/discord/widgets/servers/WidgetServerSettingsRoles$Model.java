package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsRoles$Model {
    public static final WidgetServerSettingsRoles$Model$Companion Companion = new WidgetServerSettingsRoles$Model$Companion(null);
    private final boolean canManageRoles;
    private final boolean elevated;
    private final long guildId;
    private final String guildName;
    private final List<DragAndDropAdapter$Payload> roleItems;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetServerSettingsRoles$Model(long j, String str, boolean z2, boolean z3, List<? extends DragAndDropAdapter$Payload> list) {
        m.checkNotNullParameter(list, "roleItems");
        this.guildId = j;
        this.guildName = str;
        this.canManageRoles = z2;
        this.elevated = z3;
        this.roleItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsRoles$Model copy$default(WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model, long j, String str, boolean z2, boolean z3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetServerSettingsRoles$Model.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = widgetServerSettingsRoles$Model.guildName;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            z2 = widgetServerSettingsRoles$Model.canManageRoles;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            z3 = widgetServerSettingsRoles$Model.elevated;
        }
        boolean z5 = z3;
        if ((i & 16) != 0) {
            list = widgetServerSettingsRoles$Model.roleItems;
        }
        return widgetServerSettingsRoles$Model.copy(j2, str2, z4, z5, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getElevated() {
        return this.elevated;
    }

    public final List<DragAndDropAdapter$Payload> component5() {
        return this.roleItems;
    }

    public final WidgetServerSettingsRoles$Model copy(long guildId, String guildName, boolean canManageRoles, boolean elevated, List<? extends DragAndDropAdapter$Payload> roleItems) {
        m.checkNotNullParameter(roleItems, "roleItems");
        return new WidgetServerSettingsRoles$Model(guildId, guildName, canManageRoles, elevated, roleItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsRoles$Model)) {
            return false;
        }
        WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model = (WidgetServerSettingsRoles$Model) other;
        return this.guildId == widgetServerSettingsRoles$Model.guildId && m.areEqual(this.guildName, widgetServerSettingsRoles$Model.guildName) && this.canManageRoles == widgetServerSettingsRoles$Model.canManageRoles && this.elevated == widgetServerSettingsRoles$Model.elevated && m.areEqual(this.roleItems, widgetServerSettingsRoles$Model.roleItems);
    }

    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    public final boolean getElevated() {
        return this.elevated;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final List<DragAndDropAdapter$Payload> getRoleItems() {
        return this.roleItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.guildName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.canManageRoles;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.elevated;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        List<DragAndDropAdapter$Payload> list = this.roleItems;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", canManageRoles=");
        sbU.append(this.canManageRoles);
        sbU.append(", elevated=");
        sbU.append(this.elevated);
        sbU.append(", roleItems=");
        return a.L(sbU, this.roleItems, ")");
    }
}
