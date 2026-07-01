package com.discord.stores;

import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions$observeMessageReactions$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ MessageReactionEmoji $emoji;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessageReactions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$observeMessageReactions$1(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        super(0);
        this.this$0 = storeMessageReactions;
        this.$channelId = j;
        this.$messageId = j2;
        this.$emoji = messageReactionEmoji;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessageReactions.access$fetchReactions(this.this$0, this.$channelId, this.$messageId, this.$emoji);
    }
}
