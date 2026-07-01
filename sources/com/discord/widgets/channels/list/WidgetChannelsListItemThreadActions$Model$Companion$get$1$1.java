package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$Model$Companion$get$1$1<T, R> implements b<Map<Long, ? extends Channel>, Boolean> {
    public final /* synthetic */ Channel $channel;

    public WidgetChannelsListItemThreadActions$Model$Companion$get$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Map<Long, Channel> map) {
        return Boolean.valueOf(a.d(this.$channel, map) != null);
    }
}
