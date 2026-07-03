package com.discord.widgets.chat.list;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog$viewModel$2 extends AbstractC12240o implements Function0<PublishActionDialogViewModel> {
    public final /* synthetic */ PublishActionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialog$viewModel$2(PublishActionDialog publishActionDialog) {
        super(0);
        this.this$0 = publishActionDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PublishActionDialogViewModel invoke() {
        return new PublishActionDialogViewModel(this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
