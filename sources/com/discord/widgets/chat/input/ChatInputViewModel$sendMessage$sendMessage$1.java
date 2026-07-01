package com.discord.widgets.chat.input;

import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import d0.t.Collections2;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$sendMessage$1 extends Lambda implements Function1<Long, Unit> {
    public final /* synthetic */ MessageManager.AttachmentsRequest $attachmentsRequest;
    public final /* synthetic */ MessageContent $messageContent;
    public final /* synthetic */ MessageManager $messageManager;
    public final /* synthetic */ Function2 $messageSendResultHandler;
    public final /* synthetic */ Function2 $onFilesTooLarge;
    public final /* synthetic */ Function2 $onMessageTooLong;
    public final /* synthetic */ Function1 $onValidationResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$sendMessage$1(MessageManager messageManager, MessageContent messageContent, MessageManager.AttachmentsRequest attachmentsRequest, Function2 function2, Function2 function3, Function2 function4, Function1 function1) {
        super(1);
        this.$messageManager = messageManager;
        this.$messageContent = messageContent;
        this.$attachmentsRequest = attachmentsRequest;
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
        MessageManager messageManager = this.$messageManager;
        this.$onValidationResult.invoke(Boolean.valueOf(messageManager.sendMessage((510 & 1) != 0 ? "" : this.$messageContent.getTextContent(), (510 & 2) != 0 ? null : this.$messageContent.getMentionedUsers(), (510 & 4) != 0 ? null : this.$attachmentsRequest, (510 & 8) != 0 ? null : Long.valueOf(j), (510 & 16) != 0 ? Collections2.emptyList() : null, (510 & 32) != 0, (510 & 64) != 0 ? null : this.$onMessageTooLong, (510 & 128) == 0 ? this.$onFilesTooLarge : null, (510 & 256) != 0 ? messageManager.defaultMessageResultHandler : new ChatInputViewModel$sendMessage$sendMessage$1$synchronousValidationSucceeded$1(this))));
    }
}
