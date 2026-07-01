package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostConfirmation$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildBoostConfirmation this$0;

    public WidgetGuildBoostConfirmation$onViewBound$1(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        this.this$0 = widgetGuildBoostConfirmation;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildBoostConfirmation.access$getViewModel$p(this.this$0).subscribeToGuildBoost(WidgetGuildBoostConfirmation.access$getGuildId$p(this.this$0), WidgetGuildBoostConfirmation.access$getSlotId$p(this.this$0));
    }
}
