package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReplies$observeMessageReferencesForChannel$1 extends o implements Function0<Map<Long, ? extends StoreMessageReplies$MessageState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreMessageReplies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReplies$observeMessageReferencesForChannel$1(StoreMessageReplies storeMessageReplies, long j) {
        super(0);
        this.this$0 = storeMessageReplies;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StoreMessageReplies$MessageState> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StoreMessageReplies$MessageState> invoke2() {
        return StoreMessageReplies.access$getCachedChannelMessages(this.this$0, this.$channelId);
    }
}
