package com.discord.widgets.chat.list.actions;

import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$CaptchaRequired;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$5$1 extends o implements Function1<MessageResult, Unit> {
    public static final WidgetChatListActions$configureUI$5$1 INSTANCE = new WidgetChatListActions$configureUI$5$1();

    public WidgetChatListActions$configureUI$5$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult) {
        m.checkNotNullParameter(messageResult, "messageResult");
        if (messageResult instanceof MessageResult$CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageResult$CaptchaRequired) messageResult);
        }
    }
}
