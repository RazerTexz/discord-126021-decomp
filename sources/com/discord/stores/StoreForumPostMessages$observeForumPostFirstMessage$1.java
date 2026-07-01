package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$observeForumPostFirstMessage$1 extends o implements Function0<Message> {
    public final /* synthetic */ long $postId;
    public final /* synthetic */ StoreForumPostMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostMessages$observeForumPostFirstMessage$1(StoreForumPostMessages storeForumPostMessages, long j) {
        super(0);
        this.this$0 = storeForumPostMessages;
        this.$postId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Message invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Message invoke() {
        return (Message) StoreForumPostMessages.access$getForumPostFirstMessageSnapshot$p(this.this$0).get(Long.valueOf(this.$postId));
    }
}
