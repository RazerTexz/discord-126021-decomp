package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$configureUI$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetTextChannelSettings$Model $this_configureUI;

    public WidgetTextChannelSettings$configureUI$7(WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        this.$this_configureUI = widgetTextChannelSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSettingsPermissionsOverview.Companion.launch(a.x(view, "it", "it.context"), this.$this_configureUI.getChannel().getId());
    }
}
