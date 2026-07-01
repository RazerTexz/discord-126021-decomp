package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ Boolean $isParentMuted;
    public final /* synthetic */ Channel $textChannel;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1$1(WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, Channel channel, Boolean bool) {
        super(0);
        this.this$0 = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1;
        this.$textChannel = channel;
        this.$isParentMuted = bool;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Channel channel = StoreStream.Companion.getChannels().getChannel(this.$textChannel.getParentId());
        if (channel == null) {
            return true;
        }
        long id2 = channel.getId();
        Channel channel2 = this.this$0.$selectedChannel$inlined;
        boolean z2 = (channel2 != null && (id2 > channel2.getId() ? 1 : (id2 == channel2.getId() ? 0 : -1)) == 0) || this.this$0.$areAnyChildThreadsSelected$5$inlined.invoke(channel.getId());
        boolean zContains = this.this$0.$collapsedCategories$inlined.contains(Long.valueOf(channel.getParentId()));
        return this.this$0.$hiddenChannelsIds$inlined.contains(Long.valueOf(this.$textChannel.getParentId())) || (!z2 && !this.this$0.$isThreadUnread$3$inlined.invoke2(this.$textChannel) && (zContains || m.areEqual(this.$isParentMuted, Boolean.TRUE)));
    }
}
