package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.guild.Guild;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$Model$Companion$get$1$1<T1, T2, T3, R> implements Func3<Guild, Long, Map<Long, ? extends ModelNotificationSettings>, WidgetChannelsListItemChannelActions$Model> {
    public final /* synthetic */ Channel $channel;

    public WidgetChannelsListItemChannelActions$Model$Companion$get$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChannelsListItemChannelActions$Model call(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
        return call2(guild, l, map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelsListItemChannelActions$Model call2(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
        ModelNotificationSettings$ChannelOverride channelOverride;
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) a.c(this.$channel, map);
        return new WidgetChannelsListItemChannelActions$Model(this.$channel, guild, l, (modelNotificationSettings == null || (channelOverride = modelNotificationSettings.getChannelOverride(this.$channel.getId())) == null || !channelOverride.isMuted()) ? false : true);
    }
}
