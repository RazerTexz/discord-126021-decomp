package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$2 extends o implements Function1<WidgetChannelTopicViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetChannelTopicViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel$2(WidgetChannelTopicViewModel widgetChannelTopicViewModel) {
        super(1);
        this.this$0 = widgetChannelTopicViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelTopicViewModel$StoreState widgetChannelTopicViewModel$StoreState) {
        invoke2(widgetChannelTopicViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelTopicViewModel$StoreState widgetChannelTopicViewModel$StoreState) {
        m.checkNotNullParameter(widgetChannelTopicViewModel$StoreState, "storeState");
        WidgetChannelTopicViewModel.access$handleStoreState(this.this$0, widgetChannelTopicViewModel$StoreState);
    }
}
