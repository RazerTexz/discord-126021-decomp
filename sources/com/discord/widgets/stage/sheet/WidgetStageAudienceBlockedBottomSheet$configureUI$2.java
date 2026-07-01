package com.discord.widgets.stage.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetStageAudienceBlockedBottomSheet this$0;

    public WidgetStageAudienceBlockedBottomSheet$configureUI$2(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        this.this$0 = widgetStageAudienceBlockedBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
