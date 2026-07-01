package com.discord.stores;

import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions$forceRetryFetchReactions$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ MessageReactionEmoji $emoji;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessageReactions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$forceRetryFetchReactions$1(StoreMessageReactions storeMessageReactions, long j, MessageReactionEmoji messageReactionEmoji, long j2) {
        super(0);
        this.this$0 = storeMessageReactions;
        this.$messageId = j;
        this.$emoji = messageReactionEmoji;
        this.$channelId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map map = (Map) StoreMessageReactions.access$getReactions$p(this.this$0).get(Long.valueOf(this.$messageId));
        if (map != null) {
        }
        StoreMessageReactions.access$fetchReactions(this.this$0, this.$channelId, this.$messageId, this.$emoji);
        this.this$0.markChanged();
    }
}
