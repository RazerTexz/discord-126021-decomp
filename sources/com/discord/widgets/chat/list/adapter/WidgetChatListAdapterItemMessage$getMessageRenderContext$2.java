package com.discord.widgets.chat.list.adapter;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$getMessageRenderContext$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage$getMessageRenderContext$2(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "url");
        WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0).getEventHandler().onUrlLongClicked(str);
    }
}
