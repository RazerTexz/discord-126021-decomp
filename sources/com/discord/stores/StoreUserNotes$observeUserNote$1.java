package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserNotes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserNotes$observeUserNote$1 extends o implements Function0<StoreUserNotes$UserNoteState> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreUserNotes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserNotes$observeUserNote$1(StoreUserNotes storeUserNotes, long j) {
        super(0);
        this.this$0 = storeUserNotes;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreUserNotes$UserNoteState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreUserNotes$UserNoteState invoke() {
        StoreUserNotes$UserNoteState storeUserNotes$UserNoteState = this.this$0.getNotesByUserId().get(Long.valueOf(this.$userId));
        return storeUserNotes$UserNoteState != null ? storeUserNotes$UserNoteState : StoreUserNotes$UserNoteState$Loading.INSTANCE;
    }
}
