package com.discord.widgets.channels.threads.browser;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived$onViewBound$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetThreadBrowserArchived this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchived$onViewBound$2(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        super(1);
        this.this$0 = widgetThreadBrowserArchived;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        WidgetChannelsListItemThreadActions$Companion widgetChannelsListItemThreadActions$Companion = WidgetChannelsListItemThreadActions.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChannelsListItemThreadActions$Companion.show(parentFragmentManager, channel.getId());
    }
}
