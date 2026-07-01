package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps$onViewBound$3<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunitySteps this$0;

    public WidgetServerSettingsEnableCommunitySteps$onViewBound$3(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        this.this$0 = widgetServerSettingsEnableCommunitySteps;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        WidgetServerSettingsEnableCommunitySteps.access$getViewModel$p(this.this$0).goBackToPreviousPage();
        return Boolean.TRUE;
    }
}
