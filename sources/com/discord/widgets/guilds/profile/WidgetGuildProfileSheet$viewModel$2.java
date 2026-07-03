package com.discord.widgets.guilds.profile;

import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetGuildProfileSheetViewModel> {
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$viewModel$2(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        super(0);
        this.this$0 = widgetGuildProfileSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildProfileSheetViewModel invoke() {
        return new WidgetGuildProfileSheetViewModel(null, null, this.this$0.getArgumentsOrDefault().getBoolean("com.discord.intent.extra.EXTRA_VIEWING_GUILD"), null, null, null, this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), null, Opcodes.NEW, null);
    }
}
