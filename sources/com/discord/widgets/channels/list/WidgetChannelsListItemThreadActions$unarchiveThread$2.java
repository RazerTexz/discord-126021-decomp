package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$unarchiveThread$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetChannelsListItemThreadActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListItemThreadActions$unarchiveThread$2(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions) {
        super(1);
        this.this$0 = widgetChannelsListItemThreadActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        this.this$0.dismiss();
    }
}
