package com.discord.widgets.servers;

import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$Model$Companion {
    private WidgetServerSettingsEditRole$Model$Companion() {
    }

    public static final /* synthetic */ WidgetServerSettingsEditRole$Model$ManageStatus access$computeManageStatus(WidgetServerSettingsEditRole$Model$Companion widgetServerSettingsEditRole$Model$Companion, boolean z2, boolean z3, Long l, GuildRole guildRole, GuildRole guildRole2) {
        return widgetServerSettingsEditRole$Model$Companion.computeManageStatus(z2, z3, l, guildRole, guildRole2);
    }

    public static final /* synthetic */ long access$computeMyOtherPermissions(WidgetServerSettingsEditRole$Model$Companion widgetServerSettingsEditRole$Model$Companion, Collection collection, Map map, long j, long j2) {
        return widgetServerSettingsEditRole$Model$Companion.computeMyOtherPermissions(collection, map, j, j2);
    }

    private final WidgetServerSettingsEditRole$Model$ManageStatus computeManageStatus(boolean isOwner, boolean isElevated, Long myPermissions, GuildRole myHighestRole, GuildRole role) {
        boolean zCan = PermissionUtils.can(8L, myPermissions);
        boolean zRankIsHigher = RoleUtils.rankIsHigher(myHighestRole, role);
        if (isOwner || (zCan && zRankIsHigher && isElevated)) {
            return WidgetServerSettingsEditRole$Model$ManageStatus.CAN_MANAGE_ADMIN;
        }
        if (RoleUtils.rankIsHigher(role, myHighestRole)) {
            return WidgetServerSettingsEditRole$Model$ManageStatus.LOCKED_HIGHER;
        }
        if (RoleUtils.rankEquals(myHighestRole, role)) {
            return WidgetServerSettingsEditRole$Model$ManageStatus.LOCKED_HIGHEST;
        }
        if (PermissionUtils.can(Permission.MANAGE_ROLES, myPermissions) && isElevated) {
            return WidgetServerSettingsEditRole$Model$ManageStatus.CAN_MANAGE_CONDITIONAL;
        }
        return !isElevated ? WidgetServerSettingsEditRole$Model$ManageStatus.USER_NOT_ELEVATED : WidgetServerSettingsEditRole$Model$ManageStatus.NO_MANAGE_ROLES_PERMISSION;
    }

    private final long computeMyOtherPermissions(Collection<Long> myRoleIds, Map<Long, GuildRole> guildRoles, long ignoreRoleId, long guildId) {
        GuildRole guildRole = guildRoles.get(Long.valueOf(guildId));
        long permissions = 0;
        if (guildRole != null && ignoreRoleId != guildId) {
            permissions = guildRole.getPermissions() | 0 | guildRole.getPermissions();
        }
        Iterator<T> it = myRoleIds.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            GuildRole guildRole2 = guildRoles.get(Long.valueOf(jLongValue));
            if (guildRole2 != null && jLongValue != ignoreRoleId) {
                permissions = guildRole2.getPermissions() | permissions;
            }
        }
        return permissions;
    }

    public final Observable<WidgetServerSettingsEditRole$Model> get(long guildId, long roleId) {
        Observable<WidgetServerSettingsEditRole$Model> observableR = StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null).Y(new WidgetServerSettingsEditRole$Model$Companion$get$1(guildId, roleId)).r();
        m.checkNotNullExpressionValue(observableR, "getUsers()\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsEditRole$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
