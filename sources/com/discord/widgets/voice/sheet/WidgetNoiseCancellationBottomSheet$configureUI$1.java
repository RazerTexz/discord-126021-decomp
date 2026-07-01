package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetNoiseCancellationBottomSheet this$0;

    public WidgetNoiseCancellationBottomSheet$configureUI$1(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet) {
        this.this$0 = widgetNoiseCancellationBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetNoiseCancellationBottomSheet.access$getViewModel$p(this.this$0).onNoiseCancellationButtonPressed();
        this.this$0.dismiss();
    }
}
