package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$onConfigure$4 extends o implements Function1<View, Unit> {
    public final /* synthetic */ boolean $isThreadStarterMessage;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage$onConfigure$4(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Message message, boolean z2) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$message = message;
        this.$isThreadStarterMessage = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0).getEventHandler().onMessageLongClicked(this.$message, WidgetChatListAdapterItemMessage.access$getItemText$p(this.this$0).getText().subSequence(0, Math.max(WidgetChatListAdapterItemMessage.access$getItemText$p(this.this$0).getText().length() - 1, 0)), this.$isThreadStarterMessage);
    }
}
