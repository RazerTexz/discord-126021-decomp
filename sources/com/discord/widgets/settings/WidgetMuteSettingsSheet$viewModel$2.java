package com.discord.widgets.settings;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet$viewModel$2 extends AbstractC12240o implements Function0<MuteSettingsSheetViewModel> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet$viewModel$2(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(0);
        this.this$0 = widgetMuteSettingsSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MuteSettingsSheetViewModel invoke() {
        return new MuteSettingsSheetViewModel(this.this$0.getArgumentsOrDefault().getLong("ARG_GUILD_ID", 0L), this.this$0.getArgumentsOrDefault().getLong("ARG_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
