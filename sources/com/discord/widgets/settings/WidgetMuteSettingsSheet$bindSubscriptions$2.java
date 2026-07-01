package com.discord.widgets.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMuteSettingsSheet$bindSubscriptions$2 extends k implements Function1<MuteSettingsSheetViewModel$ViewState, Unit> {
    public WidgetMuteSettingsSheet$bindSubscriptions$2(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "updateViews", "updateViews(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel$ViewState muteSettingsSheetViewModel$ViewState) {
        invoke2(muteSettingsSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MuteSettingsSheetViewModel$ViewState muteSettingsSheetViewModel$ViewState) {
        m.checkNotNullParameter(muteSettingsSheetViewModel$ViewState, "p1");
        WidgetMuteSettingsSheet.access$updateViews((WidgetMuteSettingsSheet) this.receiver, muteSettingsSheetViewModel$ViewState);
    }
}
