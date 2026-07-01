package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$Model$Companion$get$1$2<T1, T2, T3, T4, R> implements Func4<Guild, GuildMember, Long, Map<Long, ? extends GuildRole>, WidgetServerSettingsRoles$Model> {
    public final /* synthetic */ MeUser $meUser;
    public final /* synthetic */ WidgetServerSettingsRoles$Model$Companion$get$1 this$0;

    public WidgetServerSettingsRoles$Model$Companion$get$1$2(WidgetServerSettingsRoles$Model$Companion$get$1 widgetServerSettingsRoles$Model$Companion$get$1, MeUser meUser) {
        this.this$0 = widgetServerSettingsRoles$Model$Companion$get$1;
        this.$meUser = meUser;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetServerSettingsRoles$Model call(Guild guild, GuildMember guildMember, Long l, Map<Long, ? extends GuildRole> map) {
        return call2(guild, guildMember, l, (Map<Long, GuildRole>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsRoles$Model call2(Guild guild, GuildMember guildMember, Long l, Map<Long, GuildRole> map) {
        if (guild == null || guildMember == null || l == null || map == null) {
            return null;
        }
        boolean zCan = PermissionUtils.can(Permission.MANAGE_ROLES, l);
        boolean zIsElevated = PermissionUtils.isElevated(this.$meUser.getMfaEnabled(), guild.getMfaLevel());
        GuildRole highestRole = RoleUtils.getHighestRole(map, guildMember);
        ArrayList<GuildRole> arrayList = new ArrayList(map.values());
        Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
        ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
        arrayList2.add(new WidgetServerSettingsRolesAdapter$HelpItem(this.this$0.$guildId));
        for (GuildRole guildRole : arrayList) {
            arrayList2.add(new WidgetServerSettingsRolesAdapter$RoleItem(guildRole, this.this$0.$guildId == guildRole.getId(), (guild.getOwnerId() == this.$meUser.getId() || RoleUtils.rankIsHigher(highestRole, guildRole)) ? false : true, zCan, zIsElevated, this.this$0.$guildId));
        }
        return new WidgetServerSettingsRoles$Model(this.this$0.$guildId, guild.getName(), zCan, zIsElevated, arrayList2);
    }
}
