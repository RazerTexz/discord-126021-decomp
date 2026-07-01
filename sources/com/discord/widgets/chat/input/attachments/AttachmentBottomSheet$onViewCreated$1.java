package com.discord.widgets.chat.input.attachments;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: AttachmentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AttachmentBottomSheet$onViewCreated$1 extends o implements Function4<Integer, Integer, Integer, Integer, Unit> {
    public final /* synthetic */ AttachmentBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttachmentBottomSheet$onViewCreated$1(AttachmentBottomSheet attachmentBottomSheet) {
        super(4);
        this.this$0 = attachmentBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
        invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2, int i3, int i4) {
        this.this$0.setAttachmentViewSize(Integer.valueOf(i));
        this.this$0.updateSpoilerViewSize();
    }
}
