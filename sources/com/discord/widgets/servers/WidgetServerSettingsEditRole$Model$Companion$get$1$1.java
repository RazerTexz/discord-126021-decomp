package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$Model$Companion$get$1$1<T1, T2, T3, T4, T5, T6, R> implements Func6<Guild, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Long, Boolean, Boolean, WidgetServerSettingsEditRole$Model> {
    public final /* synthetic */ MeUser $meUser;
    public final /* synthetic */ WidgetServerSettingsEditRole$Model$Companion$get$1 this$0;

    public WidgetServerSettingsEditRole$Model$Companion$get$1$1(WidgetServerSettingsEditRole$Model$Companion$get$1 widgetServerSettingsEditRole$Model$Companion$get$1, MeUser meUser) {
        this.this$0 = widgetServerSettingsEditRole$Model$Companion$get$1;
        this.$meUser = meUser;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditRole$Model call(Guild guild, Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
        return call2(guild, (Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, l, bool, bool2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditRole$Model call2(Guild guild, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
        GuildMember guildMember = map.get(Long.valueOf(this.$meUser.getId()));
        GuildRole guildRole = map2 != null ? map2.get(Long.valueOf(this.this$0.$roleId)) : null;
        if (guildRole == null || guild == null || guildMember == null) {
            return null;
        }
        GuildRole highestRole = RoleUtils.getHighestRole(map2, guildMember);
        boolean z2 = guild.getOwnerId() == this.$meUser.getId();
        boolean zIsElevated = PermissionUtils.isElevated(this.$meUser.getMfaEnabled(), guild.getMfaLevel());
        WidgetServerSettingsEditRole$Model$Companion widgetServerSettingsEditRole$Model$Companion = WidgetServerSettingsEditRole$Model.Companion;
        WidgetServerSettingsEditRole$Model$ManageStatus widgetServerSettingsEditRole$Model$ManageStatusAccess$computeManageStatus = WidgetServerSettingsEditRole$Model$Companion.access$computeManageStatus(widgetServerSettingsEditRole$Model$Companion, z2, zIsElevated, l, highestRole, guildRole);
        long jAccess$computeMyOtherPermissions = WidgetServerSettingsEditRole$Model$Companion.access$computeMyOtherPermissions(widgetServerSettingsEditRole$Model$Companion, guildMember.getRoles(), map2, this.this$0.$roleId, guild.getId());
        boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
        long id2 = guild.getId();
        m.checkNotNullExpressionValue(bool, "useNewThreadPermissions");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(bool2, "hasDisabledGuildCommunicationFeature");
        return new WidgetServerSettingsEditRole$Model(z2, id2, guildRole, widgetServerSettingsEditRole$Model$ManageStatusAccess$computeManageStatus, l, jAccess$computeMyOtherPermissions, zContains, zBooleanValue, bool2.booleanValue());
    }
}
