package com.discord.widgets.announcements;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelFollowSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSuccessDialog$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelFollowSuccessDialog this$0;

    public WidgetChannelFollowSuccessDialog$onViewBound$1(WidgetChannelFollowSuccessDialog widgetChannelFollowSuccessDialog) {
        this.this$0 = widgetChannelFollowSuccessDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
