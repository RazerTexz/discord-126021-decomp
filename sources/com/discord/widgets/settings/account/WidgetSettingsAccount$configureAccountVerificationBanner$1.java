package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import com.discord.widgets.user.email.WidgetUserEmailVerify;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureAccountVerificationBanner$1 implements View$OnClickListener {
    public static final WidgetSettingsAccount$configureAccountVerificationBanner$1 INSTANCE = new WidgetSettingsAccount$configureAccountVerificationBanner$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserEmailVerify.Companion.launch(a.x(view, "v", "v.context"), WidgetUserAccountVerifyBase$Mode.UNFORCED);
    }
}
