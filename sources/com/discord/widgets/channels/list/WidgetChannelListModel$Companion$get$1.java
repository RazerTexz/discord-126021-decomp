package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$get$1<T, R> implements b<Long, Observable<? extends WidgetChannelListModel>> {
    public static final WidgetChannelListModel$Companion$get$1 INSTANCE = new WidgetChannelListModel$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelListModel> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelListModel> call2(Long l) {
        if (l != null && l.longValue() == 0) {
            return WidgetChannelListModel$Companion.access$getPrivateChannelList(WidgetChannelListModel.Companion);
        }
        WidgetChannelListModel$Companion widgetChannelListModel$Companion = WidgetChannelListModel.Companion;
        m.checkNotNullExpressionValue(l, "guildId");
        return WidgetChannelListModel$Companion.access$getSelectedGuildChannelList(widgetChannelListModel$Companion, l.longValue());
    }
}
