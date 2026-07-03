package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onSelectChannelOptions$1 extends AbstractC12240o implements Function1<Channel, Unit> {
    public static final WidgetChannelsListAdapter$onSelectChannelOptions$1 INSTANCE = new WidgetChannelsListAdapter$onSelectChannelOptions$1();

    public WidgetChannelsListAdapter$onSelectChannelOptions$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        C12238m.checkNotNullParameter(channel, "it");
    }
}
