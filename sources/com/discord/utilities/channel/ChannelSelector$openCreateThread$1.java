package com.discord.utilities.channel;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$openCreateThread$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Long $parentMessageId;
    public final /* synthetic */ String $startThreadLocation;
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$openCreateThread$1(ChannelSelector channelSelector, long j, long j2, Long l, String str) {
        super(0);
        this.this$0 = channelSelector;
        this.$guildId = j;
        this.$channelId = j2;
        this.$parentMessageId = l;
        this.$startThreadLocation = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getStream().getThreadDraft().clearDraftState();
        this.this$0.getStream().getChannelsSelected().openCreateThread(this.$guildId, this.$channelId, this.$parentMessageId, this.$startThreadLocation);
        AnalyticsTracker.INSTANCE.threadCreationStarted(this.$channelId, this.$guildId, this.$startThreadLocation);
    }
}
