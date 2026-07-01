package com.discord.stores;

import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions$observeMessageReactions$2 extends o implements Function0<StoreMessageReactions$EmojiResults> {
    public final /* synthetic */ MessageReactionEmoji $emoji;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessageReactions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$observeMessageReactions$2(StoreMessageReactions storeMessageReactions, long j, MessageReactionEmoji messageReactionEmoji) {
        super(0);
        this.this$0 = storeMessageReactions;
        this.$messageId = j;
        this.$emoji = messageReactionEmoji;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreMessageReactions$EmojiResults invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreMessageReactions$EmojiResults invoke() {
        StoreMessageReactions$EmojiResults storeMessageReactions$EmojiResults;
        Map map = (Map) StoreMessageReactions.access$getReactionsSnapshot$p(this.this$0).get(Long.valueOf(this.$messageId));
        return (map == null || (storeMessageReactions$EmojiResults = (StoreMessageReactions$EmojiResults) map.get(this.$emoji.c())) == null) ? StoreMessageReactions$EmojiResults$Loading.INSTANCE : storeMessageReactions$EmojiResults;
    }
}
