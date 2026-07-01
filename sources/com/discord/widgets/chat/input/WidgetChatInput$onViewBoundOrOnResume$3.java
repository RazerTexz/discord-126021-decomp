package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$onViewBoundOrOnResume$3 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$onViewBoundOrOnResume$3(WidgetChatInput widgetChatInput) {
        super(1);
        this.this$0 = widgetChatInput;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetChatInput.access$setWindowInsetsListeners(this.this$0, !z2);
    }
}
