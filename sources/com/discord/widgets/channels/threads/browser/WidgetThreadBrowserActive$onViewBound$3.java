package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.channel.ChannelSelector;

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActive$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadBrowserActive this$0;

    public WidgetThreadBrowserActive$onViewBound$3(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        this.this$0 = widgetThreadBrowserActive;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelSelector.openCreateThread$default(ChannelSelector.Companion.getInstance(), WidgetThreadBrowserActive.access$getGuildId$p(this.this$0), WidgetThreadBrowserActive.access$getChannelId$p(this.this$0), null, "Thread Browser Empty State", 4, null);
        this.this$0.requireAppActivity().finish();
    }
}
