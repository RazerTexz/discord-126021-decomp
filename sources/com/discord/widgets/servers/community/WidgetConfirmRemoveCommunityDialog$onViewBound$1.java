package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetConfirmRemoveCommunityDialog this$0;

    public WidgetConfirmRemoveCommunityDialog$onViewBound$1(WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog) {
        this.this$0 = widgetConfirmRemoveCommunityDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetConfirmRemoveCommunityDialog.access$getViewModel$p(this.this$0).disableCommunity();
    }
}
