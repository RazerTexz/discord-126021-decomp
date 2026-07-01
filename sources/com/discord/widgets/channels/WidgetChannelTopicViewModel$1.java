package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$1<T, R> implements b<WidgetChannelTopicViewModel$Companion$NavState, Observable<? extends WidgetChannelTopicViewModel$StoreState>> {
    public static final WidgetChannelTopicViewModel$1 INSTANCE = new WidgetChannelTopicViewModel$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelTopicViewModel$StoreState> call(WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState) {
        return call2(widgetChannelTopicViewModel$Companion$NavState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelTopicViewModel$StoreState> call2(WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState) {
        if (widgetChannelTopicViewModel$Companion$NavState.isRightPanelOpened()) {
            WidgetChannelTopicViewModel$Companion widgetChannelTopicViewModel$Companion = WidgetChannelTopicViewModel.Companion;
            m.checkNotNullExpressionValue(widgetChannelTopicViewModel$Companion$NavState, "navState");
            return WidgetChannelTopicViewModel$Companion.observeStoreState$default(widgetChannelTopicViewModel$Companion, widgetChannelTopicViewModel$Companion$NavState, null, null, null, null, null, 62, null);
        }
        WidgetChannelTopicViewModel$Companion widgetChannelTopicViewModel$Companion2 = WidgetChannelTopicViewModel.Companion;
        m.checkNotNullExpressionValue(widgetChannelTopicViewModel$Companion$NavState, "navState");
        return WidgetChannelTopicViewModel$Companion.observeStoreState$default(widgetChannelTopicViewModel$Companion2, widgetChannelTopicViewModel$Companion$NavState, null, null, null, null, null, 62, null).Z(1);
    }
}
