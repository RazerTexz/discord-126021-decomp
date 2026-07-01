package com.discord.widgets.user.phone;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$handleCodeEntered$3<T> implements Action1<Error> {
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    public WidgetUserPhoneVerify$handleCodeEntered$3(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        this.this$0 = widgetUserPhoneVerify;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        WidgetUserPhoneVerify.access$getBinding$p(this.this$0).d.b();
    }
}
