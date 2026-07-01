package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.channel.ChannelSelector;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetThreadBrowserArchived this$0;

    public WidgetThreadBrowserArchived$onViewBound$4(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        this.this$0 = widgetThreadBrowserArchived;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelSelector.openCreateThread$default(ChannelSelector.Companion.getInstance(), WidgetThreadBrowserArchived.access$getGuildId$p(this.this$0), WidgetThreadBrowserArchived.access$getChannelId$p(this.this$0), null, "Thread Browser Empty State", 4, null);
        this.this$0.requireAppActivity().finish();
    }
}
