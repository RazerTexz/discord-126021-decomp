package com.discord.widgets.status;

import com.discord.databinding.WidgetGlobalStatusIndicatorBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicator$binding$3 extends k implements Function1<WidgetGlobalStatusIndicatorBinding, Unit> {
    public WidgetGlobalStatusIndicator$binding$3(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorBinding widgetGlobalStatusIndicatorBinding) {
        invoke2(widgetGlobalStatusIndicatorBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorBinding widgetGlobalStatusIndicatorBinding) {
        m.checkNotNullParameter(widgetGlobalStatusIndicatorBinding, "p1");
        WidgetGlobalStatusIndicator.access$onViewBindingDestroy((WidgetGlobalStatusIndicator) this.receiver, widgetGlobalStatusIndicatorBinding);
    }
}
