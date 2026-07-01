package com.discord.stores;

import com.discord.api.forum.ForumPostFirstMessages;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$fetchForumPosts$2 extends o implements Function1<ForumPostFirstMessages, Unit> {
    public final /* synthetic */ StoreForumPostMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostMessages$fetchForumPosts$2(StoreForumPostMessages storeForumPostMessages) {
        super(1);
        this.this$0 = storeForumPostMessages;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ForumPostFirstMessages forumPostFirstMessages) {
        invoke2(forumPostFirstMessages);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ForumPostFirstMessages forumPostFirstMessages) {
        m.checkNotNullParameter(forumPostFirstMessages, "response");
        StoreForumPostMessages.access$getDispatcher$p(this.this$0).schedule(new StoreForumPostMessages$fetchForumPosts$2$1(this, forumPostFirstMessages));
    }
}
