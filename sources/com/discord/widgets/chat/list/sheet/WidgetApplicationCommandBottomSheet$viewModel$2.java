package com.discord.widgets.chat.list.sheet;

import android.os.Bundle;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$viewModel$2 extends o implements Function0<WidgetApplicationCommandBottomSheetViewModel> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet$viewModel$2(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet) {
        super(0);
        this.this$0 = widgetApplicationCommandBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetApplicationCommandBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetApplicationCommandBottomSheetViewModel invoke() {
        Bundle arguments;
        return new WidgetApplicationCommandBottomSheetViewModel(WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_INTERACTION_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), (!WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).containsKey("com.discord.intent.extra.EXTRA_GUILD_ID") || (arguments = this.this$0.getArguments()) == null) ? null : Long.valueOf(arguments.getLong("com.discord.intent.extra.EXTRA_GUILD_ID")), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_USER_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_APPLICATION_ID"), WidgetApplicationCommandBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE), null, 128, null);
    }
}
