package com.discord.widgets.chat.list;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog3 extends Lambda implements Function0<PublishActionDialogViewModel> {
    public final /* synthetic */ PublishActionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialog3(PublishActionDialog publishActionDialog) {
        super(0);
        this.this$0 = publishActionDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PublishActionDialogViewModel invoke() {
        return new PublishActionDialogViewModel(this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", 0L), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, null, 28, null);
    }
}
