package com.discord.widgets.guilds.contextmenu;

import android.os.Bundle;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu$viewModel$2 extends o implements Function0<FolderContextMenuViewModel> {
    public final /* synthetic */ WidgetFolderContextMenu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFolderContextMenu$viewModel$2(WidgetFolderContextMenu widgetFolderContextMenu) {
        super(0);
        this.this$0 = widgetFolderContextMenu;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FolderContextMenuViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FolderContextMenuViewModel invoke() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return new FolderContextMenuViewModel(arguments.getLong("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID"), null, null, 6, null);
        }
        throw new IllegalStateException("missing folder id");
    }
}
