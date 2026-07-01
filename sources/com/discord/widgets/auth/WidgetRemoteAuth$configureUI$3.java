package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetRemoteAuth this$0;

    public WidgetRemoteAuth$configureUI$3(WidgetRemoteAuth widgetRemoteAuth) {
        this.this$0 = widgetRemoteAuth;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetRemoteAuth.access$getViewModel$p(this.this$0).remoteLogin();
    }
}
