package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager$createForumPostWithMessage$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ long $forumChannelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumPostCreateManager$createForumPostWithMessage$2(long j) {
        super(1);
        this.$forumChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        StoreStream.Companion.getSlowMode().onThreadCreated(this.$forumChannelId);
        ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), channel, null, null, 6, null);
    }
}
