package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreThreadsActiveJoined$ActiveJoinedThread;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>>, Long, Channel, Boolean, WidgetThreadStatusViewModel$StoreState> {
    public final /* synthetic */ Channel $selectedChannel;

    public WidgetThreadStatusViewModel$Companion$observeStoreState$1$1(Channel channel) {
        this.$selectedChannel = channel;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetThreadStatusViewModel$StoreState call(Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined$ActiveJoinedThread>> map, Long l, Channel channel, Boolean bool) {
        return call2((Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>>) map, l, channel, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadStatusViewModel$StoreState call2(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> map, Long l, Channel channel, Boolean bool) {
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        Channel channel2 = this.$selectedChannel;
        m.checkNotNullExpressionValue(channel2, "selectedChannel");
        boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(channel2, l);
        boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
        m.checkNotNullExpressionValue(map, "activeJoinedThreads");
        Channel channel3 = this.$selectedChannel;
        m.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
        return new WidgetThreadStatusViewModel$StoreState(map, channel3, channel, zCanUnarchiveThread, zIsThreadModerator, bool.booleanValue());
    }
}
