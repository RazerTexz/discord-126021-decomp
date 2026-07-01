package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePinnedMessages$loadPinnedMessages$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $it;
    public final /* synthetic */ StorePinnedMessages$loadPinnedMessages$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePinnedMessages$loadPinnedMessages$2$1(StorePinnedMessages$loadPinnedMessages$2 storePinnedMessages$loadPinnedMessages$2, List list) {
        super(0);
        this.this$0 = storePinnedMessages$loadPinnedMessages$2;
        this.$it = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StorePinnedMessages$loadPinnedMessages$2 storePinnedMessages$loadPinnedMessages$2 = this.this$0;
        StorePinnedMessages storePinnedMessages = storePinnedMessages$loadPinnedMessages$2.this$0;
        long j = storePinnedMessages$loadPinnedMessages$2.$channelId;
        List list = this.$it;
        m.checkNotNullExpressionValue(list, "it");
        StorePinnedMessages.access$handlePinnedMessagesLoaded(storePinnedMessages, j, list);
    }
}
