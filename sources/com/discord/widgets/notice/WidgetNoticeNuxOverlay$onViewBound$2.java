package com.discord.widgets.notice;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetNoticeNuxOverlay this$0;

    public WidgetNoticeNuxOverlay$onViewBound$2(WidgetNoticeNuxOverlay widgetNoticeNuxOverlay) {
        this.this$0 = widgetNoticeNuxOverlay;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getUserSettings().setIsMobileOverlayEnabled(false);
        this.this$0.dismiss();
    }
}
