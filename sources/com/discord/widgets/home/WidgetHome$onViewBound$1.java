package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBound$1<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetHome this$0;

    public WidgetHome$onViewBound$1(WidgetHome widgetHome) {
        this.this$0 = widgetHome;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        return Boolean.valueOf(WidgetHome.access$handleBackPressed(this.this$0));
    }
}
