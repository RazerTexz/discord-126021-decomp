package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExpandedGuildFolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpandedGuildFolders$openFolder$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $folderId;
    public final /* synthetic */ StoreExpandedGuildFolders this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExpandedGuildFolders$openFolder$1(StoreExpandedGuildFolders storeExpandedGuildFolders, long j) {
        super(0);
        this.this$0 = storeExpandedGuildFolders;
        this.$folderId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.handleFolderOpened(this.$folderId);
    }
}
