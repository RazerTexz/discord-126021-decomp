package com.discord.widgets.guilds.contextmenu;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu4 extends Lambda implements Function0<FolderContextMenuViewModel> {
    public final /* synthetic */ WidgetFolderContextMenu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFolderContextMenu4(WidgetFolderContextMenu widgetFolderContextMenu) {
        super(0);
        this.this$0 = widgetFolderContextMenu;
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
