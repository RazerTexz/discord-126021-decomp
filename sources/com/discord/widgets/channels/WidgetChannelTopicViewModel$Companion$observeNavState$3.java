package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$Companion$observeNavState$3<T1, T2, R> implements Func2<Boolean, Boolean, WidgetChannelTopicViewModel$Companion$NavState> {
    public static final WidgetChannelTopicViewModel$Companion$observeNavState$3 INSTANCE = new WidgetChannelTopicViewModel$Companion$observeNavState$3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel$Companion$NavState call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel$Companion$NavState call2(Boolean bool, Boolean bool2) {
        m.checkNotNullExpressionValue(bool, "isOpen");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(bool2, "isOnHomeTab");
        return new WidgetChannelTopicViewModel$Companion$NavState(zBooleanValue, bool2.booleanValue());
    }
}
