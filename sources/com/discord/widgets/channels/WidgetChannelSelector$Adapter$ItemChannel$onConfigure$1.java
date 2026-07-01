package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$Adapter$ItemChannel$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelSelector$Model$Item $data;
    public final /* synthetic */ WidgetChannelSelector$Adapter$ItemChannel this$0;

    public WidgetChannelSelector$Adapter$ItemChannel$onConfigure$1(WidgetChannelSelector$Adapter$ItemChannel widgetChannelSelector$Adapter$ItemChannel, WidgetChannelSelector$Model$Item widgetChannelSelector$Model$Item) {
        this.this$0 = widgetChannelSelector$Adapter$ItemChannel;
        this.$data = widgetChannelSelector$Model$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSelector.access$onChannelSelected(WidgetChannelSelector$Adapter.access$getDialog$p(WidgetChannelSelector$Adapter$ItemChannel.access$getAdapter$p(this.this$0)), this.$data.getChannel());
    }
}
