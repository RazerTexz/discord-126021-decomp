package com.discord.widgets.chat.input.attachments;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AttachmentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentBottomSheet$onViewCreated$4 implements View$OnClickListener {
    public final /* synthetic */ AttachmentBottomSheet this$0;

    public AttachmentBottomSheet$onViewCreated$4(AttachmentBottomSheet attachmentBottomSheet) {
        this.this$0 = attachmentBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        boolean z2 = !AttachmentBottomSheet.access$isSpoiler$p(this.this$0);
        this.this$0.markSpoiler(z2);
        Function1 function1Access$getOnMarkSpoiler$p = AttachmentBottomSheet.access$getOnMarkSpoiler$p(this.this$0);
        if (function1Access$getOnMarkSpoiler$p != null) {
        }
    }
}
