package com.discord.widgets.guilds;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildFolderSettingsViewModel$ViewState $state;
    public final /* synthetic */ WidgetGuildFolderSettings this$0;

    public WidgetGuildFolderSettings$configureUI$2(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel$ViewState widgetGuildFolderSettingsViewModel$ViewState) {
        this.this$0 = widgetGuildFolderSettings;
        this.$state = widgetGuildFolderSettingsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildFolderSettings.access$launchColorPicker(this.this$0, (WidgetGuildFolderSettingsViewModel$ViewState$Loaded) this.$state);
    }
}
