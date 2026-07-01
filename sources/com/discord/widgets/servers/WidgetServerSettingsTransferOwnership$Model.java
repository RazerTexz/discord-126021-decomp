package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsTransferOwnership$Model {
    public static final WidgetServerSettingsTransferOwnership$Model$Companion Companion = new WidgetServerSettingsTransferOwnership$Model$Companion(null);
    private final Guild guild;
    private final boolean isGuildOwner;
    private final boolean isMfaEnabled;
    private final User user;

    public WidgetServerSettingsTransferOwnership$Model(User user, Guild guild, boolean z2, boolean z3) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(guild, "guild");
        this.user = user;
        this.guild = guild;
        this.isMfaEnabled = z2;
        this.isGuildOwner = z3;
    }

    public static /* synthetic */ WidgetServerSettingsTransferOwnership$Model copy$default(WidgetServerSettingsTransferOwnership$Model widgetServerSettingsTransferOwnership$Model, User user, Guild guild, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetServerSettingsTransferOwnership$Model.user;
        }
        if ((i & 2) != 0) {
            guild = widgetServerSettingsTransferOwnership$Model.guild;
        }
        if ((i & 4) != 0) {
            z2 = widgetServerSettingsTransferOwnership$Model.isMfaEnabled;
        }
        if ((i & 8) != 0) {
            z3 = widgetServerSettingsTransferOwnership$Model.isGuildOwner;
        }
        return widgetServerSettingsTransferOwnership$Model.copy(user, guild, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsMfaEnabled() {
        return this.isMfaEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsGuildOwner() {
        return this.isGuildOwner;
    }

    public final WidgetServerSettingsTransferOwnership$Model copy(User user, Guild guild, boolean isMfaEnabled, boolean isGuildOwner) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(guild, "guild");
        return new WidgetServerSettingsTransferOwnership$Model(user, guild, isMfaEnabled, isGuildOwner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsTransferOwnership$Model)) {
            return false;
        }
        WidgetServerSettingsTransferOwnership$Model widgetServerSettingsTransferOwnership$Model = (WidgetServerSettingsTransferOwnership$Model) other;
        return m.areEqual(this.user, widgetServerSettingsTransferOwnership$Model.user) && m.areEqual(this.guild, widgetServerSettingsTransferOwnership$Model.guild) && this.isMfaEnabled == widgetServerSettingsTransferOwnership$Model.isMfaEnabled && this.isGuildOwner == widgetServerSettingsTransferOwnership$Model.isGuildOwner;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final User getUser() {
        return this.user;
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
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isMfaEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.isGuildOwner;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isGuildOwner() {
        return this.isGuildOwner;
    }

    public final boolean isMfaEnabled() {
        return this.isMfaEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(user=");
        sbU.append(this.user);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isMfaEnabled=");
        sbU.append(this.isMfaEnabled);
        sbU.append(", isGuildOwner=");
        return a.O(sbU, this.isGuildOwner, ")");
    }
}
