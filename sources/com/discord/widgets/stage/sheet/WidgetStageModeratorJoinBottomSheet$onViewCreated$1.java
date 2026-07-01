package com.discord.widgets.stage.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetStageModeratorJoinBottomSheet this$0;

    public WidgetStageModeratorJoinBottomSheet$onViewCreated$1(WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet) {
        this.this$0 = widgetStageModeratorJoinBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requestMicrophone(new WidgetStageModeratorJoinBottomSheet$onViewCreated$1$1(this), new WidgetStageModeratorJoinBottomSheet$onViewCreated$1$2(this));
    }
}
