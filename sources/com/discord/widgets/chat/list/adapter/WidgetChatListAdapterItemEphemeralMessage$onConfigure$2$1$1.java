package com.discord.widgets.chat.list.adapter;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1 extends o implements Function2<String, View, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1(WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1 widgetChatListAdapterItemEphemeralMessage$onConfigure$2$1) {
        super(2);
        this.this$0 = widgetChatListAdapterItemEphemeralMessage$onConfigure$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, View view) {
        invoke2(str, view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, View view) {
        m.checkNotNullParameter(str, "<anonymous parameter 0>");
        m.checkNotNullParameter(view, "<anonymous parameter 1>");
        WidgetChatListAdapterItemEphemeralMessage.access$getAdapter$p(this.this$0.this$0.this$0).getEventHandler().onDismissClicked(this.this$0.this$0.$message);
    }
}
