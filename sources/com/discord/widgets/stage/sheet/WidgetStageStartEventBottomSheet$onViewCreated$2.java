package com.discord.widgets.stage.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet$onViewCreated$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetStageStartEventBottomSheet this$0;

    public WidgetStageStartEventBottomSheet$onViewCreated$2(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        this.this$0 = widgetStageStartEventBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requestMicrophone(new WidgetStageStartEventBottomSheet$onViewCreated$2$1(this), new WidgetStageStartEventBottomSheet$onViewCreated$2$2(this));
    }
}
