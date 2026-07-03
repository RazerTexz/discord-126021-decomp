package com.discord.utilities.guilds;

import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RoleIconUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleIconUtils {
    public static final RoleIconUtils INSTANCE = new RoleIconUtils();

    private RoleIconUtils() {
    }

    public final boolean canUseRoleIcons(Guild guild, GuildRole guildRole) {
        C12238m.checkNotNullParameter(guild, "$this$canUseRoleIcons");
        if (guild.hasFeature(GuildFeature.ROLE_ICONS)) {
            return true;
        }
        return guildRole != null && RoleUtils.hasSubscriptionListingId(guildRole);
    }
}
