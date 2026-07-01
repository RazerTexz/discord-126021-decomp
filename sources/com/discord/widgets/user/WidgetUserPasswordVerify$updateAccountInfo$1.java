package com.discord.widgets.user;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManagerKt;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify$updateAccountInfo$1<T> implements Action1<User> {
    public final /* synthetic */ String $newEmail;
    public final /* synthetic */ String $password;
    public final /* synthetic */ WidgetUserPasswordVerify this$0;

    public WidgetUserPasswordVerify$updateAccountInfo$1(WidgetUserPasswordVerify widgetUserPasswordVerify, String str, String str2) {
        this.this$0 = widgetUserPasswordVerify;
        this.$newEmail = str;
        this.$password = str2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(User user) {
        call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(User user) {
        GoogleSmartLockManager googleSmartLockManager;
        StoreStream.Companion.getAuthentication().setAuthed(user.getToken());
        Context context = this.this$0.getContext();
        if (context != null && (googleSmartLockManager = GoogleSmartLockManagerKt.googleSmartLockManager(context)) != null) {
            googleSmartLockManager.updateAccountInfo(this.$newEmail, this.$password);
        }
        WidgetUserPasswordVerify.access$finishWithSuccess(this.this$0);
    }
}
