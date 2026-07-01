package com.discord.widgets.channels.list;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$Model$Companion {
    private WidgetChannelsListItemThreadActions$Model$Companion() {
    }

    public final Observable<WidgetChannelsListItemThreadActions$Model> get(long channelId) {
        Observable<R> observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(WidgetChannelsListItemThreadActions$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
        Observable<WidgetChannelsListItemThreadActions$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChannelsListItemThreadActions$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
