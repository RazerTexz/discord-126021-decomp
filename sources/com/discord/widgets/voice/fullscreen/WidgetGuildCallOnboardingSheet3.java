package com.discord.widgets.voice.fullscreen;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet3 extends Lambda implements Function0<WidgetGuildCallOnboardingSheetViewModel> {
    public final /* synthetic */ WidgetGuildCallOnboardingSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheet3(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        super(0);
        this.this$0 = widgetGuildCallOnboardingSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildCallOnboardingSheetViewModel invoke() {
        return new WidgetGuildCallOnboardingSheetViewModel(this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), null, null, null, null, null, 62, null);
    }
}
