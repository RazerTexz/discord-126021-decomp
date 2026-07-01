package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu$configureValidUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildContextMenu this$0;

    public WidgetGuildContextMenu$configureValidUI$1(WidgetGuildContextMenu widgetGuildContextMenu) {
        this.this$0 = widgetGuildContextMenu;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildContextMenu.access$doCircularRemove(this.this$0);
        WidgetGuildContextMenu.access$getViewModel$p(this.this$0).onMarkAsReadClicked();
    }
}
