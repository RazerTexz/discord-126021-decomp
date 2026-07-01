package com.discord.widgets.guilds;

import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$BaseFilterFunction implements WidgetGuildSelector$FilterFunction {
    @Override // com.discord.widgets.guilds.WidgetGuildSelector$FilterFunction
    public boolean includeGuild(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return WidgetGuildSelector$FilterFunction$DefaultImpls.includeGuild(this, guild);
    }
}
