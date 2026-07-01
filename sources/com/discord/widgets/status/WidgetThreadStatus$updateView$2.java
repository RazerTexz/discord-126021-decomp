package com.discord.widgets.status;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatus$updateView$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadStatus this$0;

    public WidgetThreadStatus$updateView$2(WidgetThreadStatus widgetThreadStatus) {
        this.this$0 = widgetThreadStatus;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadStatus.access$getViewModel$p(this.this$0).onJoinTapped();
    }
}
