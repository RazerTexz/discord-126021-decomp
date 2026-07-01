package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$3$3 extends o implements Function1<List<? extends Message>, Unit> {
    public final /* synthetic */ Long $after;
    public final /* synthetic */ Long $before;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Long $messageId;
    public final /* synthetic */ StoreMessagesLoader$tryLoadMessages$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$tryLoadMessages$3$3(StoreMessagesLoader$tryLoadMessages$3 storeMessagesLoader$tryLoadMessages$3, long j, Long l, Long l2, Long l3) {
        super(1);
        this.this$0 = storeMessagesLoader$tryLoadMessages$3;
        this.$channelId = j;
        this.$messageId = l;
        this.$before = l2;
        this.$after = l3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
        invoke2((List<Message>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Message> list) {
        StoreMessagesLoader storeMessagesLoader = this.this$0.this$0;
        m.checkNotNullExpressionValue(list, "it");
        long j = this.$channelId;
        Long l = this.$messageId;
        StoreMessagesLoader.access$handleLoadedMessages(storeMessagesLoader, list, j, l != null ? l.longValue() : 0L, this.$before, this.$after);
    }
}
