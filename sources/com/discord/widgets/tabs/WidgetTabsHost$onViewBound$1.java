package com.discord.widgets.tabs;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost$onViewBound$1<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetTabsHost this$0;

    public WidgetTabsHost$onViewBound$1(WidgetTabsHost widgetTabsHost) {
        this.this$0 = widgetTabsHost;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        return Boolean.valueOf(WidgetTabsHost.access$getViewModel$p(this.this$0).handleBackPress());
    }
}
