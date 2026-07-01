package com.discord.stores;

import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$resendApplicationCommand$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ String $nonce;
    public final /* synthetic */ ApplicationCommandLocalSendData $updatedSendData;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$resendApplicationCommand$1(StoreApplicationInteractions storeApplicationInteractions, Message message, String str, ApplicationCommandLocalSendData applicationCommandLocalSendData) {
        super(0);
        this.this$0 = storeApplicationInteractions;
        this.$message = message;
        this.$nonce = str;
        this.$updatedSendData = applicationCommandLocalSendData;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationInteractions.access$getStoreMessages$p(this.this$0).deleteLocalMessage(this.$message.getChannelId(), this.$nonce);
        StoreApplicationInteractions.handleSendApplicationCommandRequest$default(this.this$0, this.$updatedSendData, null, null, null, 14, null);
        StoreApplicationInteractions.access$removeApplicationCommandSendData(this.this$0, this.$nonce);
    }
}
