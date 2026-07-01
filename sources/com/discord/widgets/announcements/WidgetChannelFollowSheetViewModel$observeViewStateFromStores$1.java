package com.discord.widgets.announcements;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel$observeViewStateFromStores$1<T, R> implements b<Long, Observable<? extends Guild>> {
    public final /* synthetic */ WidgetChannelFollowSheetViewModel this$0;

    public WidgetChannelFollowSheetViewModel$observeViewStateFromStores$1(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        this.this$0 = widgetChannelFollowSheetViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Guild> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Guild> call2(Long l) {
        if (l != null) {
            Observable<Guild> observableObserveGuild = this.this$0.getStoreGuilds().observeGuild(l.longValue());
            if (observableObserveGuild != null) {
                return observableObserveGuild;
            }
        }
        return new k(null);
    }
}
