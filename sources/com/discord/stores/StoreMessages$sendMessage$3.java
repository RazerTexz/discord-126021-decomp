package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$3 extends o implements Function0<Unit> {
    public final /* synthetic */ Message $localMessage;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$3(StoreMessages storeMessages, Message message) {
        super(0);
        this.this$0 = storeMessages;
        this.$localMessage = message;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessages.access$handleLocalMessageCreate(this.this$0, this.$localMessage);
    }
}
