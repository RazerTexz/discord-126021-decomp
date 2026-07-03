package com.discord.widgets.chat.input.models;

import com.discord.api.role.GuildRole;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleOptionValue(GuildRole guildRole) {
        super(String.valueOf(guildRole.getId()), null);
        C12238m.checkNotNullParameter(guildRole, "role");
    }
}
