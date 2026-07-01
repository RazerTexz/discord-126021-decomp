package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember$onViewBound$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetCreateChannelAddMember this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannelAddMember$onViewBound$1(WidgetCreateChannelAddMember widgetCreateChannelAddMember) {
        super(1);
        this.this$0 = widgetCreateChannelAddMember;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        WidgetCreateChannelAddMember.access$configureUI(this.this$0, channel);
    }
}
