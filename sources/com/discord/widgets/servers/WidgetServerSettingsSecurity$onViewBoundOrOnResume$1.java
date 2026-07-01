package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsSecurity$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsSecurity$Model, Unit> {
    public WidgetServerSettingsSecurity$onViewBoundOrOnResume$1(WidgetServerSettingsSecurity widgetServerSettingsSecurity) {
        super(1, widgetServerSettingsSecurity, WidgetServerSettingsSecurity.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsSecurity$Model widgetServerSettingsSecurity$Model) {
        invoke2(widgetServerSettingsSecurity$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsSecurity$Model widgetServerSettingsSecurity$Model) {
        WidgetServerSettingsSecurity.access$configureUI((WidgetServerSettingsSecurity) this.receiver, widgetServerSettingsSecurity$Model);
    }
}
