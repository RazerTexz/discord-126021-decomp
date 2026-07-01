package com.discord.widgets.channels.settings;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings3 extends Lambda implements Function0<WidgetThreadSettingsViewModel> {
    public final /* synthetic */ WidgetThreadSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettings3(WidgetThreadSettings widgetThreadSettings) {
        super(0);
        this.this$0 = widgetThreadSettings;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadSettingsViewModel invoke() {
        return new WidgetThreadSettingsViewModel(this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L));
    }
}
