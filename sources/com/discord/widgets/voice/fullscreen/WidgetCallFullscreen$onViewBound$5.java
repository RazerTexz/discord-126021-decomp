package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$onViewBound$5<R> implements Func0<Boolean> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$onViewBound$5(WidgetCallFullscreen widgetCallFullscreen, Channel channel) {
        this.this$0 = widgetCallFullscreen;
        this.$channel = channel;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        WidgetCallFullscreen widgetCallFullscreen = this.this$0;
        TextInVoiceFeatureFlag instance = TextInVoiceFeatureFlag.Companion.getINSTANCE();
        Channel channel = this.$channel;
        WidgetCallFullscreen.access$finishActivity(widgetCallFullscreen, false, instance.isEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null));
        return Boolean.TRUE;
    }
}
