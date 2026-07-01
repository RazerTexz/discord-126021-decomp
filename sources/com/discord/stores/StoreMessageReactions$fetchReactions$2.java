package com.discord.stores;

import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReactions$fetchReactions$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ MessageReactionEmoji $emoji;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ StoreMessageReactions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageReactions$fetchReactions$2(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        super(1);
        this.this$0 = storeMessageReactions;
        this.$channelId = j;
        this.$messageId = j2;
        this.$emoji = messageReactionEmoji;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreMessageReactions.access$getDispatcher$p(this.this$0).schedule(new StoreMessageReactions$fetchReactions$2$1(this));
    }
}
