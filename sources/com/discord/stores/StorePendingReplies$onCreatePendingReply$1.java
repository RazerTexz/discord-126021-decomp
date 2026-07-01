package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.MessageReference;
import com.discord.models.message.Message;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePendingReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePendingReplies$onCreatePendingReply$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ boolean $shouldMention;
    public final /* synthetic */ boolean $showMentionToggle;
    public final /* synthetic */ StorePendingReplies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePendingReplies$onCreatePendingReply$1(StorePendingReplies storePendingReplies, Channel channel, Message message, boolean z2, boolean z3) {
        super(0);
        this.this$0 = storePendingReplies;
        this.$channel = channel;
        this.$message = message;
        this.$shouldMention = z2;
        this.$showMentionToggle = z3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StorePendingReplies.access$getPendingReplies$p(this.this$0).put(Long.valueOf(this.$channel.getId()), new StorePendingReplies$PendingReply(new MessageReference(ChannelUtils.B(this.$channel) ? null : Long.valueOf(this.$channel.getGuildId()), Long.valueOf(this.$channel.getId()), Long.valueOf(this.$message.getId())), this.$message, this.$shouldMention, this.$showMentionToggle));
        this.this$0.markChanged();
    }
}
