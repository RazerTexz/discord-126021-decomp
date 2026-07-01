package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.app.AppFragment;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$onViewBound$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthLogin this$0;

    public WidgetAuthLogin$onViewBound$6(WidgetAuthLogin widgetAuthLogin) {
        this.this$0 = widgetAuthLogin;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
