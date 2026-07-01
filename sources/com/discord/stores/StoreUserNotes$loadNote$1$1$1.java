package com.discord.stores;

import com.discord.models.domain.ModelUserNote;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserNotes$loadNote$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelUserNote $note;
    public final /* synthetic */ StoreUserNotes$loadNote$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserNotes$loadNote$1$1$1(StoreUserNotes$loadNote$1$1 storeUserNotes$loadNote$1$1, ModelUserNote modelUserNote) {
        super(0);
        this.this$0 = storeUserNotes$loadNote$1$1;
        this.$note = modelUserNote;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserNotes.access$handleRequestUserNoteSuccess(this.this$0.this$0.this$0, this.$note);
    }
}
