package com.discord.widgets.channels.settings;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$saveChannel$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTextChannelSettings$saveChannel$1(WidgetTextChannelSettings widgetTextChannelSettings) {
        super(1);
        this.this$0 = widgetTextChannelSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Context context = this.this$0.getContext();
        m.checkNotNullExpressionValue(channel, "it");
        b.a.d.m.g(context, ChannelUtils.k(channel) ? 2131887473 : 2131887605, 0, null, 12);
    }
}
