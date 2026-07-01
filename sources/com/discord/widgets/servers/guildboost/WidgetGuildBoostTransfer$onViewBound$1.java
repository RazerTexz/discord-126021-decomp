package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildBoostTransfer this$0;

    public WidgetGuildBoostTransfer$onViewBound$1(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        this.this$0 = widgetGuildBoostTransfer;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildBoostTransfer.access$getViewModel$p(this.this$0).transferGuildBoost();
    }
}
