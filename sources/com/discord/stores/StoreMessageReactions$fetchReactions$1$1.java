package com.discord.stores;

import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.user.User;
import com.discord.models.user.CoreUser;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions$fetchReactions$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $reactionUsers;
    public final /* synthetic */ StoreMessageReactions$fetchReactions$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$fetchReactions$1$1(StoreMessageReactions$fetchReactions$1 storeMessageReactions$fetchReactions$1, List list) {
        super(0);
        this.this$0 = storeMessageReactions$fetchReactions$1;
        this.$reactionUsers = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessageReactions$fetchReactions$1 storeMessageReactions$fetchReactions$1 = this.this$0;
        StoreMessageReactions storeMessageReactions = storeMessageReactions$fetchReactions$1.this$0;
        long j = storeMessageReactions$fetchReactions$1.$channelId;
        long j2 = storeMessageReactions$fetchReactions$1.$messageId;
        MessageReactionEmoji messageReactionEmoji = storeMessageReactions$fetchReactions$1.$emoji;
        List list = this.$reactionUsers;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CoreUser((User) it.next()));
        }
        StoreMessageReactions.access$handleReactionUsers(storeMessageReactions, j, j2, messageReactionEmoji, arrayList);
    }
}
