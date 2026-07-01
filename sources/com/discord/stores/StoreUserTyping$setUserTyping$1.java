package com.discord.stores;

import com.discord.models.domain.ModelTypingResponse;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$setUserTyping$1 extends o implements Function1<ModelTypingResponse, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreUserTyping this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserTyping$setUserTyping$1(StoreUserTyping storeUserTyping, long j) {
        super(1);
        this.this$0 = storeUserTyping;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelTypingResponse modelTypingResponse) {
        invoke2(modelTypingResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelTypingResponse modelTypingResponse) {
        Long threadCreateCooldownMs;
        Long messageSendCooldownMs;
        long jLongValue = (modelTypingResponse == null || (messageSendCooldownMs = modelTypingResponse.getMessageSendCooldownMs()) == null) ? 0L : messageSendCooldownMs.longValue();
        if (jLongValue > 0) {
            StoreUserTyping.access$getDispatcher$p(this.this$0).schedule(new StoreUserTyping$setUserTyping$1$1(this, jLongValue));
        }
        long jLongValue2 = (modelTypingResponse == null || (threadCreateCooldownMs = modelTypingResponse.getThreadCreateCooldownMs()) == null) ? 0L : threadCreateCooldownMs.longValue();
        if (jLongValue2 > 0) {
            StoreUserTyping.access$getDispatcher$p(this.this$0).schedule(new StoreUserTyping$setUserTyping$1$2(this, jLongValue2));
        }
    }
}
