package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChat$setEditingMessage$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreChat$EditingMessage $editingMessage;
    public final /* synthetic */ StoreChat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChat$setEditingMessage$1(StoreChat storeChat, StoreChat$EditingMessage storeChat$EditingMessage) {
        super(0);
        this.this$0 = storeChat;
        this.$editingMessage = storeChat$EditingMessage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreChat.access$setEditingMessage$p(this.this$0, this.$editingMessage);
        this.this$0.markChanged();
    }
}
