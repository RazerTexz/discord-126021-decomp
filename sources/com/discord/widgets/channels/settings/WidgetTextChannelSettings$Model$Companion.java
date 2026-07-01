package com.discord.widgets.channels.settings;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$Model$Companion {
    private WidgetTextChannelSettings$Model$Companion() {
    }

    public final Observable<WidgetTextChannelSettings$Model> get(long channelId) {
        Observable<R> observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new WidgetTextChannelSettings$Model$Companion$get$1(channelId));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
        Observable<WidgetTextChannelSettings$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetTextChannelSettings$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
