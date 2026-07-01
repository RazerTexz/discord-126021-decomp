package com.discord.stores;

import com.discord.models.domain.ModelUserNote;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserNotes$loadNote$1$1 extends o implements Function1<ModelUserNote, Unit> {
    public final /* synthetic */ StoreUserNotes$loadNote$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserNotes$loadNote$1$1(StoreUserNotes$loadNote$1 storeUserNotes$loadNote$1) {
        super(1);
        this.this$0 = storeUserNotes$loadNote$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserNote modelUserNote) {
        invoke2(modelUserNote);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserNote modelUserNote) {
        m.checkNotNullParameter(modelUserNote, "note");
        StoreUserNotes.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreUserNotes$loadNote$1$1$1(this, modelUserNote));
    }
}
