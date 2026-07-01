package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthResetPassword$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthResetPassword this$0;

    public WidgetAuthResetPassword$onViewBound$2(WidgetAuthResetPassword widgetAuthResetPassword) {
        this.this$0 = widgetAuthResetPassword;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requireActivity().finish();
    }
}
