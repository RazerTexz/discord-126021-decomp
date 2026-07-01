package com.discord.widgets.chat.list;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog$viewModel$2 extends o implements Function0<PublishActionDialogViewModel> {
    public final /* synthetic */ PublishActionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialog$viewModel$2(PublishActionDialog publishActionDialog) {
        super(0);
        this.this$0 = publishActionDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PublishActionDialogViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PublishActionDialogViewModel invoke() {
        return new PublishActionDialogViewModel(PublishActionDialog.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), PublishActionDialog.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
