package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeModel$Companion$get$1<T1, T2, R> implements Func2<Long, StoreChannelsSelected$ResolvedSelectedChannel, Pair<? extends Long, ? extends StoreChannelsSelected$ResolvedSelectedChannel>> {
    public static final WidgetHomeModel$Companion$get$1 INSTANCE = new WidgetHomeModel$Companion$get$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Long, ? extends StoreChannelsSelected$ResolvedSelectedChannel> call(Long l, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(l, storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Long, StoreChannelsSelected$ResolvedSelectedChannel> call2(Long l, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return o.to(l, storeChannelsSelected$ResolvedSelectedChannel);
    }
}
