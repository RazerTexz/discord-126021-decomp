package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify$updatePhoneNumber$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetUserPasswordVerify this$0;

    public WidgetUserPasswordVerify$updatePhoneNumber$1(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        this.this$0 = widgetUserPasswordVerify;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r1) {
        WidgetUserPasswordVerify.access$finishWithSuccess(this.this$0);
    }
}
