package com.discord.widgets.guilds;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildSelector$GuildFilterFunction implements WidgetGuildSelector$FilterFunction {
    private final Set<Long> guildIds;

    public WidgetGuildSelector$GuildFilterFunction(Set<Long> set) {
        m.checkNotNullParameter(set, "guildIds");
        this.guildIds = set;
    }

    private final Set<Long> component1() {
        return this.guildIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildSelector$GuildFilterFunction copy$default(WidgetGuildSelector$GuildFilterFunction widgetGuildSelector$GuildFilterFunction, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = widgetGuildSelector$GuildFilterFunction.guildIds;
        }
        return widgetGuildSelector$GuildFilterFunction.copy(set);
    }

    public final WidgetGuildSelector$GuildFilterFunction copy(Set<Long> guildIds) {
        m.checkNotNullParameter(guildIds, "guildIds");
        return new WidgetGuildSelector$GuildFilterFunction(guildIds);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildSelector$GuildFilterFunction) && m.areEqual(this.guildIds, ((WidgetGuildSelector$GuildFilterFunction) other).guildIds);
        }
        return true;
    }

    public int hashCode() {
        Set<Long> set = this.guildIds;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    @Override // com.discord.widgets.guilds.WidgetGuildSelector$FilterFunction
    public boolean includeGuild(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return this.guildIds.contains(Long.valueOf(guild.getId()));
    }

    public String toString() {
        return a.N(a.U("GuildFilterFunction(guildIds="), this.guildIds, ")");
    }
}
