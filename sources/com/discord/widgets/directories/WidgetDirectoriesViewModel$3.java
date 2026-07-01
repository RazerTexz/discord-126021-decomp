package com.discord.widgets.directories;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import j0.k.b;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$3<T, R> implements b<Channel, Boolean> {
    public static final WidgetDirectoriesViewModel$3 INSTANCE = new WidgetDirectoriesViewModel$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Channel channel) {
        return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
    }
}
