package com.discord.stores;

import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rx.Emitter;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$1$1 extends o implements Function2<MessageResult, Boolean, Unit> {
    public final /* synthetic */ Emitter $emitter;
    public final /* synthetic */ StoreMessages$sendMessage$createRequest$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$1$1(StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$1, Emitter emitter) {
        super(2);
        this.this$0 = storeMessages$sendMessage$createRequest$1;
        this.$emitter = emitter;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult, Boolean bool) {
        invoke(messageResult, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(MessageResult messageResult, boolean z2) {
        m.checkNotNullParameter(messageResult, "result");
        StoreMessages.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreMessages$sendMessage$createRequest$1$1$1(this, z2, messageResult));
    }
}
