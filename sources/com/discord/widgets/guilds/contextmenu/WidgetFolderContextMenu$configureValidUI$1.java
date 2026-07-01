package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu$configureValidUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetFolderContextMenu this$0;

    public WidgetFolderContextMenu$configureValidUI$1(WidgetFolderContextMenu widgetFolderContextMenu) {
        this.this$0 = widgetFolderContextMenu;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFolderContextMenu.access$doCircularRemove(this.this$0);
        WidgetFolderContextMenu.access$getViewModel$p(this.this$0).onMarkAsReadClicked();
    }
}
