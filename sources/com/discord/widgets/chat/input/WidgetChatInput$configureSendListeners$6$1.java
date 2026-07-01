package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$6$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetChatInput$configureSendListeners$6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$6$1(WidgetChatInput$configureSendListeners$6 widgetChatInput$configureSendListeners$6) {
        super(1);
        this.this$0 = widgetChatInput$configureSendListeners$6;
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
    }
}
