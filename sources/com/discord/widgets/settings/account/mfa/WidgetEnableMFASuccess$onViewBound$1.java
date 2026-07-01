package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.discord.widgets.user.phone.WidgetUserPhoneManage$Companion$Source;

/* JADX INFO: compiled from: WidgetEnableMFASuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASuccess$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEnableMFASuccess this$0;

    public WidgetEnableMFASuccess$onViewBound$1(WidgetEnableMFASuccess widgetEnableMFASuccess) {
        this.this$0 = widgetEnableMFASuccess;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserPhoneManage.Companion.launch(a.x(view, "it", "it.context"), WidgetUserAccountVerifyBase$Mode.NO_HISTORY_FROM_USER_SETTINGS, WidgetUserPhoneManage$Companion$Source.MFA_PHONE_UPDATE);
        this.this$0.requireActivity().finish();
    }
}
