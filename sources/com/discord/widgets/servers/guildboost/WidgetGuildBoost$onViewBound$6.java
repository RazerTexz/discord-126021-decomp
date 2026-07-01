package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.Traits$Location$Section;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$onViewBound$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildBoost this$0;

    public WidgetGuildBoost$onViewBound$6(WidgetGuildBoost widgetGuildBoost) {
        this.this$0 = widgetGuildBoost;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildBoost.access$getViewModel$p(this.this$0).subscribeClicked(Traits$Location$Section.FOOTER);
    }
}
