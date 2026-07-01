package com.discord.widgets.chat.input;

import d0.t.n;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$6 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChatInput$configureSendListeners$3 $trySend$3;
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$6(WidgetChatInput widgetChatInput, WidgetChatInput$configureSendListeners$3 widgetChatInput$configureSendListeners$3) {
        super(0);
        this.this$0 = widgetChatInput;
        this.$trySend$3 = widgetChatInput$configureSendListeners$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$trySend$3.invoke2(n.emptyList(), (Function1<? super Boolean, Unit>) new WidgetChatInput$configureSendListeners$6$1(this));
    }
}
