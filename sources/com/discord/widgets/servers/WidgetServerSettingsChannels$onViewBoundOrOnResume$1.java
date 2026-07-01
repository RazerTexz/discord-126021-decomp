package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannels$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsChannels$Model, Unit> {
    public WidgetServerSettingsChannels$onViewBoundOrOnResume$1(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        super(1, widgetServerSettingsChannels, WidgetServerSettingsChannels.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) throws Exception {
        invoke2(widgetServerSettingsChannels$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) throws Exception {
        WidgetServerSettingsChannels.access$configureUI((WidgetServerSettingsChannels) this.receiver, widgetServerSettingsChannels$Model);
    }
}
