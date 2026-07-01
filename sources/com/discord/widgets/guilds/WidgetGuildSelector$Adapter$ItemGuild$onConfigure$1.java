package com.discord.widgets.guilds;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildSelector$Item $data;
    public final /* synthetic */ WidgetGuildSelector$Adapter$ItemGuild this$0;

    public WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1(WidgetGuildSelector$Adapter$ItemGuild widgetGuildSelector$Adapter$ItemGuild, WidgetGuildSelector$Item widgetGuildSelector$Item) {
        this.this$0 = widgetGuildSelector$Adapter$ItemGuild;
        this.$data = widgetGuildSelector$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildSelector.access$onGuildSelected(WidgetGuildSelector$Adapter.access$getDialog$p(WidgetGuildSelector$Adapter$ItemGuild.access$getAdapter$p(this.this$0)), this.$data.getGuild());
    }
}
