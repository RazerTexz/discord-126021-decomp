package com.discord.widgets.settings.account;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManagerKt;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountChangePassword$saveNewPassword$1<T> implements Action1<User> {
    public final /* synthetic */ String $newPasswordText;
    public final /* synthetic */ WidgetSettingsAccountChangePassword this$0;

    public WidgetSettingsAccountChangePassword$saveNewPassword$1(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, String str) {
        this.this$0 = widgetSettingsAccountChangePassword;
        this.$newPasswordText = str;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(User user) {
        call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(User user) {
        GoogleSmartLockManager googleSmartLockManager;
        Context context = this.this$0.getContext();
        if (context != null && (googleSmartLockManager = GoogleSmartLockManagerKt.googleSmartLockManager(context)) != null) {
            googleSmartLockManager.updateAccountInfo(null, this.$newPasswordText);
        }
        StoreStream.Companion.getAuthentication().onPasswordChanged(user.getToken());
        this.this$0.onChangePasswordSuccess();
    }
}
