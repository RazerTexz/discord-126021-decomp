package com.discord.widgets.chat.input.models;

import com.discord.api.role.GuildRole;
import d0.z.d.m;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleOptionValue(GuildRole guildRole) {
        super(String.valueOf(guildRole.getId()), null);
        m.checkNotNullParameter(guildRole, "role");
    }
}
