package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsModeration$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsModeration$Model, Unit> {
    public WidgetServerSettingsModeration$onViewBoundOrOnResume$1(WidgetServerSettingsModeration widgetServerSettingsModeration) {
        super(1, widgetServerSettingsModeration, WidgetServerSettingsModeration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsModeration$Model widgetServerSettingsModeration$Model) {
        invoke2(widgetServerSettingsModeration$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsModeration$Model widgetServerSettingsModeration$Model) {
        WidgetServerSettingsModeration.access$configureUI((WidgetServerSettingsModeration) this.receiver, widgetServerSettingsModeration$Model);
    }
}
