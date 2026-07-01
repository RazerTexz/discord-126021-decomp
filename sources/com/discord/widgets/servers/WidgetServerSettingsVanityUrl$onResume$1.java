package com.discord.widgets.servers;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsVanityUrl$onResume$1 extends k implements Function1<WidgetServerSettingsVanityUrl$Model, Unit> {
    public WidgetServerSettingsVanityUrl$onResume$1(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        super(1, widgetServerSettingsVanityUrl, WidgetServerSettingsVanityUrl.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsVanityUrl$Model widgetServerSettingsVanityUrl$Model) {
        invoke2(widgetServerSettingsVanityUrl$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsVanityUrl$Model widgetServerSettingsVanityUrl$Model) {
        WidgetServerSettingsVanityUrl.access$configureUI((WidgetServerSettingsVanityUrl) this.receiver, widgetServerSettingsVanityUrl$Model);
    }
}
