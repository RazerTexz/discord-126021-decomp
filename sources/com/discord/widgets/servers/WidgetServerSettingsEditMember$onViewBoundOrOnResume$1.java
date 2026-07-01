package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEditMember$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsEditMember$Model, Unit> {
    public WidgetServerSettingsEditMember$onViewBoundOrOnResume$1(WidgetServerSettingsEditMember widgetServerSettingsEditMember) {
        super(1, widgetServerSettingsEditMember, WidgetServerSettingsEditMember.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditMember$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        invoke2(widgetServerSettingsEditMember$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        WidgetServerSettingsEditMember.access$configureUI((WidgetServerSettingsEditMember) this.receiver, widgetServerSettingsEditMember$Model);
    }
}
