package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$7$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ Function1 $onSendResult;
    public final /* synthetic */ WidgetChatInput$configureSendListeners$7 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$7$1(WidgetChatInput$configureSendListeners$7 widgetChatInput$configureSendListeners$7, Function1 function1) {
        super(1);
        this.this$0 = widgetChatInput$configureSendListeners$7;
        this.$onSendResult = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        if (z2) {
            WidgetChatInput.clearInput$default(this.this$0.this$0, null, false, 3, null);
        }
        this.$onSendResult.invoke(Boolean.valueOf(z2));
    }
}
