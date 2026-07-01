package com.discord.widgets.status;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicatorViewModel$1 extends k implements Function1<WidgetGlobalStatusIndicatorViewModel$StoreState, Unit> {
    public WidgetGlobalStatusIndicatorViewModel$1(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
        super(1, widgetGlobalStatusIndicatorViewModel, WidgetGlobalStatusIndicatorViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorViewModel$StoreState widgetGlobalStatusIndicatorViewModel$StoreState) {
        invoke2(widgetGlobalStatusIndicatorViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorViewModel$StoreState widgetGlobalStatusIndicatorViewModel$StoreState) {
        m.checkNotNullParameter(widgetGlobalStatusIndicatorViewModel$StoreState, "p1");
        WidgetGlobalStatusIndicatorViewModel.access$handleStoreState((WidgetGlobalStatusIndicatorViewModel) this.receiver, widgetGlobalStatusIndicatorViewModel$StoreState);
    }
}
