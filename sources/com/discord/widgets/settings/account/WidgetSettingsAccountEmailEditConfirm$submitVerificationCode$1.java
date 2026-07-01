package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelEmailChangeConfirm;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.WidgetUserPasswordVerify$Companion;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm$submitVerificationCode$1<T> implements Action1<ModelEmailChangeConfirm> {
    public final /* synthetic */ WidgetSettingsAccountEmailEditConfirm this$0;

    public WidgetSettingsAccountEmailEditConfirm$submitVerificationCode$1(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        this.this$0 = widgetSettingsAccountEmailEditConfirm;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(ModelEmailChangeConfirm modelEmailChangeConfirm) {
        call2(modelEmailChangeConfirm);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(ModelEmailChangeConfirm modelEmailChangeConfirm) {
        WidgetUserPasswordVerify$Companion.launchUpdateAccountSettings$default(WidgetUserPasswordVerify.Companion, this.this$0.requireContext(), WidgetSettingsAccountEmailEditConfirm.access$getPasswordVerifyLauncher$p(this.this$0), this.this$0.getMostRecentIntent().getStringExtra("extra_email"), null, null, modelEmailChangeConfirm != null ? modelEmailChangeConfirm.getToken() : null, 24, null);
    }
}
