package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettings$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettings$Model, Unit> {
    public WidgetServerSettings$onViewBoundOrOnResume$1(WidgetServerSettings widgetServerSettings) {
        super(1, widgetServerSettings, WidgetServerSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettings$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettings$Model widgetServerSettings$Model) {
        invoke2(widgetServerSettings$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettings$Model widgetServerSettings$Model) {
        WidgetServerSettings.access$configureUI((WidgetServerSettings) this.receiver, widgetServerSettings$Model);
    }
}
