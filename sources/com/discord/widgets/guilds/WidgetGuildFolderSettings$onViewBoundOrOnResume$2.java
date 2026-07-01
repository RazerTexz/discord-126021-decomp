package com.discord.widgets.guilds;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildFolderSettings$onViewBoundOrOnResume$2 extends k implements Function1<WidgetGuildFolderSettingsViewModel$Event, Unit> {
    public WidgetGuildFolderSettings$onViewBoundOrOnResume$2(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel$Event widgetGuildFolderSettingsViewModel$Event) {
        invoke2(widgetGuildFolderSettingsViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildFolderSettingsViewModel$Event widgetGuildFolderSettingsViewModel$Event) {
        m.checkNotNullParameter(widgetGuildFolderSettingsViewModel$Event, "p1");
        WidgetGuildFolderSettings.access$handleEvent((WidgetGuildFolderSettings) this.receiver, widgetGuildFolderSettingsViewModel$Event);
    }
}
