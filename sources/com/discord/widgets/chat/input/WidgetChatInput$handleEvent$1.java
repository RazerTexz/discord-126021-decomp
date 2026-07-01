package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$handleEvent$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ChatInputViewModel$Event $event;
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$handleEvent$1(WidgetChatInput widgetChatInput, ChatInputViewModel$Event chatInputViewModel$Event) {
        super(0);
        this.this$0 = widgetChatInput;
        this.$event = chatInputViewModel$Event;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function0<Unit> onResendCompressed = ((ChatInputViewModel$Event$FilesTooLarge) this.$event).getOnResendCompressed();
        if (onResendCompressed != null) {
            onResendCompressed.invoke();
        }
        WidgetChatInput.clearInput$default(this.this$0, null, true, 1, null);
    }
}
