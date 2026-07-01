package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify$removePhoneNumber$2<T> implements Action1<Error> {
    public final /* synthetic */ WidgetUserPasswordVerify this$0;

    public WidgetUserPasswordVerify$removePhoneNumber$2(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        this.this$0 = widgetUserPasswordVerify;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        WidgetUserPasswordVerify widgetUserPasswordVerify = this.this$0;
        m.checkNotNullExpressionValue(error, "it");
        error.setShowErrorToasts(!WidgetUserPasswordVerify.access$maybeHandleApiError(widgetUserPasswordVerify, error));
    }
}
