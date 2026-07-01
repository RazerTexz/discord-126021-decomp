package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$jumpToMessage$5$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ StoreMessagesLoader$jumpToMessage$5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$jumpToMessage$5$1(StoreMessagesLoader$jumpToMessage$5 storeMessagesLoader$jumpToMessage$5, Message message) {
        super(0);
        this.this$0 = storeMessagesLoader$jumpToMessage$5;
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.$handleTargetChannelSelected$1.invoke2(this.$message);
    }
}
