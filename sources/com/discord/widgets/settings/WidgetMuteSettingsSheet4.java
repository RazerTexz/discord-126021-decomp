package com.discord.widgets.settings;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet4 extends Lambda implements Function0<MuteSettingsSheetViewModel> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet4(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(0);
        this.this$0 = widgetMuteSettingsSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MuteSettingsSheetViewModel invoke() {
        return new MuteSettingsSheetViewModel(this.this$0.getArgumentsOrDefault().getLong("ARG_GUILD_ID", 0L), this.this$0.getArgumentsOrDefault().getLong("ARG_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
