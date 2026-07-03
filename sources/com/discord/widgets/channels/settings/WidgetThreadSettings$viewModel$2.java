package com.discord.widgets.channels.settings;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$viewModel$2 extends AbstractC12240o implements Function0<WidgetThreadSettingsViewModel> {
    public final /* synthetic */ WidgetThreadSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettings$viewModel$2(WidgetThreadSettings widgetThreadSettings) {
        super(0);
        this.this$0 = widgetThreadSettings;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadSettingsViewModel invoke() {
        return new WidgetThreadSettingsViewModel(this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L));
    }
}
