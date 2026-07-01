package com.discord.widgets.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettings$onViewBoundOrOnResume$1 extends k implements Function1<SettingsViewModel$ViewState, Unit> {
    public WidgetSettings$onViewBoundOrOnResume$1(WidgetSettings widgetSettings) {
        super(1, widgetSettings, WidgetSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/SettingsViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsViewModel$ViewState settingsViewModel$ViewState) {
        invoke2(settingsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsViewModel$ViewState settingsViewModel$ViewState) {
        m.checkNotNullParameter(settingsViewModel$ViewState, "p1");
        WidgetSettings.access$configureUI((WidgetSettings) this.receiver, settingsViewModel$ViewState);
    }
}
