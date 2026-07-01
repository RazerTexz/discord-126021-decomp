package com.discord.widgets.notice;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetNoticeNuxSamsungLink this$0;

    public WidgetNoticeNuxSamsungLink$onViewBound$3(WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink) {
        this.this$0 = widgetNoticeNuxSamsungLink;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
