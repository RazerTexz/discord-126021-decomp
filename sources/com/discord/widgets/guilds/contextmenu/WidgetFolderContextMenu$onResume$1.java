package com.discord.widgets.guilds.contextmenu;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFolderContextMenu$onResume$1 extends k implements Function1<FolderContextMenuViewModel$ViewState, Unit> {
    public WidgetFolderContextMenu$onResume$1(WidgetFolderContextMenu widgetFolderContextMenu) {
        super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel$ViewState folderContextMenuViewModel$ViewState) {
        invoke2(folderContextMenuViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FolderContextMenuViewModel$ViewState folderContextMenuViewModel$ViewState) {
        m.checkNotNullParameter(folderContextMenuViewModel$ViewState, "p1");
        WidgetFolderContextMenu.access$configureUI((WidgetFolderContextMenu) this.receiver, folderContextMenuViewModel$ViewState);
    }
}
