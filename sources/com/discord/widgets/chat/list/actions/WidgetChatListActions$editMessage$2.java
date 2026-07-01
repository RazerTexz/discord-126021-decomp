package com.discord.widgets.chat.list.actions;

import com.discord.models.message.Message;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreChat$EditingMessage;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$editMessage$2 extends o implements Function1<CharSequence, Unit> {
    public final /* synthetic */ Message $message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActions$editMessage$2(Message message) {
        super(1);
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
        invoke2(charSequence);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CharSequence charSequence) {
        StoreChat chat = StoreStream.Companion.getChat();
        Message message = this.$message;
        m.checkNotNullExpressionValue(charSequence, "unparsedMessageContent");
        chat.setEditingMessage(new StoreChat$EditingMessage(message, charSequence));
    }
}
