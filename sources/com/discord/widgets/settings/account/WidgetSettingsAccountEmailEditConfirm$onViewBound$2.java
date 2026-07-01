package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccountEmailEditConfirm this$0;

    public WidgetSettingsAccountEmailEditConfirm$onViewBound$2(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        this.this$0 = widgetSettingsAccountEmailEditConfirm;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(this.this$0);
    }
}
