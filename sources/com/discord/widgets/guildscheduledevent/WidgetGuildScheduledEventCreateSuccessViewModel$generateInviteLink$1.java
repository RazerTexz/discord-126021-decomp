package com.discord.widgets.guildscheduledevent;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccessViewModel$generateInviteLink$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccessViewModel$generateInviteLink$1(WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModel, Long l) {
        super(1);
        this.this$0 = widgetGuildScheduledEventCreateSuccessViewModel;
        this.$channelId = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Long lValueOf = this.$channelId;
        if (lValueOf == null) {
            lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
        }
        if (lValueOf != null) {
            WidgetGuildScheduledEventCreateSuccessViewModel.access$getInviteGenerator$p(this.this$0).generateForAppComponent(this.this$0, lValueOf.longValue());
        }
    }
}
