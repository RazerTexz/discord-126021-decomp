package com.discord.widgets.bugreports;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppFragment;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$updateView$4<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetBugReport this$0;

    public WidgetBugReport$updateView$4(WidgetBugReport widgetBugReport) {
        this.this$0 = widgetBugReport;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        WidgetBugReport.access$setBackHandlerAdded$p(this.this$0, false);
        BugReportViewModel.showReport$default(WidgetBugReport.access$getViewModel$p(this.this$0), null, 1, null);
        AppFragment.setOnBackPressed$default(this.this$0, WidgetBugReport$updateView$4$1.INSTANCE, 0, 2, null);
        return Boolean.TRUE;
    }
}
