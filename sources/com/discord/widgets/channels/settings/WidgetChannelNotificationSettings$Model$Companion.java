package com.discord.widgets.channels.settings;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$Model$Companion {
    private WidgetChannelNotificationSettings$Model$Companion() {
    }

    public final Observable<WidgetChannelNotificationSettings$Model> get(long channelId) {
        Observable<R> observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(WidgetChannelNotificationSettings$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …ust(null)\n              }");
        Observable<WidgetChannelNotificationSettings$Model> observableR = ObservableExtensionsKt.computationBuffered(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChannelNotificationSettings$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
