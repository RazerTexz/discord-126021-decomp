package com.discord.widgets.guilds;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildFolderSettings$onViewBoundOrOnResume$1 extends k implements Function1<WidgetGuildFolderSettingsViewModel$ViewState, Unit> {
    public WidgetGuildFolderSettings$onViewBoundOrOnResume$1(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel$ViewState widgetGuildFolderSettingsViewModel$ViewState) {
        invoke2(widgetGuildFolderSettingsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildFolderSettingsViewModel$ViewState widgetGuildFolderSettingsViewModel$ViewState) {
        m.checkNotNullParameter(widgetGuildFolderSettingsViewModel$ViewState, "p1");
        WidgetGuildFolderSettings.access$configureUI((WidgetGuildFolderSettings) this.receiver, widgetGuildFolderSettingsViewModel$ViewState);
    }
}
