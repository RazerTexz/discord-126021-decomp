package com.discord.widgets.channels.threads.browser;

import com.discord.api.channel.Channel;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserActive$onViewBound$1 extends k implements Function1<Channel, Unit> {
    public WidgetThreadBrowserActive$onViewBound$1(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel) {
        super(1, widgetThreadBrowserViewModel, WidgetThreadBrowserViewModel.class, "openThread", "openThread(Lcom/discord/api/channel/Channel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "p1");
        ((WidgetThreadBrowserViewModel) this.receiver).openThread(channel);
    }
}
