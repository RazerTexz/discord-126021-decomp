package com.discord.widgets.announcements;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetChannelFollowSheetViewModel> {
    public final /* synthetic */ WidgetChannelFollowSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheet$viewModel$2(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        super(0);
        this.this$0 = widgetChannelFollowSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelFollowSheetViewModel invoke() {
        return new WidgetChannelFollowSheetViewModel(this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), null, null, null, 28, null);
    }
}
