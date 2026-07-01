package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter$ThreadItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadBrowserAdapter$Item$Thread $item;
    public final /* synthetic */ WidgetThreadBrowserAdapter$ThreadItem this$0;

    public WidgetThreadBrowserAdapter$ThreadItem$onConfigure$1(WidgetThreadBrowserAdapter$ThreadItem widgetThreadBrowserAdapter$ThreadItem, WidgetThreadBrowserAdapter$Item$Thread widgetThreadBrowserAdapter$Item$Thread) {
        this.this$0 = widgetThreadBrowserAdapter$ThreadItem;
        this.$item = widgetThreadBrowserAdapter$Item$Thread;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadBrowserAdapter$ThreadItem.access$getAdapter$p(this.this$0).onThreadClicked(this.$item.getThreadData().getChannel());
    }
}
