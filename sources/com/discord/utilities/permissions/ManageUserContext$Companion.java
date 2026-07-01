package com.discord.utilities.permissions;

import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.guilds.RoleUtils;
import d0.z.d.m;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageUserContext$Companion {
    private ManageUserContext$Companion() {
    }

    public final ManageUserContext from(Guild guild, MeUser actingUser, User targetUser, Collection<Long> actingUserRoles, Collection<Long> userRoles, Long myPermissions, Map<Long, GuildRole> guildRoles) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(actingUser, "actingUser");
        m.checkNotNullParameter(targetUser, "targetUser");
        m.checkNotNullParameter(actingUserRoles, "actingUserRoles");
        m.checkNotNullParameter(userRoles, "userRoles");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        long id2 = targetUser.getId();
        long id3 = actingUser.getId();
        boolean z2 = id3 == id2;
        boolean z3 = id3 == guild.getOwnerId();
        boolean z4 = z3 || (!((id2 > guild.getOwnerId() ? 1 : (id2 == guild.getOwnerId() ? 0 : -1)) == 0) && RoleUtils.rankIsHigher(RoleUtils.getHighestRole(guildRoles, actingUserRoles), RoleUtils.getHighestRole(guildRoles, userRoles)));
        int mfaLevel = guild.getMfaLevel();
        boolean mfaEnabled = actingUser.getMfaEnabled();
        boolean z5 = z3 || PermissionUtils.canAndIsElevated(8L, myPermissions, mfaEnabled, mfaLevel);
        boolean z6 = (z2 || z4) && (z5 || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, myPermissions, mfaEnabled, mfaLevel));
        boolean z7 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(2L, myPermissions, mfaEnabled, mfaLevel));
        boolean z8 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(4L, myPermissions, mfaEnabled, mfaLevel));
        boolean z9 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(Permission.MODERATE_MEMBERS, myPermissions, mfaEnabled, mfaLevel));
        return new ManageUserContext(z6, z7, z8, z5 || PermissionUtils.can(Permission.MUTE_MEMBERS, myPermissions), z5 || PermissionUtils.can(Permission.DEAFEN_MEMBERS, myPermissions), z5 || PermissionUtils.can(Permission.MOVE_MEMBERS, myPermissions), !z2 ? !(z4 && (z5 || PermissionUtils.canAndIsElevated(Permission.MANAGE_NICKNAMES, myPermissions, mfaEnabled, mfaLevel))) : !(z5 || PermissionUtils.can(Permission.CHANGE_NICKNAME, myPermissions)), z9, !z2 && z3);
    }

    public /* synthetic */ ManageUserContext$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
