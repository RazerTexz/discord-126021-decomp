package com.discord.stores;

import com.discord.api.forum.ForumPostFirstMessage;
import com.discord.api.message.Message;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1 extends AbstractC12240o implements Function1<ForumPostFirstMessage, Message> {
    public static final StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1 INSTANCE = new StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1();

    public StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Message invoke(ForumPostFirstMessage forumPostFirstMessage) {
        C12238m.checkNotNullParameter(forumPostFirstMessage, "it");
        return forumPostFirstMessage.getFirstMessage();
    }
}
