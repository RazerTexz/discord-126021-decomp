package com.discord.widgets.guilds;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildFolderSettings this$0;

    public WidgetGuildFolderSettings$configureUI$3(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        this.this$0 = widgetGuildFolderSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildFolderSettings.access$getViewModel$p(this.this$0).saveFolder();
    }
}
