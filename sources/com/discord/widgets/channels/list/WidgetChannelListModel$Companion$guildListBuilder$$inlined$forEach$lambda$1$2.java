package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1$2 extends o implements Function0<Boolean> {
    public final /* synthetic */ boolean $channelSelected;
    public final /* synthetic */ boolean $isMuted;
    public final /* synthetic */ int $mentionCount;
    public final /* synthetic */ Channel $textChannel;
    public final /* synthetic */ long $textChannelId;
    public final /* synthetic */ boolean $unread;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1$2(WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, int i, Channel channel, boolean z2, boolean z3, boolean z4, long j) {
        super(0);
        this.this$0 = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1;
        this.$mentionCount = i;
        this.$textChannel = channel;
        this.$channelSelected = z2;
        this.$isMuted = z3;
        this.$unread = z4;
        this.$textChannelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        boolean z2 = this.$mentionCount <= 0;
        boolean zContains = this.this$0.$collapsedCategories$inlined.contains(Long.valueOf(this.$textChannel.getParentId()));
        boolean z3 = !(this.$channelSelected || this.this$0.$areAnyChildThreadsSelected$5$inlined.invoke(this.$textChannel.getId())) && this.this$0.$areAllChildThreadsRead$4$inlined.invoke(this.$textChannel.getId()) && ((zContains && z2 && (this.this$0.$isCategoryMuted || this.$isMuted || !this.$unread)) || (this.$isMuted && this.this$0.$guild$inlined.getHideMutedChannels()));
        if (z3) {
            this.this$0.$hiddenChannelsIds$inlined.add(Long.valueOf(this.$textChannelId));
        }
        return z3;
    }
}
