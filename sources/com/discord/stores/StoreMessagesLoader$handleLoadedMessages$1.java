package com.discord.stores;

import com.discord.api.user.User;
import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$handleLoadedMessages$1 extends o implements Function1<StoreMessagesLoader$ChannelLoadedState, StoreMessagesLoader$ChannelLoadedState> {
    public final /* synthetic */ boolean $isAllLoaded;
    public final /* synthetic */ boolean $isAppendingTop;
    public final /* synthetic */ boolean $isInitial;
    public final /* synthetic */ List $messages;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$handleLoadedMessages$1(StoreMessagesLoader storeMessagesLoader, boolean z2, boolean z3, boolean z4, List list) {
        super(1);
        this.this$0 = storeMessagesLoader;
        this.$isInitial = z2;
        this.$isAppendingTop = z3;
        this.$isAllLoaded = z4;
        this.$messages = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessagesLoader$ChannelLoadedState invoke(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        return invoke2(storeMessagesLoader$ChannelLoadedState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader$ChannelLoadedState invoke2(StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState) {
        Object next;
        User author;
        m.checkNotNullParameter(storeMessagesLoader$ChannelLoadedState, "it");
        boolean zIsInitialMessagesLoaded = this.$isInitial ? true : storeMessagesLoader$ChannelLoadedState.isInitialMessagesLoaded();
        boolean zIsOldestMessagesLoaded = (this.$isInitial || this.$isAppendingTop) ? this.$isAllLoaded : storeMessagesLoader$ChannelLoadedState.isOldestMessagesLoaded();
        Iterator it = this.$messages.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            author = ((Message) next).getAuthor();
        } while (!(author != null && author.getId() == StoreMessagesLoader.access$getStream$p(this.this$0).getUsers().getMeSnapshot().getId()));
        Message message = (Message) next;
        return StoreMessagesLoader$ChannelLoadedState.copy$default(storeMessagesLoader$ChannelLoadedState, zIsInitialMessagesLoaded, zIsOldestMessagesLoaded, false, false, message != null ? Long.valueOf(message.getId()) : null, 8, null);
    }
}
