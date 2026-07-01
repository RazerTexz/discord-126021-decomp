package com.discord.widgets.channels.list;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$bindSubscriptions$1 extends o implements Function1<WidgetChannelsListItemThreadActions$Model, Unit> {
    public final /* synthetic */ WidgetChannelsListItemThreadActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListItemThreadActions$bindSubscriptions$1(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions) {
        super(1);
        this.this$0 = widgetChannelsListItemThreadActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        invoke2(widgetChannelsListItemThreadActions$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        WidgetChannelsListItemThreadActions.access$configureUI(this.this$0, widgetChannelsListItemThreadActions$Model);
    }
}
