package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$sendVerificationKey$2<T> implements Action1<Error> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    public WidgetSettingsAccountBackupCodes$sendVerificationKey$2(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        WidgetSettingsAccountBackupCodes.access$showPasswordModal(this.this$0);
    }
}
