package com.discord.widgets.channels.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadSettings$onViewBoundOrOnResume$1 extends k implements Function1<WidgetThreadSettingsViewModel$ViewState, Unit> {
    public WidgetThreadSettings$onViewBoundOrOnResume$1(WidgetThreadSettings widgetThreadSettings) {
        super(1, widgetThreadSettings, WidgetThreadSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel$ViewState widgetThreadSettingsViewModel$ViewState) {
        invoke2(widgetThreadSettingsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadSettingsViewModel$ViewState widgetThreadSettingsViewModel$ViewState) {
        m.checkNotNullParameter(widgetThreadSettingsViewModel$ViewState, "p1");
        WidgetThreadSettings.access$configureUI((WidgetThreadSettings) this.receiver, widgetThreadSettingsViewModel$ViewState);
    }
}
