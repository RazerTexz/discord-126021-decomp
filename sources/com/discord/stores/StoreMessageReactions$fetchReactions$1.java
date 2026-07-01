package com.discord.stores;

import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.user.User;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions$fetchReactions$1 extends o implements Function1<List<? extends User>, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ MessageReactionEmoji $emoji;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessageReactions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$fetchReactions$1(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        super(1);
        this.this$0 = storeMessageReactions;
        this.$channelId = j;
        this.$messageId = j2;
        this.$emoji = messageReactionEmoji;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends User> list) {
        invoke2((List<User>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<User> list) {
        m.checkNotNullParameter(list, "reactionUsers");
        StoreMessageReactions.access$getDispatcher$p(this.this$0).schedule(new StoreMessageReactions$fetchReactions$1$1(this, list));
    }
}
