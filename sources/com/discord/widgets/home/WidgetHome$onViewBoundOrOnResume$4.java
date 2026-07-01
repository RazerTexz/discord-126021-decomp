package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBoundOrOnResume$4<T1, T2, R> implements Func2<WidgetHomeModel, WidgetHomeModel, Boolean> {
    public static final WidgetHome$onViewBoundOrOnResume$4 INSTANCE = new WidgetHome$onViewBoundOrOnResume$4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(WidgetHomeModel widgetHomeModel, WidgetHomeModel widgetHomeModel2) {
        return call2(widgetHomeModel, widgetHomeModel2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetHomeModel widgetHomeModel, WidgetHomeModel widgetHomeModel2) {
        return Boolean.valueOf(widgetHomeModel.getChannelId() == widgetHomeModel2.getChannelId());
    }
}
