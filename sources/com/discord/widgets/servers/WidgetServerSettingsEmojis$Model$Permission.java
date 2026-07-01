package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEmojis$Model$Permission {
    private final boolean canManage;
    private final Guild guild;

    public WidgetServerSettingsEmojis$Model$Permission(boolean z2, Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        this.canManage = z2;
        this.guild = guild;
    }

    public static /* synthetic */ WidgetServerSettingsEmojis$Model$Permission copy$default(WidgetServerSettingsEmojis$Model$Permission widgetServerSettingsEmojis$Model$Permission, boolean z2, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetServerSettingsEmojis$Model$Permission.canManage;
        }
        if ((i & 2) != 0) {
            guild = widgetServerSettingsEmojis$Model$Permission.guild;
        }
        return widgetServerSettingsEmojis$Model$Permission.copy(z2, guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanManage() {
        return this.canManage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final WidgetServerSettingsEmojis$Model$Permission copy(boolean canManage, Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new WidgetServerSettingsEmojis$Model$Permission(canManage, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEmojis$Model$Permission)) {
            return false;
        }
        WidgetServerSettingsEmojis$Model$Permission widgetServerSettingsEmojis$Model$Permission = (WidgetServerSettingsEmojis$Model$Permission) other;
        return this.canManage == widgetServerSettingsEmojis$Model$Permission.canManage && m.areEqual(this.guild, widgetServerSettingsEmojis$Model$Permission.guild);
    }

    public final boolean getCanManage() {
        return this.canManage;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.canManage;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Guild guild = this.guild;
        return i + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Permission(canManage=");
        sbU.append(this.canManage);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
