package com.discord.widgets.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMuteSettingsSheet$bindSubscriptions$3 extends k implements Function1<MuteSettingsSheetViewModel$Event, Unit> {
    public WidgetMuteSettingsSheet$bindSubscriptions$3(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel$Event muteSettingsSheetViewModel$Event) {
        invoke2(muteSettingsSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MuteSettingsSheetViewModel$Event muteSettingsSheetViewModel$Event) {
        m.checkNotNullParameter(muteSettingsSheetViewModel$Event, "p1");
        WidgetMuteSettingsSheet.access$handleEvent((WidgetMuteSettingsSheet) this.receiver, muteSettingsSheetViewModel$Event);
    }
}
