package com.discord.widgets.guilds.profile;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$viewModel$2 extends Lambda implements Function0<WidgetGuildProfileSheetViewModel> {
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
