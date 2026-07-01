package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatus$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserSetCustomStatus this$0;

    public WidgetUserSetCustomStatus$onViewBound$4(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        this.this$0 = widgetUserSetCustomStatus;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserSetCustomStatus.access$getViewModel$p(this.this$0).saveStatus();
    }
}
