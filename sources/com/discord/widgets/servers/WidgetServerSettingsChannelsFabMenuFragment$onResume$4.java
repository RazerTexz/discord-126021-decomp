package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.channels.WidgetCreateChannel$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsFabMenuFragment$onResume$4 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetServerSettingsChannelsFabMenuFragment this$0;

    public WidgetServerSettingsChannelsFabMenuFragment$onResume$4(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment, long j) {
        this.this$0 = widgetServerSettingsChannelsFabMenuFragment;
        this.$guildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel$Companion widgetCreateChannel$Companion = WidgetCreateChannel.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetCreateChannel$Companion.show$default(widgetCreateChannel$Companion, contextRequireContext, this.$guildId, 0, null, 8, null);
    }
}
