package com.discord.widgets.announcements;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel$observeViewStateFromStores$2<T, R> implements b<Long, Observable<? extends Channel>> {
    public final /* synthetic */ WidgetChannelFollowSheetViewModel this$0;

    public WidgetChannelFollowSheetViewModel$observeViewStateFromStores$2(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        this.this$0 = widgetChannelFollowSheetViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Long l) {
        if (l != null) {
            Observable<Channel> observableObserveChannel = this.this$0.getStoreChannels().observeChannel(l.longValue());
            if (observableObserveChannel != null) {
                return observableObserveChannel;
            }
        }
        return new k(null);
    }
}
