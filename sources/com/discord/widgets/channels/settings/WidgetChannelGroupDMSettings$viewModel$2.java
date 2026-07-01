package com.discord.widgets.channels.settings;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$viewModel$2 extends o implements Function0<ChannelGroupDMSettingsViewModel> {
    public final /* synthetic */ WidgetChannelGroupDMSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelGroupDMSettings$viewModel$2(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        super(0);
        this.this$0 = widgetChannelGroupDMSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChannelGroupDMSettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChannelGroupDMSettingsViewModel invoke() {
        return new ChannelGroupDMSettingsViewModel(this.this$0.getMostRecentIntent().getLongExtra("INTENT_EXTRA_CHANNEL_ID", 0L), null, null, null, 14, null);
    }
}
