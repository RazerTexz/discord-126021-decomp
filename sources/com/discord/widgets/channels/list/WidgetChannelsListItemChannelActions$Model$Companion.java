package com.discord.widgets.channels.list;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$Model$Companion {
    private WidgetChannelsListItemChannelActions$Model$Companion() {
    }

    public final Observable<WidgetChannelsListItemChannelActions$Model> get(long channelId) {
        Observable<R> observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new WidgetChannelsListItemChannelActions$Model$Companion$get$1(channelId));
        m.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…        }\n              }");
        Observable<WidgetChannelsListItemChannelActions$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream.getChannels(…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChannelsListItemChannelActions$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
