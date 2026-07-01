package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MessageContent $messageContent;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ Function1 $onValidationResult;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$messageResendCompressedHandler$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Attachment<?>>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list) {
            Intrinsics3.checkNotNullParameter(list, "compressedAttachments");
            ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 chatInputViewModel$sendMessage$messageResendCompressedHandler$1 = ChatInputViewModel$sendMessage$messageResendCompressedHandler$1.this;
            chatInputViewModel$sendMessage$messageResendCompressedHandler$1.this$0.sendMessage(chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$context, chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$messageManager, chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$messageContent, list, true, chatInputViewModel$sendMessage$messageResendCompressedHandler$1.$onValidationResult);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$messageResendCompressedHandler$1(ChatInputViewModel chatInputViewModel, Context context, ChatInputViewModel.AttachmentContext attachmentContext, MessageManager messageManager, MessageContent messageContent, Function1 function1) {
        super(0);
        this.this$0 = chatInputViewModel;
        this.$context = context;
        this.$attachmentsContext = attachmentContext;
        this.$messageManager = messageManager;
        this.$messageContent = messageContent;
        this.$onValidationResult = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SendUtils.INSTANCE.compressImageAttachments(this.$context, this.$attachmentsContext.getAttachments(), new AnonymousClass1());
    }
}
