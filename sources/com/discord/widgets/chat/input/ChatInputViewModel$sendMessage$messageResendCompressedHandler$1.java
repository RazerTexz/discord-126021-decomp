package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageResendCompressedHandler$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ ChatInputViewModel.AttachmentContext $attachmentsContext;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ MessageContent $messageContent;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ Function1 $onValidationResult;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$messageResendCompressedHandler$1$1 */
    /* JADX INFO: compiled from: ChatInputViewModel.kt */
    public static final class C76961 extends AbstractC12240o implements Function1<List<? extends Attachment<?>>, Unit> {
        public C76961() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list) {
            C12238m.checkNotNullParameter(list, "compressedAttachments");
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
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SendUtils.INSTANCE.compressImageAttachments(this.$context, this.$attachmentsContext.getAttachments(), new C76961());
    }
}
