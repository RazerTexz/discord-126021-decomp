package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsGuildBoost this$0;

    public WidgetSettingsGuildBoost$onViewBound$2(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        this.this$0 = widgetSettingsGuildBoost;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGuildBoost.access$getViewModel$p(this.this$0).retryClicked();
    }
}
