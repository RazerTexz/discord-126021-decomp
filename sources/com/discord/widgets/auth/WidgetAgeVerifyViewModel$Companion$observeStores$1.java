package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel$Companion$observeStores$1<T, R> implements b<Channel, Observable<? extends Channel>> {
    public static final WidgetAgeVerifyViewModel$Companion$observeStores$1 INSTANCE = new WidgetAgeVerifyViewModel$Companion$observeStores$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Channel channel) {
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        return lValueOf == null ? new k(null) : ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.Companion.getChannels().observeDefaultChannel(lValueOf.longValue()), 0L, false, 3, null).G(WidgetAgeVerifyViewModel$Companion$observeStores$1$1.INSTANCE);
    }
}
