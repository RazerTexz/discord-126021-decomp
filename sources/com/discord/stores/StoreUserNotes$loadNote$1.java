package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserNotes$loadNote$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreUserNotes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserNotes$loadNote$1(StoreUserNotes storeUserNotes, long j) {
        super(0);
        this.this$0 = storeUserNotes;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreUserNotes.access$getNotesByUserId$p(this.this$0).containsKey(Long.valueOf(this.$userId))) {
            return;
        }
        StoreUserNotes.access$getNotesByUserId$p(this.this$0).put(Long.valueOf(this.$userId), StoreUserNotes$UserNoteState$Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreUserNotes.access$getRestAPI$p(this.this$0).getUserNote(this.$userId), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreUserNotes$loadNote$1$2(this), (Function0) null, (Function0) null, new StoreUserNotes$loadNote$1$1(this), 54, (Object) null);
    }
}
