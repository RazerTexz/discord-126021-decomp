package com.discord.widgets.chat.input;

import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.MessageManager$AttachmentsRequest;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$sendMessage$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ MessageManager$AttachmentsRequest $attachmentsRequest;
    public final /* synthetic */ MessageContent $messageContent;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ Function2 $messageSendResultHandler;
    public final /* synthetic */ Function2 $onFilesTooLarge;
    public final /* synthetic */ Function2 $onMessageTooLong;
    public final /* synthetic */ Function1 $onValidationResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$sendMessage$1(MessageManager messageManager, MessageContent messageContent, MessageManager$AttachmentsRequest messageManager$AttachmentsRequest, Function2 function2, Function2 function3, Function2 function4, Function1 function1) {
        super(1);
        this.$messageManager = messageManager;
        this.$messageContent = messageContent;
        this.$attachmentsRequest = messageManager$AttachmentsRequest;
        this.$messageSendResultHandler = function2;
        this.$onMessageTooLong = function3;
        this.$onFilesTooLarge = function4;
        this.$onValidationResult = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        this.$onValidationResult.invoke(Boolean.valueOf(MessageManager.sendMessage$default(this.$messageManager, this.$messageContent.getTextContent(), this.$messageContent.getMentionedUsers(), this.$attachmentsRequest, Long.valueOf(j), null, false, this.$onMessageTooLong, this.$onFilesTooLarge, new ChatInputViewModel$sendMessage$sendMessage$1$synchronousValidationSucceeded$1(this), 48, null)));
    }
}
