package com.discord.stores;

import com.discord.api.forum.ForumPostFirstMessages;
import d0.f0.q;
import d0.t.u;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$fetchForumPosts$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ForumPostFirstMessages $response;
    public final /* synthetic */ StoreForumPostMessages$fetchForumPosts$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostMessages$fetchForumPosts$2$1(StoreForumPostMessages$fetchForumPosts$2 storeForumPostMessages$fetchForumPosts$2, ForumPostFirstMessages forumPostFirstMessages) {
        super(0);
        this.this$0 = storeForumPostMessages$fetchForumPosts$2;
        this.$response = forumPostFirstMessages;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.bulkCreateFirstMessage(q.toList(q.filterNotNull(q.map(u.asSequence(this.$response.a().values()), StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1.INSTANCE))));
    }
}
