package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$onViewBound$3<R> implements Func0<Boolean> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    public WidgetOauth2Authorize$onViewBound$3(WidgetOauth2Authorize widgetOauth2Authorize) {
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finishAndRemoveTask();
        }
        return Boolean.TRUE;
    }
}
