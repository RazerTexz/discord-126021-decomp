package com.discord.widgets.home;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeModel$Companion {
    private WidgetHomeModel$Companion() {
    }

    public final Observable<WidgetHomeModel> get() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableY = Observable.j(storeStream$Companion.getGuildSelected().observeSelectedGuildId(), storeStream$Companion.getChannelsSelected().observeResolvedSelectedChannel(), WidgetHomeModel$Companion$get$1.INSTANCE).Y(WidgetHomeModel$Companion$get$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            )\n          }");
        Observable<WidgetHomeModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> getInitialized() {
        Observable<Boolean> observableQ = StoreStream.Companion.isInitializedObservable().q(150L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableQ, "StoreStream\n          .i…0, TimeUnit.MILLISECONDS)");
        return observableQ;
    }

    public final Observable<Channel> getParentChannelObservable(Channel channel) {
        if (channel == null || ChannelUtils.H(channel)) {
            if ((channel != null ? Long.valueOf(channel.getParentId()) : null) != null) {
                return StoreStream.Companion.getChannels().observeChannel(channel.getParentId());
            }
        }
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
        return kVar;
    }

    public /* synthetic */ WidgetHomeModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
