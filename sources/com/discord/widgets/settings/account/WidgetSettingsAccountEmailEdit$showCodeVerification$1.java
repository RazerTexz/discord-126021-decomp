package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEdit$showCodeVerification$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetSettingsAccountEmailEdit this$0;

    public WidgetSettingsAccountEmailEdit$showCodeVerification$1(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        this.this$0 = widgetSettingsAccountEmailEdit;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r5) {
        WidgetSettingsAccountEmailEditConfirm$Companion widgetSettingsAccountEmailEditConfirm$Companion = WidgetSettingsAccountEmailEditConfirm.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        ActivityResultLauncher<Intent> activityResultLauncherAccess$getNextScreenLauncher$p = WidgetSettingsAccountEmailEdit.access$getNextScreenLauncher$p(this.this$0);
        TextInputLayout textInputLayout = WidgetSettingsAccountEmailEdit.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
        widgetSettingsAccountEmailEditConfirm$Companion.launch(contextRequireContext, activityResultLauncherAccess$getNextScreenLauncher$p, ViewExtensions.getTextOrEmpty(textInputLayout));
    }
}
