package com.discord.widgets.chat.list.adapter;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage$configure$2 extends o implements Function1<WidgetChatListAdapterItemCallMessage$State, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemCallMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemCallMessage$configure$2(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        super(1);
        this.this$0 = widgetChatListAdapterItemCallMessage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemCallMessage$State widgetChatListAdapterItemCallMessage$State) {
        invoke2(widgetChatListAdapterItemCallMessage$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemCallMessage$State widgetChatListAdapterItemCallMessage$State) {
        m.checkNotNullParameter(widgetChatListAdapterItemCallMessage$State, "state");
        WidgetChatListAdapterItemCallMessage.access$handleState(this.this$0, widgetChatListAdapterItemCallMessage$State);
    }
}
