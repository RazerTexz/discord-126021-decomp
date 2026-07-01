package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePendingReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePendingReplies$onDeletePendingReply$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePendingReplies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePendingReplies$onDeletePendingReply$1(StorePendingReplies storePendingReplies, long j) {
        super(0);
        this.this$0 = storePendingReplies;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StorePendingReplies.access$getPendingReplies$p(this.this$0).remove(Long.valueOf(this.$channelId));
        this.this$0.markChanged();
    }
}
