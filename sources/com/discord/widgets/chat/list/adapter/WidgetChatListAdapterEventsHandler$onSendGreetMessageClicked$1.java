package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1 extends o implements Function1<Message, Unit> {
    public static final WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1 INSTANCE = new WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1();

    public WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Message message) {
        invoke2(message);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Message message) {
        m.checkNotNullParameter(message, "it");
    }
}
