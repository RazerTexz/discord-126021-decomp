package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePendingReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePendingReplies$observePendingReply$1 extends o implements Function0<StorePendingReplies$PendingReply> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePendingReplies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePendingReplies$observePendingReply$1(StorePendingReplies storePendingReplies, long j) {
        super(0);
        this.this$0 = storePendingReplies;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StorePendingReplies$PendingReply invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StorePendingReplies$PendingReply invoke() {
        return this.this$0.getPendingReply(this.$channelId);
    }
}
