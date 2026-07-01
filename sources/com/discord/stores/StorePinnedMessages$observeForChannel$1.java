package com.discord.stores;

import com.discord.models.message.Message;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePinnedMessages$observeForChannel$1 extends o implements Function0<List<? extends Message>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePinnedMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePinnedMessages$observeForChannel$1(StorePinnedMessages storePinnedMessages, long j) {
        super(0);
        this.this$0 = storePinnedMessages;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Message> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Message> invoke2() {
        List<? extends Message> list = (List) StorePinnedMessages.access$getPinnedMessages$p(this.this$0).get(Long.valueOf(this.$channelId));
        return list != null ? list : n.emptyList();
    }
}
