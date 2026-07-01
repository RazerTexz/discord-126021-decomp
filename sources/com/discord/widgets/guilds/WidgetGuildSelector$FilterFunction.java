package com.discord.widgets.guilds;

import com.discord.models.guild.Guild;
import java.io.Serializable;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetGuildSelector$FilterFunction extends Serializable {
    boolean includeGuild(Guild guild);
}
