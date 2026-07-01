package com.discord.stores;

import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$handleSendApplicationCommandRequest$1 extends o implements Function1<MessageResult, Unit> {
    public final /* synthetic */ ApplicationCommandLocalSendData $localSendData;
    public final /* synthetic */ Function1 $onFail;
    public final /* synthetic */ Function0 $onSuccess;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$handleSendApplicationCommandRequest$1(StoreApplicationInteractions storeApplicationInteractions, ApplicationCommandLocalSendData applicationCommandLocalSendData, Function0 function0, Function1 function1) {
        super(1);
        this.this$0 = storeApplicationInteractions;
        this.$localSendData = applicationCommandLocalSendData;
        this.$onSuccess = function0;
        this.$onFail = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult) {
        m.checkNotNullParameter(messageResult, "result");
        StoreApplicationInteractions.access$getDispatcher$p(this.this$0).schedule(new StoreApplicationInteractions$handleSendApplicationCommandRequest$1$1(this, messageResult));
    }
}
