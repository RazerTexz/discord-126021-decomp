package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    public WidgetOauth2Authorize$configureUI$3(WidgetOauth2Authorize widgetOauth2Authorize) {
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetOauth2Authorize.access$authorizeApplication(this.this$0, null);
    }
}
