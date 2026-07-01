package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthLogin this$0;

    public WidgetAuthLogin$onViewBound$4(WidgetAuthLogin widgetAuthLogin) {
        this.this$0 = widgetAuthLogin;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAuthLogin.forgotPassword$default(this.this$0, null, 1, null);
    }
}
