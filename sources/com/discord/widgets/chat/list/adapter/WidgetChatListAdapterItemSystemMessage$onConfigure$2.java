package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.models.message.Message;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$onConfigure$2(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage, Message message) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSystemMessage;
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapter$EventHandler eventHandler = WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getEventHandler();
        Message message = this.$message;
        LinkifiedTextView linkifiedTextView = WidgetChatListAdapterItemSystemMessage.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.systemText");
        CharSequence text = linkifiedTextView.getText();
        m.checkNotNullExpressionValue(text, "binding.systemText.text");
        eventHandler.onMessageLongClicked(message, text, false);
    }
}
