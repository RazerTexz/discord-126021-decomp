package com.discord.stores;

import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$handleSendApplicationCommandRequest$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ MessageResult $result;
    public final /* synthetic */ StoreApplicationInteractions$handleSendApplicationCommandRequest$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$handleSendApplicationCommandRequest$1$1(StoreApplicationInteractions$handleSendApplicationCommandRequest$1 storeApplicationInteractions$handleSendApplicationCommandRequest$1, MessageResult messageResult) {
        super(0);
        this.this$0 = storeApplicationInteractions$handleSendApplicationCommandRequest$1;
        this.$result = messageResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationInteractions$handleSendApplicationCommandRequest$1 storeApplicationInteractions$handleSendApplicationCommandRequest$1 = this.this$0;
        StoreApplicationInteractions.access$handleApplicationCommandResult(storeApplicationInteractions$handleSendApplicationCommandRequest$1.this$0, this.$result, storeApplicationInteractions$handleSendApplicationCommandRequest$1.$localSendData, storeApplicationInteractions$handleSendApplicationCommandRequest$1.$onSuccess, storeApplicationInteractions$handleSendApplicationCommandRequest$1.$onFail);
    }
}
