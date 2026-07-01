package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$jumpToMessage$5 extends o implements Function1<Message, Unit> {
    public final /* synthetic */ StoreMessagesLoader$jumpToMessage$1 $handleTargetChannelSelected$1;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$jumpToMessage$5(StoreMessagesLoader storeMessagesLoader, StoreMessagesLoader$jumpToMessage$1 storeMessagesLoader$jumpToMessage$1) {
        super(1);
        this.this$0 = storeMessagesLoader;
        this.$handleTargetChannelSelected$1 = storeMessagesLoader$jumpToMessage$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Message message) {
        invoke2(message);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Message message) {
        StoreMessagesLoader.access$getDispatcher$p(this.this$0).schedule(new StoreMessagesLoader$jumpToMessage$5$1(this, message));
    }
}
