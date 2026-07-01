package com.discord.stores;

import d0.z.d.o;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$enqueueForumPostFirstMessageFetch$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $parentChannelId;
    public final /* synthetic */ long $postId;
    public final /* synthetic */ StoreForumPostMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostMessages$enqueueForumPostFirstMessageFetch$1(StoreForumPostMessages storeForumPostMessages, long j, long j2) {
        super(0);
        this.this$0 = storeForumPostMessages;
        this.$postId = j;
        this.$parentChannelId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreForumPostMessages.access$hasForumPostFirstMessage(this.this$0, this.$postId) || StoreForumPostMessages.access$isFetchingForumPostFirstMessage(this.this$0, this.$postId) || StoreForumPostMessages.access$expectForumPostFirstMessageFromGateway(this.this$0, this.$postId)) {
            return;
        }
        Set linkedHashSet = (Set) StoreForumPostMessages.access$getForumPostFetchQueue$p(this.this$0).get(Long.valueOf(this.$parentChannelId));
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
        }
        linkedHashSet.add(Long.valueOf(this.$postId));
        StoreForumPostMessages.access$getForumPostFetchQueue$p(this.this$0).put(Long.valueOf(this.$parentChannelId), linkedHashSet);
    }
}
