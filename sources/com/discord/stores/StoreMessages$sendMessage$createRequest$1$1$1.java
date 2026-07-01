package com.discord.stores;

import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$AutoModBlock;
import com.discord.utilities.messagesend.MessageResult$CaptchaRequired;
import com.discord.utilities.messagesend.MessageResult$NetworkFailure;
import com.discord.utilities.messagesend.MessageResult$RateLimited;
import com.discord.utilities.messagesend.MessageResult$Slowmode;
import com.discord.utilities.messagesend.MessageResult$Success;
import com.discord.utilities.messagesend.MessageResult$Timeout;
import com.discord.utilities.messagesend.MessageResult$UnknownFailure;
import com.discord.utilities.messagesend.MessageResult$UserCancelled;
import com.discord.utilities.messagesend.MessageResult$ValidationError;
import d0.t.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $isLastMessage;
    public final /* synthetic */ MessageResult $result;
    public final /* synthetic */ StoreMessages$sendMessage$createRequest$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$1$1$1(StoreMessages$sendMessage$createRequest$1$1 storeMessages$sendMessage$createRequest$1$1, boolean z2, MessageResult messageResult) {
        super(0);
        this.this$0 = storeMessages$sendMessage$createRequest$1$1;
        this.$isLastMessage = z2;
        this.$result = messageResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$isLastMessage) {
            StoreMessages$Companion.access$cancelBackgroundSendingWork(StoreMessages.Companion, StoreMessages.access$getContext$p(this.this$0.this$0.this$0));
        }
        MessageResult messageResult = this.$result;
        if (messageResult instanceof MessageResult$Success) {
            StoreMessages.access$getStream$p(this.this$0.this$0.this$0).getSlowMode().onMessageSent(((MessageResult$Success) this.$result).getMessage().getChannelId());
            this.this$0.this$0.this$0.handleMessageCreate(m.listOf(((MessageResult$Success) this.$result).getMessage()));
            Integer numRetries = this.this$0.this$0.$localMessage.getNumRetries();
            if ((numRetries != null ? numRetries.intValue() : 0) > 0) {
                StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$1 = this.this$0.this$0;
                StoreMessages.access$trackFailedLocalMessageResolved(storeMessages$sendMessage$createRequest$1.this$0, storeMessages$sendMessage$createRequest$1.$localMessage, FailedMessageResolutionType.RESENT);
            }
        } else if (messageResult instanceof MessageResult$Slowmode) {
            StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$2 = this.this$0.this$0;
            StoreMessages.access$handleSendMessageFailure(storeMessages$sendMessage$createRequest$2.this$0, storeMessages$sendMessage$createRequest$2.$localMessage);
            StoreMessages.access$getStream$p(this.this$0.this$0.this$0).getSlowMode().onCooldown(this.this$0.this$0.$localMessage.getChannelId(), ((MessageResult$Slowmode) this.$result).getCooldownMs(), StoreSlowMode$Type$MessageSend.INSTANCE);
        } else if (!(messageResult instanceof MessageResult$RateLimited)) {
            if (messageResult instanceof MessageResult$UserCancelled) {
                StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$3 = this.this$0.this$0;
                StoreMessages.access$handleLocalMessageDelete(storeMessages$sendMessage$createRequest$3.this$0, storeMessages$sendMessage$createRequest$3.$localMessage);
            } else if (messageResult instanceof MessageResult$CaptchaRequired) {
                StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$4 = this.this$0.this$0;
                StoreMessages.access$handleSendMessageCaptchaRequired(storeMessages$sendMessage$createRequest$4.this$0, storeMessages$sendMessage$createRequest$4.$localMessage);
            } else if (messageResult instanceof MessageResult$UnknownFailure) {
                StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$5 = this.this$0.this$0;
                StoreMessages.access$handleSendMessageFailure(storeMessages$sendMessage$createRequest$5.this$0, storeMessages$sendMessage$createRequest$5.$localMessage);
            } else if (messageResult instanceof MessageResult$ValidationError) {
                StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$6 = this.this$0.this$0;
                StoreMessages.access$handleSendMessageValidationError(storeMessages$sendMessage$createRequest$6.this$0, storeMessages$sendMessage$createRequest$6.$localMessage, ((MessageResult$ValidationError) messageResult).getMessage());
            } else if (!(messageResult instanceof MessageResult$NetworkFailure)) {
                if (messageResult instanceof MessageResult$Timeout) {
                    StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$7 = this.this$0.this$0;
                    StoreMessages.access$handleSendMessageFailure(storeMessages$sendMessage$createRequest$7.this$0, storeMessages$sendMessage$createRequest$7.$localMessage);
                } else if (messageResult instanceof MessageResult$AutoModBlock) {
                    StoreMessages$sendMessage$createRequest$1 storeMessages$sendMessage$createRequest$8 = this.this$0.this$0;
                    StoreMessages.handleSendMessageFailureAutoMod$default(storeMessages$sendMessage$createRequest$8.this$0, storeMessages$sendMessage$createRequest$8.$localMessage, null, 2, null);
                }
            }
        }
        this.this$0.$emitter.onNext(this.$result);
        this.this$0.$emitter.onCompleted();
    }
}
