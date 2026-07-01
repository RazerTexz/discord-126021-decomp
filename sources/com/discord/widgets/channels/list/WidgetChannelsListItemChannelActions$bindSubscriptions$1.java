package com.discord.widgets.channels.list;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$bindSubscriptions$1 extends o implements Function1<WidgetChannelsListItemChannelActions$Model, Unit> {
    public final /* synthetic */ WidgetChannelsListItemChannelActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListItemChannelActions$bindSubscriptions$1(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions) {
        super(1);
        this.this$0 = widgetChannelsListItemChannelActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelsListItemChannelActions$Model widgetChannelsListItemChannelActions$Model) {
        invoke2(widgetChannelsListItemChannelActions$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelsListItemChannelActions$Model widgetChannelsListItemChannelActions$Model) {
        WidgetChannelsListItemChannelActions.access$configureUI(this.this$0, widgetChannelsListItemChannelActions$Model);
    }
}
