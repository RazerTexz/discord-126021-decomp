package com.discord.widgets.guilds.contextmenu;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFolderContextMenu$onResume$2 extends k implements Function1<FolderContextMenuViewModel$Event, Unit> {
    public WidgetFolderContextMenu$onResume$2(WidgetFolderContextMenu widgetFolderContextMenu) {
        super(1, widgetFolderContextMenu, WidgetFolderContextMenu.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel$Event folderContextMenuViewModel$Event) {
        invoke2(folderContextMenuViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FolderContextMenuViewModel$Event folderContextMenuViewModel$Event) {
        m.checkNotNullParameter(folderContextMenuViewModel$Event, "p1");
        WidgetFolderContextMenu.access$handleEvent((WidgetFolderContextMenu) this.receiver, folderContextMenuViewModel$Event);
    }
}
