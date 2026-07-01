package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsRoles$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsRoles$Model, Unit> {
    public WidgetServerSettingsRoles$onViewBoundOrOnResume$1(WidgetServerSettingsRoles widgetServerSettingsRoles) {
        super(1, widgetServerSettingsRoles, WidgetServerSettingsRoles.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        invoke2(widgetServerSettingsRoles$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        WidgetServerSettingsRoles.access$configureUI((WidgetServerSettingsRoles) this.receiver, widgetServerSettingsRoles$Model);
    }
}
