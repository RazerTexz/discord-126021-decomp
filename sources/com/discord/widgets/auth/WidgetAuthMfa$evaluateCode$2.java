package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa$evaluateCode$2<T> implements Action1<Error> {
    public final /* synthetic */ WidgetAuthMfa this$0;

    public WidgetAuthMfa$evaluateCode$2(WidgetAuthMfa widgetAuthMfa) {
        this.this$0 = widgetAuthMfa;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        WidgetAuthMfa.access$getBinding$p(this.this$0).f2234b.b();
        AnalyticsTracker.INSTANCE.loginAttempt(false);
    }
}
