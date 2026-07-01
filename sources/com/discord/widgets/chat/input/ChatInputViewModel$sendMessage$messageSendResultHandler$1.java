package com.discord.widgets.chat.input;

import android.content.Context;
import com.discord.models.guild.Guild;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$CaptchaRequired;
import com.discord.utilities.messagesend.MessageResult$UnknownFailure;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageSendResultHandler$1 extends o implements Function2<MessageResult, Guild, Unit> {
    public final /* synthetic */ ChatInputViewModel$AttachmentContext $attachmentsContext;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isThreadDraft;
    public final /* synthetic */ ChatInputViewModel$ViewState$Loaded $loadedViewState;
    public final /* synthetic */ Function0 $messageResendCompressedHandler;
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$messageSendResultHandler$1(ChatInputViewModel chatInputViewModel, Context context, ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded, ChatInputViewModel$AttachmentContext chatInputViewModel$AttachmentContext, Function0 function0, boolean z2) {
        super(2);
        this.this$0 = chatInputViewModel;
        this.$context = context;
        this.$loadedViewState = chatInputViewModel$ViewState$Loaded;
        this.$attachmentsContext = chatInputViewModel$AttachmentContext;
        this.$messageResendCompressedHandler = function0;
        this.$isThreadDraft = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult, Guild guild) {
        invoke2(messageResult, guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult, Guild guild) {
        m.checkNotNullParameter(messageResult, "messageResult");
        if (messageResult instanceof MessageResult$CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageResult$CaptchaRequired) messageResult);
        } else if (messageResult instanceof MessageResult$UnknownFailure) {
            SendUtils.INSTANCE.handleSendError(((MessageResult$UnknownFailure) messageResult).getError(), this.$context, new ChatInputViewModel$sendMessage$messageSendResultHandler$1$1(this, guild), new ChatInputViewModel$sendMessage$messageSendResultHandler$1$2(this));
        } else if (this.$isThreadDraft) {
            ChatInputViewModel.access$getStoreThreadDraft$p(this.this$0).clearDraftState();
        }
    }
}
