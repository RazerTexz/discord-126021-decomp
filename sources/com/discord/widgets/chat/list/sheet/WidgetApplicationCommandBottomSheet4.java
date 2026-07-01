package com.discord.widgets.chat.list.sheet;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet4 extends Lambda implements Function0<WidgetApplicationCommandBottomSheetViewModel> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet4(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet) {
        super(0);
        this.this$0 = widgetApplicationCommandBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetApplicationCommandBottomSheetViewModel invoke() {
        Bundle arguments;
        return new WidgetApplicationCommandBottomSheetViewModel(this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_INTERACTION_ID"), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID"), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), (!this.this$0.getArgumentsOrDefault().containsKey("com.discord.intent.extra.EXTRA_GUILD_ID") || (arguments = this.this$0.getArguments()) == null) ? null : Long.valueOf(arguments.getLong("com.discord.intent.extra.EXTRA_GUILD_ID")), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID"), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_APPLICATION_ID"), this.this$0.getArgumentsOrDefault().getString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE), null, 128, null);
    }
}
