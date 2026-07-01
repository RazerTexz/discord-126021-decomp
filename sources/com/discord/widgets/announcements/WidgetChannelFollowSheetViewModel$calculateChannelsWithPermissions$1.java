package com.discord.widgets.announcements;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1<T, R> implements b<Map<Long, ? extends Long>, Observable<? extends Map<Long, ? extends List<? extends Channel>>>> {
    public final /* synthetic */ WidgetChannelFollowSheetViewModel this$0;

    public WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        this.this$0 = widgetChannelFollowSheetViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends List<? extends Channel>>> call(Map<Long, ? extends Long> map) {
        return call2((Map<Long, Long>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, List<Channel>>> call2(Map<Long, Long> map) {
        return this.this$0.getStoreChannels().observeGuildAndPrivateChannels().r().G(new WidgetChannelFollowSheetViewModel$calculateChannelsWithPermissions$1$1(map));
    }
}
