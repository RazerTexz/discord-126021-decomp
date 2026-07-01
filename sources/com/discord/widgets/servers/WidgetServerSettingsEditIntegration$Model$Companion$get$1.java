package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.Map;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$Model$Companion$get$1<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Guild, Map<Long, ? extends GuildRole>, Long, ModelGuildIntegration, WidgetServerSettingsEditIntegration$Model> {
    public static final WidgetServerSettingsEditIntegration$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsEditIntegration$Model$Companion$get$1();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditIntegration$Model call(MeUser meUser, Guild guild, Map<Long, ? extends GuildRole> map, Long l, ModelGuildIntegration modelGuildIntegration) {
        return call2(meUser, guild, (Map<Long, GuildRole>) map, l, modelGuildIntegration);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditIntegration$Model call2(MeUser meUser, Guild guild, Map<Long, GuildRole> map, Long l, ModelGuildIntegration modelGuildIntegration) {
        if (guild == null || map == null || l == null || modelGuildIntegration == null) {
            return null;
        }
        GuildRole guildRole = map.get(Long.valueOf(modelGuildIntegration.getRoleId()));
        if (modelGuildIntegration.isEnabled() && PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel())) {
            return new WidgetServerSettingsEditIntegration$Model(guild, modelGuildIntegration, guildRole);
        }
        return null;
    }
}
