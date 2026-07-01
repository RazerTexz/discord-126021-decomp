package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.discord.widgets.user.phone.WidgetUserPhoneManage$Companion$Source;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$5 implements View$OnClickListener {
    public static final WidgetSettingsAccount$configureUI$5 INSTANCE = new WidgetSettingsAccount$configureUI$5();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserPhoneManage.Companion.launch(a.x(view, "it", "it.context"), WidgetUserAccountVerifyBase$Mode.UNFORCED, WidgetUserPhoneManage$Companion$Source.USER_SETTINGS_UPDATE);
    }
}
