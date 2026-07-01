package com.discord.widgets.stage.sheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeBottomSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetStageAudienceNoticeBottomSheet this$0;

    public WidgetStageAudienceNoticeBottomSheet$onViewCreated$1(WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet) {
        this.this$0 = widgetStageAudienceNoticeBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
