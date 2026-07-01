package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthLogin this$0;

    public WidgetAuthLogin$onViewBound$2(WidgetAuthLogin widgetAuthLogin) {
        this.this$0 = widgetAuthLogin;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAuthLogin.login$default(this.this$0, null, false, 3, null);
    }
}
