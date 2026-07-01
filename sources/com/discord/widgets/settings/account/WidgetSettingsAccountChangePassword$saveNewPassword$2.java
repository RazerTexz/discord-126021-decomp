package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountChangePassword$saveNewPassword$2<T> implements Action1<Error> {
    public final /* synthetic */ WidgetSettingsAccountChangePassword this$0;

    public WidgetSettingsAccountChangePassword$saveNewPassword$2(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword) {
        this.this$0 = widgetSettingsAccountChangePassword;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        this.this$0.getBinding().e.setIsLoading(false);
        WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword = this.this$0;
        m.checkNotNullExpressionValue(error, "error");
        WidgetSettingsAccountChangePassword.access$handleError(widgetSettingsAccountChangePassword, error);
    }
}
