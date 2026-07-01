package com.discord.widgets.channels.settings;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$viewModel$2 extends o implements Function0<WidgetThreadSettingsViewModel> {
    public final /* synthetic */ WidgetThreadSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettings$viewModel$2(WidgetThreadSettings widgetThreadSettings) {
        super(0);
        this.this$0 = widgetThreadSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadSettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadSettingsViewModel invoke() {
        return new WidgetThreadSettingsViewModel(this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L));
    }
}
