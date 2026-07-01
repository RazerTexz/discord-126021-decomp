package com.discord.widgets.contact_sync;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureToolbar$3<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetContactSyncViewModel$ToolbarConfig $toolbarConfig;
    public final /* synthetic */ WidgetContactSync this$0;

    public WidgetContactSync$configureToolbar$3(WidgetContactSync widgetContactSync, WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfig) {
        this.this$0 = widgetContactSync;
        this.$toolbarConfig = widgetContactSyncViewModel$ToolbarConfig;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        if (!this.$toolbarConfig.getShowBackButton()) {
            return Boolean.FALSE;
        }
        WidgetContactSync.access$getViewModel$p(this.this$0).skip();
        return Boolean.TRUE;
    }
}
