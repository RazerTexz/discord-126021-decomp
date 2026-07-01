package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.ChatInputViewModel;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendCommand$validated$3 extends Lambda implements Function2<Integer, Boolean, Unit> {
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ Function0 $commandResendCompressedHandler;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendCommand$validated$3(ChatInputViewModel chatInputViewModel, ChatInputViewModel.AttachmentContext attachmentContext, Function0 function0) {
        super(2);
        this.this$0 = chatInputViewModel;
        this.$attachmentsContext = attachmentContext;
        this.$commandResendCompressedHandler = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool) {
        invoke(num.intValue(), bool.booleanValue());
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void invoke(int i, boolean z2) {
        this.this$0.eventSubject.k.onNext((T) new ChatInputViewModel.Event.FilesTooLarge(i, this.$attachmentsContext.getCurrentFileSizeMB(), this.$attachmentsContext.getMaxAttachmentSizeMB(), z2, this.$attachmentsContext.getAttachments(), this.$attachmentsContext.getHasImage(), this.$attachmentsContext.getHasVideo(), this.$attachmentsContext.getHasGif(), this.$commandResendCompressedHandler));
    }
}
