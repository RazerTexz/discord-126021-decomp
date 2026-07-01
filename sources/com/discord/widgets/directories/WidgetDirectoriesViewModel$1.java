package com.discord.widgets.directories;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import j0.k.b;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$1<T, R> implements b<WidgetDirectoriesViewModel$ViewState, Boolean> {
    public static final WidgetDirectoriesViewModel$1 INSTANCE = new WidgetDirectoriesViewModel$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        return call2(widgetDirectoriesViewModel$ViewState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        Channel channel = widgetDirectoriesViewModel$ViewState.getChannel();
        return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
    }
}
