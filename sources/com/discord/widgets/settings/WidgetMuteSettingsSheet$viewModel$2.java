package com.discord.widgets.settings;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet$viewModel$2 extends o implements Function0<MuteSettingsSheetViewModel> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet$viewModel$2(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(0);
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MuteSettingsSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MuteSettingsSheetViewModel invoke() {
        return new MuteSettingsSheetViewModel(WidgetMuteSettingsSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID", 0L), WidgetMuteSettingsSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
