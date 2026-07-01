package com.discord.stores;

import android.content.Context;
import com.discord.restapi.RestAPIParams$ChannelMessagesAck;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreMessageAck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageAck$postPendingAck$1 extends o implements Function1<StoreMessageAck$PendingAck, Unit> {
    public final /* synthetic */ int $mentionCount;
    public final /* synthetic */ StoreMessageAck this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageAck$postPendingAck$1(StoreMessageAck storeMessageAck, int i) {
        super(1);
        this.this$0 = storeMessageAck;
        this.$mentionCount = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreMessageAck$PendingAck storeMessageAck$PendingAck) {
        invoke2(storeMessageAck$PendingAck);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreMessageAck$PendingAck storeMessageAck$PendingAck) {
        m.checkNotNullParameter(storeMessageAck$PendingAck, "pendingAck");
        long channelId = storeMessageAck$PendingAck.getChannelId();
        StoreMessageAck$Ack ack = storeMessageAck$PendingAck.getAck();
        StoreMessageAck.access$getDispatcher$p(this.this$0).schedule(new StoreMessageAck$postPendingAck$1$1(this, channelId, ack));
        Observable observableU = ObservableExtensionsKt.restSubscribeOn$default(StoreMessageAck.access$getRestAPI$p(this.this$0).postChannelMessagesAck(channelId, Long.valueOf(ack.getMessageId()), new RestAPIParams$ChannelMessagesAck(Boolean.valueOf(ack.isLockedAck()), Integer.valueOf(this.$mentionCount))), false, 1, null).u(new StoreMessageAck$postPendingAck$1$2(channelId));
        m.checkNotNullExpressionValue(observableU, "restAPI\n          .postC…).ackMessage(channelId) }");
        ObservableExtensionsKt.appSubscribe$default(observableU, (Context) null, "REST: ack", (Function1) null, StoreMessageAck$postPendingAck$1$3.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
