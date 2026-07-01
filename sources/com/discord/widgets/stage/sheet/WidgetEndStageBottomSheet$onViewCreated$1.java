package com.discord.widgets.stage.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEndStageBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEndStageBottomSheet this$0;

    public WidgetEndStageBottomSheet$onViewCreated$1(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        this.this$0 = widgetEndStageBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetEndStageBottomSheet.access$callOnActionTaken(this.this$0);
    }
}
