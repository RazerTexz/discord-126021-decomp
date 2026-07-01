package com.discord.widgets.guilds.join;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoin$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildJoin this$0;

    public WidgetGuildJoin$onViewBound$2(WidgetGuildJoin widgetGuildJoin) {
        this.this$0 = widgetGuildJoin;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.handleGuildJoin();
    }
}
