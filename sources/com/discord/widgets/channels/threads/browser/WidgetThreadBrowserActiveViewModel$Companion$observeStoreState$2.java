package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import java.util.Map;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2<T1, T2, R> implements Func2<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>> {
    public static final WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2 INSTANCE = new WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2) {
        return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Map<Long, Channel>, Map<Long, Channel>> call2(Map<Long, Channel> map, Map<Long, Channel> map2) {
        return new Pair<>(map, map2);
    }
}
