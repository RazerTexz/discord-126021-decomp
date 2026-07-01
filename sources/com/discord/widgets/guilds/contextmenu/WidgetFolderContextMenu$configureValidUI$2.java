package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.guilds.WidgetGuildFolderSettings;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu$configureValidUI$2 implements View$OnClickListener {
    public final /* synthetic */ FolderContextMenuViewModel$ViewState$Valid $viewState;
    public final /* synthetic */ WidgetFolderContextMenu this$0;

    public WidgetFolderContextMenu$configureValidUI$2(WidgetFolderContextMenu widgetFolderContextMenu, FolderContextMenuViewModel$ViewState$Valid folderContextMenuViewModel$ViewState$Valid) {
        this.this$0 = widgetFolderContextMenu;
        this.$viewState = folderContextMenuViewModel$ViewState$Valid;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFolderContextMenu.access$doCircularRemove(this.this$0);
        Long id2 = this.$viewState.getFolder().getId();
        if (id2 != null) {
            WidgetGuildFolderSettings.Companion.create(a.I(WidgetFolderContextMenu.access$getBinding$p(this.this$0).e, "binding.folderContextMenuSettings", "binding.folderContextMenuSettings.context"), id2.longValue());
        }
        WidgetFolderContextMenu.access$getViewModel$p(this.this$0).onSettingsClicked();
    }
}
