package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$Model$Companion$get$1$2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Channel, Guild, Long, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined$JoinedThread, Boolean, WidgetChannelsListItemThreadActions$Model> {
    public final /* synthetic */ Channel $channel;

    public WidgetChannelsListItemThreadActions$Model$Companion$get$1$2(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetChannelsListItemThreadActions$Model call(MeUser meUser, Channel channel, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, Boolean bool) {
        return call2(meUser, channel, guild, l, map, storeThreadsJoined$JoinedThread, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelsListItemThreadActions$Model call2(MeUser meUser, Channel channel, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, Boolean bool) {
        NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
        boolean zIsGuildOrCategoryOrChannelMuted = notificationTextUtils.isGuildOrCategoryOrChannelMuted((ModelNotificationSettings) a.c(this.$channel, map), channel);
        Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel((ModelNotificationSettings) a.c(this.$channel, map), this.$channel, guild);
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        int iComputeThreadNotificationSetting = threadUtils.computeThreadNotificationSetting(storeThreadsJoined$JoinedThread, zIsGuildOrCategoryOrChannelMuted, numChannelMessageNotificationLevel);
        m.checkNotNullExpressionValue(meUser, "meUser");
        boolean zCanManageThread = threadUtils.canManageThread(meUser, this.$channel, Long.valueOf(l != null ? l.longValue() : 0L));
        boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(this.$channel, Long.valueOf(l != null ? l.longValue() : 0L));
        boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
        boolean z2 = storeThreadsJoined$JoinedThread != null && storeThreadsJoined$JoinedThread.getMuted();
        Channel channel2 = this.$channel;
        m.checkNotNullExpressionValue(bool, "isActiveThread");
        return new WidgetChannelsListItemThreadActions$Model(meUser, channel2, guild, channel, iComputeThreadNotificationSetting, storeThreadsJoined$JoinedThread, bool.booleanValue(), zIsThreadModerator, zCanManageThread, zCanUnarchiveThread, z2);
    }
}
