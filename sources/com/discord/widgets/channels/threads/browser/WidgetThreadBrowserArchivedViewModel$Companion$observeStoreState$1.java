package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<ArchivedThreadsStore$ThreadListingState, Channel, Pair<? extends ArchivedThreadsStore$ThreadListingState, ? extends Channel>> {
    public static final WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends ArchivedThreadsStore$ThreadListingState, ? extends Channel> call(ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, Channel channel) {
        return call2(archivedThreadsStore$ThreadListingState, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<ArchivedThreadsStore$ThreadListingState, Channel> call2(ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, Channel channel) {
        return new Pair<>(archivedThreadsStore$ThreadListingState, channel);
    }
}
