package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1$1<T1, T2, T3, R> implements Func3<NavigationTab, Map<Long, ? extends Channel>, Boolean, WidgetForumBrowserViewModel$MinimalStoreState> {
    public final /* synthetic */ Channel $channel;

    public WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetForumBrowserViewModel$MinimalStoreState call(NavigationTab navigationTab, Map<Long, ? extends Channel> map, Boolean bool) {
        return call2(navigationTab, (Map<Long, Channel>) map, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetForumBrowserViewModel$MinimalStoreState call2(NavigationTab navigationTab, Map<Long, Channel> map, Boolean bool) {
        m.checkNotNullExpressionValue(bool, "canAccess");
        if (!bool.booleanValue() || navigationTab != NavigationTab.HOME || !ChannelUtils.q(this.$channel)) {
            return WidgetForumBrowserViewModel$MinimalStoreState$Invalid.INSTANCE;
        }
        m.checkNotNullExpressionValue(map, "activeThreads");
        return new WidgetForumBrowserViewModel$MinimalStoreState$Valid(this.$channel, map);
    }
}
