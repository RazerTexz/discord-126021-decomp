package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.n;
import d0.t.r;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Channel, MeUser, Guild, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Boolean, WidgetChannelSettingsEditPermissionsModel> {
    public final /* synthetic */ long $targetRoleId;

    public WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1(long j) {
        this.$targetRoleId = j;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetChannelSettingsEditPermissionsModel call(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Boolean bool) {
        return call2(channel, meUser, guild, l, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsEditPermissionsModel call2(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Boolean bool) {
        GuildMember guildMember;
        List<Long> roles;
        GuildRole guildRole = map.get(Long.valueOf(this.$targetRoleId));
        if (channel != null && guild != null && guildRole != null && l != null) {
            WidgetChannelSettingsEditPermissionsModel$Companion widgetChannelSettingsEditPermissionsModel$Companion = WidgetChannelSettingsEditPermissionsModel.Companion;
            m.checkNotNullExpressionValue(meUser, "meUser");
            if (WidgetChannelSettingsEditPermissionsModel$Companion.access$isAbleToManagePerms(widgetChannelSettingsEditPermissionsModel$Companion, guild, meUser, l.longValue())) {
                ArrayList arrayList = new ArrayList(channel.v() != null ? channel.v() : n.emptyList());
                long j = this.$targetRoleId;
                PermissionOverwrite$Type permissionOverwrite$Type = PermissionOverwrite$Type.ROLE;
                PermissionOverwrite permissionOverwrite = new PermissionOverwrite(j, permissionOverwrite$Type, 0L, Permission.ALL);
                r.removeAll((List) arrayList, (Function1) new WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$1(this));
                arrayList.add(permissionOverwrite);
                PermissionOverwrite permissionOverwrite2 = new PermissionOverwrite(this.$targetRoleId, permissionOverwrite$Type, 0L, 0L);
                r.removeAll((List) arrayList, (Function1) new WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$2(this));
                arrayList.add(permissionOverwrite2);
                boolean z2 = false;
                boolean z3 = this.$targetRoleId == guild.getId();
                long jLongValue = l.longValue();
                long j2 = this.$targetRoleId;
                long jComputeNonThreadPermissions = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                long jComputeNonThreadPermissions2 = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                if (z3 || ((guildMember = map2.get(Long.valueOf(meUser.getId()))) != null && (roles = guildMember.getRoles()) != null && roles.contains(Long.valueOf(this.$targetRoleId)))) {
                    z2 = true;
                }
                m.checkNotNullExpressionValue(bool, "useNewThreadsPermissions");
                return new WidgetChannelSettingsEditPermissionsModel$ModelForRole(channel, jLongValue, guildRole, j2, jComputeNonThreadPermissions, jComputeNonThreadPermissions2, z2, z3, bool.booleanValue());
            }
        }
        return null;
    }
}
