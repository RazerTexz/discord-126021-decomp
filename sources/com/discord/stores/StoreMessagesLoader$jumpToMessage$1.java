package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$jumpToMessage$1 extends o implements Function1<Message, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$jumpToMessage$1(StoreMessagesLoader storeMessagesLoader, long j, long j2) {
        super(1);
        this.this$0 = storeMessagesLoader;
        this.$channelId = j;
        this.$messageId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Message message) {
        invoke2(message);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final synchronized void invoke2(Message message) {
        try {
            if (message != null) {
                StoreMessagesLoader.access$getScrollToSubject$p(this.this$0).k.onNext((T) Long.valueOf(message.getId()));
            } else {
                StoreMessagesLoader.access$channelLoadedStateUpdate(this.this$0, this.$channelId, StoreMessagesLoader$jumpToMessage$1$1.INSTANCE);
                StoreMessagesLoader.tryLoadMessages$default(this.this$0, 0L, true, false, false, Long.valueOf(this.$channelId), Long.valueOf(this.$messageId), 9, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
