package com.discord.widgets.chat.input;

import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageResendCompressedHandler$1$1 extends o implements Function1<List<? extends Attachment<?>>, Unit> {
    public final /* synthetic */ ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$messageResendCompressedHandler$1$1(ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 chatInputViewModel$sendMessage$messageResendCompressedHandler$1) {
        super(1);
        this.this$0 = chatInputViewModel$sendMessage$messageResendCompressedHandler$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends Attachment<?>> list) {
        m.checkNotNullParameter(list, "compressedAttachments");
        ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 chatInputViewModel$sendMessage$messageResendCompressedHandler$1 = this.this$0;
        chatInputViewModel$sendMessage$messageResendCompressedHandler$1.this$0.sendMessage(chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$context, chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$messageManager, chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$messageContent, list, true, chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$onValidationResult);
    }
}
