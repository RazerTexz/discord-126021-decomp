package com.discord.stores;

import com.discord.api.forum.ForumPostFirstMessage;
import com.discord.api.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1 extends o implements Function1<ForumPostFirstMessage, Message> {
    public static final StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1 INSTANCE = new StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1();

    public StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Message invoke(ForumPostFirstMessage forumPostFirstMessage) {
        return invoke2(forumPostFirstMessage);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Message invoke2(ForumPostFirstMessage forumPostFirstMessage) {
        m.checkNotNullParameter(forumPostFirstMessage, "it");
        return forumPostFirstMessage.getFirstMessage();
    }
}
