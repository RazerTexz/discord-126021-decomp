package com.discord.widgets.guilds.join;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetGuildWelcomeSheetViewModel> {
    public final /* synthetic */ WidgetGuildWelcomeSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheet$viewModel$2(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        super(0);
        this.this$0 = widgetGuildWelcomeSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildWelcomeSheetViewModel invoke() {
        return new WidgetGuildWelcomeSheetViewModel(this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, 2, null);
    }
}
