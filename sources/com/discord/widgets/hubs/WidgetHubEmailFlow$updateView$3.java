package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$updateView$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    public WidgetHubEmailFlow$updateView$3(WidgetHubEmailFlow widgetHubEmailFlow) {
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetHubEmailFlow.access$verifyEmail(this.this$0);
    }
}
