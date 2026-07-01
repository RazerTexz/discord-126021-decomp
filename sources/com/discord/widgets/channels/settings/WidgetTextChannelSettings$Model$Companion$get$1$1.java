package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$Model$Companion$get$1$1<T1, T2, T3, R> implements Func3<Guild, MeUser, Long, WidgetTextChannelSettings$Model> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetTextChannelSettings$Model$Companion$get$1 this$0;

    public WidgetTextChannelSettings$Model$Companion$get$1$1(WidgetTextChannelSettings$Model$Companion$get$1 widgetTextChannelSettings$Model$Companion$get$1, Channel channel) {
        this.this$0 = widgetTextChannelSettings$Model$Companion$get$1;
        this.$channel = channel;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetTextChannelSettings$Model call(Guild guild, MeUser meUser, Long l) {
        return call2(guild, meUser, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetTextChannelSettings$Model call2(Guild guild, MeUser meUser, Long l) {
        Long publicUpdatesChannelId;
        Long rulesChannelId;
        if (guild == null) {
            return null;
        }
        boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
        boolean zCanAndIsElevated2 = PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, meUser.getMfaEnabled(), guild.getMfaLevel());
        boolean z2 = !this.$channel.getNsfw() || StoreStream.Companion.getGuildsNsfw().isGuildNsfwGateAgreed(this.$channel.getGuildId());
        boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
        return new WidgetTextChannelSettings$Model(guild, this.$channel, zCanAndIsElevated, zCanAndIsElevated2, z2, zContains && (rulesChannelId = guild.getRulesChannelId()) != null && rulesChannelId.longValue() == this.this$0.$channelId, zContains && (publicUpdatesChannelId = guild.getPublicUpdatesChannelId()) != null && publicUpdatesChannelId.longValue() == this.this$0.$channelId, zContains);
    }
}
