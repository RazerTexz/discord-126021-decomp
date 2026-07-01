package com.discord.widgets.search;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$Model$Companion {
    private WidgetSearch$Model$Companion() {
    }

    public final Observable<WidgetSearch$Model> get(int targetType, long targetId) {
        Observable<Guild> observableObserveGuild = targetType == 0 ? StoreStream.Companion.getGuilds().observeGuild(targetId) : new k<>(null);
        Observable<Channel> observableObservePrivateChannel = targetType == 1 ? StoreStream.Companion.getChannels().observePrivateChannel(targetId) : new k<>(null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableH = Observable.h(observableObserveGuild, observableObservePrivateChannel, storeStream$Companion.getSearch().getDisplayState(), storeStream$Companion.getSearch().getStoreSearchInput().isInputValid(), WidgetSearch$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable\n            .…          }\n            }");
        return ObservableExtensionsKt.computationLatest(observableH);
    }

    public /* synthetic */ WidgetSearch$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
