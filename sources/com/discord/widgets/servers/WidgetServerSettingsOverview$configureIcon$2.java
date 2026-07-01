package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureIcon$2 implements View$OnClickListener {
    public final /* synthetic */ String $guildShortName;
    public final /* synthetic */ String $iconOriginal;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureIcon$2(WidgetServerSettingsOverview widgetServerSettingsOverview, String str, String str2) {
        this.this$0 = widgetServerSettingsOverview;
        this.$guildShortName = str;
        this.$iconOriginal = str2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview.access$configureIcon(this.this$0, this.$guildShortName, this.$iconOriginal, null, true);
    }
}
