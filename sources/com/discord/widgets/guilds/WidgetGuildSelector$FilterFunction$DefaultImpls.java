package com.discord.widgets.guilds;

import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$FilterFunction$DefaultImpls {
    public static boolean includeGuild(WidgetGuildSelector$FilterFunction widgetGuildSelector$FilterFunction, Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return true;
    }
}
