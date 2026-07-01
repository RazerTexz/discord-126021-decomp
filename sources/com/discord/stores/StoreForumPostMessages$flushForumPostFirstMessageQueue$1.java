package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$flushForumPostFirstMessageQueue$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $parentChannelId;
    public final /* synthetic */ StoreForumPostMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostMessages$flushForumPostFirstMessageQueue$1(StoreForumPostMessages storeForumPostMessages, long j) {
        super(0);
        this.this$0 = storeForumPostMessages;
        this.$parentChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreForumPostMessages.access$getForumPostRequestQueueProcessing$p(this.this$0)) {
            return;
        }
        StoreForumPostMessages.access$setForumPostRequestQueueProcessing$p(this.this$0, true);
        StoreForumPostMessages.access$flushForumPostFirstMessageQueueHelper(this.this$0, this.$parentChannelId);
    }
}
