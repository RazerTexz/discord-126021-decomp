package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$jumpToMessage$6<T, R> implements b<Boolean, Observable<? extends Channel>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreMessagesLoader this$0;

    public StoreMessagesLoader$jumpToMessage$6(StoreMessagesLoader storeMessagesLoader, long j) {
        this.this$0 = storeMessagesLoader;
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isConnected");
        int i = bool.booleanValue() ? 1 : 3;
        Observable<R> observableG = StoreMessagesLoader.access$getStream$p(this.this$0).getChannels().observeChannel(this.$channelId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        return ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 1000 * ((long) i), false, 2, null);
    }
}
