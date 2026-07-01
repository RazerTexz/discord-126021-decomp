package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArchivedThreadsStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArchivedThreadsStore$fetchListing$1$3 extends o implements Function0<Unit> {
    public final /* synthetic */ ArchivedThreadsStore$fetchListing$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchivedThreadsStore$fetchListing$1$3(ArchivedThreadsStore$fetchListing$1 archivedThreadsStore$fetchListing$1) {
        super(0);
        this.this$0 = archivedThreadsStore$fetchListing$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function0 function0 = this.this$0.$onTerminated;
        if (function0 != null) {
        }
    }
}
