package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePendingReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePendingReplies$onSetPendingReplyShouldMention$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ boolean $shouldMention;
    public final /* synthetic */ StorePendingReplies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePendingReplies$onSetPendingReplyShouldMention$1(StorePendingReplies storePendingReplies, long j, boolean z2) {
        super(0);
        this.this$0 = storePendingReplies;
        this.$channelId = j;
        this.$shouldMention = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StorePendingReplies$PendingReply storePendingReplies$PendingReply = (StorePendingReplies$PendingReply) StorePendingReplies.access$getPendingReplies$p(this.this$0).get(Long.valueOf(this.$channelId));
        if (storePendingReplies$PendingReply != null) {
            StorePendingReplies.access$getPendingReplies$p(this.this$0).put(Long.valueOf(this.$channelId), StorePendingReplies$PendingReply.copy$default(storePendingReplies$PendingReply, null, null, this.$shouldMention, false, 11, null));
            this.this$0.markChanged();
        }
    }
}
