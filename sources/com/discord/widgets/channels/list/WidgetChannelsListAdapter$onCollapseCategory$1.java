package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onCollapseCategory$1 extends Lambda implements Function2<Channel, Boolean, Unit> {
    public static final WidgetChannelsListAdapter$onCollapseCategory$1 INSTANCE = new WidgetChannelsListAdapter$onCollapseCategory$1();

    public WidgetChannelsListAdapter$onCollapseCategory$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel, Boolean bool) {
        invoke(channel, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Channel channel, boolean z2) {
        Intrinsics3.checkNotNullParameter(channel, "<anonymous parameter 0>");
    }
}
