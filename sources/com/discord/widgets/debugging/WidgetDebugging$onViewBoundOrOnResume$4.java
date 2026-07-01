package com.discord.widgets.debugging;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDebugging$onViewBoundOrOnResume$4 extends k implements Function1<WidgetDebugging$Model, Unit> {
    public WidgetDebugging$onViewBoundOrOnResume$4(WidgetDebugging widgetDebugging) {
        super(1, widgetDebugging, WidgetDebugging.class, "configureUI", "configureUI(Lcom/discord/widgets/debugging/WidgetDebugging$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDebugging$Model widgetDebugging$Model) {
        invoke2(widgetDebugging$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDebugging$Model widgetDebugging$Model) {
        m.checkNotNullParameter(widgetDebugging$Model, "p1");
        WidgetDebugging.access$configureUI((WidgetDebugging) this.receiver, widgetDebugging$Model);
    }
}
