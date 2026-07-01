package com.discord.widgets.chat.input.attachments;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AttachmentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentBottomSheet$onViewCreated$3 implements View$OnClickListener {
    public final /* synthetic */ AttachmentBottomSheet this$0;

    public AttachmentBottomSheet$onViewCreated$3(AttachmentBottomSheet attachmentBottomSheet) {
        this.this$0 = attachmentBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function0 function0Access$getOnFileRemoved$p = AttachmentBottomSheet.access$getOnFileRemoved$p(this.this$0);
        if (function0Access$getOnFileRemoved$p != null) {
        }
        this.this$0.dismiss();
    }
}
