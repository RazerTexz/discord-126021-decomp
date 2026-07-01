package com.discord.utilities.rest;

import com.discord.stores.StoreStream;
import com.discord.utilities.messagesend.MessageResult$CaptchaRequired;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SendUtils$handleCaptchaRequired$2 extends o implements Function0<Unit> {
    public final /* synthetic */ MessageResult$CaptchaRequired $messageResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUtils$handleCaptchaRequired$2(MessageResult$CaptchaRequired messageResult$CaptchaRequired) {
        super(0);
        this.$messageResult = messageResult$CaptchaRequired;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getMessages().markMessageFailed(this.$messageResult.getChannelId(), this.$messageResult.getNonce());
    }
}
