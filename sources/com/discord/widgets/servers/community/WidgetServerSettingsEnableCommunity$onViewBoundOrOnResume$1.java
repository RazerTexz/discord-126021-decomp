package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunity$onViewBoundOrOnResume$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEnableCommunity this$0;

    public WidgetServerSettingsEnableCommunity$onViewBoundOrOnResume$1(WidgetServerSettingsEnableCommunity widgetServerSettingsEnableCommunity) {
        this.this$0 = widgetServerSettingsEnableCommunity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEnableCommunity.access$getViewModel$p(this.this$0).updateCurrentPage(1);
    }
}
