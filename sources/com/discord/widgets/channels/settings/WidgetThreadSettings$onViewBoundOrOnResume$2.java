package com.discord.widgets.channels.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadSettings$onViewBoundOrOnResume$2 extends k implements Function1<WidgetThreadSettingsViewModel$Event, Unit> {
    public WidgetThreadSettings$onViewBoundOrOnResume$2(WidgetThreadSettings widgetThreadSettings) {
        super(1, widgetThreadSettings, WidgetThreadSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel$Event widgetThreadSettingsViewModel$Event) {
        invoke2(widgetThreadSettingsViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadSettingsViewModel$Event widgetThreadSettingsViewModel$Event) {
        m.checkNotNullParameter(widgetThreadSettingsViewModel$Event, "p1");
        WidgetThreadSettings.access$handleEvent((WidgetThreadSettings) this.receiver, widgetThreadSettingsViewModel$Event);
    }
}
