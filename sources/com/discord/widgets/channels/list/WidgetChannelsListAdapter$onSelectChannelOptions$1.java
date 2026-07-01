package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onSelectChannelOptions$1 extends o implements Function1<Channel, Unit> {
    public static final WidgetChannelsListAdapter$onSelectChannelOptions$1 INSTANCE = new WidgetChannelsListAdapter$onSelectChannelOptions$1();

    public WidgetChannelsListAdapter$onSelectChannelOptions$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
    }
}
