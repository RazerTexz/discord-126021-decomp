package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$onConfigure$6 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage$onConfigure$6(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Message message) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
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
        WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0).getEventHandler().onMessageAuthorLongClicked(this.$message, Long.valueOf(WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0).getData().getGuildId()));
    }
}
