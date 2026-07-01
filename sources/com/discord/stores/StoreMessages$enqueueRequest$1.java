package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.messagesend.MessageQueue;
import com.discord.utilities.messagesend.MessageRequest;
import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$enqueueRequest$1<T> implements Action1<Emitter<MessageResult>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Function1 $createRequest;
    public final /* synthetic */ StoreMessages this$0;

    public StoreMessages$enqueueRequest$1(StoreMessages storeMessages, long j, Function1 function1) {
        this.this$0 = storeMessages;
        this.$channelId = j;
        this.$createRequest = function1;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<MessageResult> emitter) {
        call2(emitter);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<MessageResult> emitter) {
        MessageQueue messageQueueAccess$getOrCreateMessageQueue = StoreMessages.access$getOrCreateMessageQueue(this.this$0, this.$channelId);
        Function1 function1 = this.$createRequest;
        m.checkNotNullExpressionValue(emitter, "emitter");
        messageQueueAccess$getOrCreateMessageQueue.enqueue((MessageRequest) function1.invoke(emitter));
    }
}
