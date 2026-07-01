package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StorePinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePinnedMessages$loadPinnedMessages$2 extends o implements Function1<List<? extends Message>, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePinnedMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePinnedMessages$loadPinnedMessages$2(StorePinnedMessages storePinnedMessages, long j) {
        super(1);
        this.this$0 = storePinnedMessages;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
        invoke2((List<Message>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Message> list) {
        this.this$0.getDispatcher().schedule(new StorePinnedMessages$loadPinnedMessages$2$1(this, list));
    }
}
