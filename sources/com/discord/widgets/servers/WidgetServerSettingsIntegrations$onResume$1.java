package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsIntegrations$onResume$1 extends k implements Function1<WidgetServerSettingsIntegrations$Model, Unit> {
    public WidgetServerSettingsIntegrations$onResume$1(WidgetServerSettingsIntegrations widgetServerSettingsIntegrations) {
        super(1, widgetServerSettingsIntegrations, WidgetServerSettingsIntegrations.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsIntegrations$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsIntegrations$Model widgetServerSettingsIntegrations$Model) {
        invoke2(widgetServerSettingsIntegrations$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsIntegrations$Model widgetServerSettingsIntegrations$Model) {
        WidgetServerSettingsIntegrations.access$configureUI((WidgetServerSettingsIntegrations) this.receiver, widgetServerSettingsIntegrations$Model);
    }
}
