package com.discord.widgets.voice.fullscreen;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetGuildCallOnboardingSheetViewModel> {
    public final /* synthetic */ WidgetGuildCallOnboardingSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheet$viewModel$2(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        super(0);
        this.this$0 = widgetGuildCallOnboardingSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildCallOnboardingSheetViewModel invoke() {
        return new WidgetGuildCallOnboardingSheetViewModel(this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), null, null, null, null, null, 62, null);
    }
}
