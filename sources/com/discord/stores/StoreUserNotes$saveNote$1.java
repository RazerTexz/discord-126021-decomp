package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserNotes$saveNote$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ String $note;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreUserNotes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserNotes$saveNote$1(StoreUserNotes storeUserNotes, long j, String str) {
        super(1);
        this.this$0 = storeUserNotes;
        this.$userId = j;
        this.$note = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        StoreUserNotes.access$getDispatcher$p(this.this$0).schedule(new StoreUserNotes$saveNote$1$1(this));
    }
}
