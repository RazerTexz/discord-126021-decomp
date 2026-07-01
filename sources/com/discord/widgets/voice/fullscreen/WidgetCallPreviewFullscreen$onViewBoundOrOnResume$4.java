package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$onViewBoundOrOnResume$4<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    public WidgetCallPreviewFullscreen$onViewBoundOrOnResume$4(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        this.this$0 = widgetCallPreviewFullscreen;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        WidgetCallPreviewFullscreen.finishActivity$default(this.this$0, true, false, 2, null);
        return Boolean.TRUE;
    }
}
