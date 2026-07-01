package com.discord.widgets.guilds.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$onViewBound$2$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildsList$onViewBound$2 this$0;

    public WidgetGuildsList$onViewBound$2$1(WidgetGuildsList$onViewBound$2 widgetGuildsList$onViewBound$2) {
        this.this$0 = widgetGuildsList$onViewBound$2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildsList.access$dismissAddGuildHint(this.this$0.this$0, true);
    }
}
