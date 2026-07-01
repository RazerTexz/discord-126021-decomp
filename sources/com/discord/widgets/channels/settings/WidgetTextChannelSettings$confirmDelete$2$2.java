package com.discord.widgets.channels.settings;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$confirmDelete$2$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetTextChannelSettings$confirmDelete$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTextChannelSettings$confirmDelete$2$2(WidgetTextChannelSettings$confirmDelete$2 widgetTextChannelSettings$confirmDelete$2) {
        super(1);
        this.this$0 = widgetTextChannelSettings$confirmDelete$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Integer numB = ChannelUtils.b(channel);
        if (numB != null) {
            b.a.d.m.i(this.this$0.this$0, numB.intValue(), 0, 4);
        }
    }
}
