package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBoundOrOnResume$1$2<T, R> implements b<Integer, Boolean> {
    public static final WidgetIncomingShare$onViewBoundOrOnResume$1$2 INSTANCE = new WidgetIncomingShare$onViewBoundOrOnResume$1$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Integer num) {
        return Boolean.valueOf(num.intValue() > 0);
    }
}
