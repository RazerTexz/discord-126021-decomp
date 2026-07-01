package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.AttachmentEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$configureUI$3 extends o implements Function1<View, Unit> {
    public final /* synthetic */ AttachmentEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemAttachment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAttachment$configureUI$3(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment, AttachmentEntry attachmentEntry) {
        super(1);
        this.this$0 = widgetChatListAdapterItemAttachment;
        this.$data = attachmentEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapter$EventHandler eventHandler = WidgetChatListAdapterItemAttachment.access$getAdapter$p(this.this$0).getEventHandler();
        Message message = this.$data.getMessage();
        String content = this.$data.getMessage().getContent();
        if (content == null) {
            content = "";
        }
        eventHandler.onMessageLongClicked(message, content, this.$data.isThreadStarterMessage());
    }
}
