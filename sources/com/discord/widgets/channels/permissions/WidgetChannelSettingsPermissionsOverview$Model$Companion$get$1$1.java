package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1$1<T1, T2, T3, T4, R> implements Func4<Guild, MeUser, Long, Map<Long, ? extends GuildRole>, WidgetChannelSettingsPermissionsOverview$Model> {
    public final /* synthetic */ Channel $channel;

    public WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverview$Model call(Guild guild, MeUser meUser, Long l, Map<Long, ? extends GuildRole> map) {
        return call2(guild, meUser, l, (Map<Long, GuildRole>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsPermissionsOverview$Model call2(Guild guild, MeUser meUser, Long l, Map<Long, GuildRole> map) {
        if (!WidgetChannelSettingsPermissionsOverview$Model.Companion.isValid(meUser, guild, this.$channel, l)) {
            return null;
        }
        m.checkNotNullExpressionValue(meUser, "meUser");
        m.checkNotNull(guild);
        Channel channel = this.$channel;
        m.checkNotNull(l);
        long jLongValue = l.longValue();
        m.checkNotNullExpressionValue(map, "roles");
        return new WidgetChannelSettingsPermissionsOverview$Model(meUser, guild, channel, jLongValue, map);
    }
}
