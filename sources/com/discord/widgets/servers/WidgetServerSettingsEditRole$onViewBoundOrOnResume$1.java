package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEditRole$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsEditRole$Model, Unit> {
    public WidgetServerSettingsEditRole$onViewBoundOrOnResume$1(WidgetServerSettingsEditRole widgetServerSettingsEditRole) {
        super(1, widgetServerSettingsEditRole, WidgetServerSettingsEditRole.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        invoke2(widgetServerSettingsEditRole$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        WidgetServerSettingsEditRole.access$configureUI((WidgetServerSettingsEditRole) this.receiver, widgetServerSettingsEditRole$Model);
    }
}
