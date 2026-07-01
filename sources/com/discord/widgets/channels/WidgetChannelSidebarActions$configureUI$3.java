package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.settings.WidgetMuteSettingsSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WidgetChannelSidebarActions this$0;

    public WidgetChannelSidebarActions$configureUI$3(WidgetChannelSidebarActions widgetChannelSidebarActions, long j) {
        this.this$0 = widgetChannelSidebarActions;
        this.$channelId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetMuteSettingsSheet$Companion widgetMuteSettingsSheet$Companion = WidgetMuteSettingsSheet.Companion;
        long j = this.$channelId;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetMuteSettingsSheet$Companion.showForChannel(j, parentFragmentManager);
    }
}
