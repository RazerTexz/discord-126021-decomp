package com.discord.widgets.guilds.contextmenu;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FolderContextMenuViewModel$onMarkAsReadClicked$1 extends o implements Function1<List<Void>, Unit> {
    public final /* synthetic */ FolderContextMenuViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel$onMarkAsReadClicked$1(FolderContextMenuViewModel folderContextMenuViewModel) {
        super(1);
        this.this$0 = folderContextMenuViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<Void> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Void> list) {
        FolderContextMenuViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) FolderContextMenuViewModel$Event$Dismiss.INSTANCE);
    }
}
