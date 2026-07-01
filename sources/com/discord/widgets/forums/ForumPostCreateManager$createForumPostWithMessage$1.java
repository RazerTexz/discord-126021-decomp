package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager$createForumPostWithMessage$1<T, R> implements b<Channel, Observable<? extends Channel>> {
    public static final ForumPostCreateManager$createForumPostWithMessage$1 INSTANCE = new ForumPostCreateManager$createForumPostWithMessage$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Channel channel) {
        Observable<R> observableG = StoreStream.Companion.getChannels().observeChannel(channel.getId()).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null));
    }
}
