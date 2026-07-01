package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildBoost this$0;

    public WidgetGuildBoost$configureUI$1(WidgetGuildBoost widgetGuildBoost) {
        this.this$0 = widgetGuildBoost;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildBoost.access$getViewModel$p(this.this$0).retryClicked();
    }
}
