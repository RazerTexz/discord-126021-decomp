package com.discord.widgets.guilds.contextmenu;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class FolderContextMenuViewModel$1 extends k implements Function1<FolderContextMenuViewModel$StoreState, Unit> {
    public FolderContextMenuViewModel$1(FolderContextMenuViewModel folderContextMenuViewModel) {
        super(1, folderContextMenuViewModel, FolderContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FolderContextMenuViewModel$StoreState folderContextMenuViewModel$StoreState) {
        invoke2(folderContextMenuViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FolderContextMenuViewModel$StoreState folderContextMenuViewModel$StoreState) {
        m.checkNotNullParameter(folderContextMenuViewModel$StoreState, "p1");
        FolderContextMenuViewModel.access$handleStoreState((FolderContextMenuViewModel) this.receiver, folderContextMenuViewModel$StoreState);
    }
}
