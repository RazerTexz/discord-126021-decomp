package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.voice.model.CallModel;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$observeStoreState$1<T, R> implements b<Channel, Observable<? extends WidgetCallFullscreenViewModel$StoreState>> {
    public final /* synthetic */ WidgetCallFullscreenViewModel this$0;

    public WidgetCallFullscreenViewModel$observeStoreState$1(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        this.this$0 = widgetCallFullscreenViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetCallFullscreenViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetCallFullscreenViewModel$StoreState> call2(Channel channel) {
        return CallModel.Companion.get(WidgetCallFullscreenViewModel.access$getChannelId$p(this.this$0)).Y(new WidgetCallFullscreenViewModel$observeStoreState$1$1(this, channel));
    }
}
