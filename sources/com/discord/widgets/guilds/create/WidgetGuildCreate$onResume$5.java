package com.discord.widgets.guilds.create;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildCreate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreate$onResume$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildCreate this$0;

    public WidgetGuildCreate$onResume$5(WidgetGuildCreate widgetGuildCreate) {
        this.this$0 = widgetGuildCreate;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildCreate.access$getViewModel$p(this.this$0).createGuild(this.this$0.requireContext());
        WidgetGuildCreate widgetGuildCreate = this.this$0;
        widgetGuildCreate.hideKeyboard(widgetGuildCreate.getView());
    }
}
