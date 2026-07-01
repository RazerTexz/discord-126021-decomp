package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.user.MeUser;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountChangePassword$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ MeUser $meUser;
    public final /* synthetic */ WidgetSettingsAccountChangePassword this$0;

    public WidgetSettingsAccountChangePassword$configureUI$1(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword, MeUser meUser) {
        this.this$0 = widgetSettingsAccountChangePassword;
        this.$meUser = meUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountChangePassword.access$saveNewPassword(this.this$0, this.$meUser);
    }
}
