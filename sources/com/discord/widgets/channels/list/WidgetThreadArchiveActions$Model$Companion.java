package com.discord.widgets.channels.list;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadArchiveActions$Model$Companion {
    private WidgetThreadArchiveActions$Model$Companion() {
    }

    public final Observable<WidgetThreadArchiveActions$Model> get(long channelId, long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getChannels().observeChannel(channelId), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getPermissions().observePermissionsForChannel(channelId), WidgetThreadArchiveActions$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…            }\n          }");
        Observable<WidgetThreadArchiveActions$Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetThreadArchiveActions$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
