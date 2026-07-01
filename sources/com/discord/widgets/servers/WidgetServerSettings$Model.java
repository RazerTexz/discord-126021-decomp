package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.utilities.permissions.ManageGuildContext;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettings$Model {
    public static final WidgetServerSettings$Model$Companion Companion = new WidgetServerSettings$Model$Companion(null);
    private final boolean canManageGuildRoleSubscriptions;
    private final Guild guild;
    private final boolean hasGuildRoleSubscriptions;
    private final ManageGuildContext manageGuildContext;

    public WidgetServerSettings$Model(Guild guild, ManageGuildContext manageGuildContext, boolean z2, boolean z3) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
        this.guild = guild;
        this.manageGuildContext = manageGuildContext;
        this.canManageGuildRoleSubscriptions = z2;
        this.hasGuildRoleSubscriptions = z3;
    }

    public static /* synthetic */ WidgetServerSettings$Model copy$default(WidgetServerSettings$Model widgetServerSettings$Model, Guild guild, ManageGuildContext manageGuildContext, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettings$Model.guild;
        }
        if ((i & 2) != 0) {
            manageGuildContext = widgetServerSettings$Model.manageGuildContext;
        }
        if ((i & 4) != 0) {
            z2 = widgetServerSettings$Model.canManageGuildRoleSubscriptions;
        }
        if ((i & 8) != 0) {
            z3 = widgetServerSettings$Model.hasGuildRoleSubscriptions;
        }
        return widgetServerSettings$Model.copy(guild, manageGuildContext, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ManageGuildContext getManageGuildContext() {
        return this.manageGuildContext;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanManageGuildRoleSubscriptions() {
        return this.canManageGuildRoleSubscriptions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasGuildRoleSubscriptions() {
        return this.hasGuildRoleSubscriptions;
    }

    public final WidgetServerSettings$Model copy(Guild guild, ManageGuildContext manageGuildContext, boolean canManageGuildRoleSubscriptions, boolean hasGuildRoleSubscriptions) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
        return new WidgetServerSettings$Model(guild, manageGuildContext, canManageGuildRoleSubscriptions, hasGuildRoleSubscriptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettings$Model)) {
            return false;
        }
        WidgetServerSettings$Model widgetServerSettings$Model = (WidgetServerSettings$Model) other;
        return m.areEqual(this.guild, widgetServerSettings$Model.guild) && m.areEqual(this.manageGuildContext, widgetServerSettings$Model.manageGuildContext) && this.canManageGuildRoleSubscriptions == widgetServerSettings$Model.canManageGuildRoleSubscriptions && this.hasGuildRoleSubscriptions == widgetServerSettings$Model.hasGuildRoleSubscriptions;
    }

    public final boolean getCanManageGuildRoleSubscriptions() {
        return this.canManageGuildRoleSubscriptions;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean getHasGuildRoleSubscriptions() {
        return this.hasGuildRoleSubscriptions;
    }

    public final ManageGuildContext getManageGuildContext() {
        return this.manageGuildContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        ManageGuildContext manageGuildContext = this.manageGuildContext;
        int iHashCode2 = (iHashCode + (manageGuildContext != null ? manageGuildContext.hashCode() : 0)) * 31;
        boolean z2 = this.canManageGuildRoleSubscriptions;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.hasGuildRoleSubscriptions;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", manageGuildContext=");
        sbU.append(this.manageGuildContext);
        sbU.append(", canManageGuildRoleSubscriptions=");
        sbU.append(this.canManageGuildRoleSubscriptions);
        sbU.append(", hasGuildRoleSubscriptions=");
        return a.O(sbU, this.hasGuildRoleSubscriptions, ")");
    }
}
