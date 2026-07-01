package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInputTruncatedHint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputTruncatedHint$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetChatInputTruncatedHint this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputTruncatedHint$1(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        super(1);
        this.this$0 = widgetChatInputTruncatedHint;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        if (WidgetChatInputTruncatedHint.access$getHintIsTruncated$p(this.this$0)) {
            return;
        }
        WidgetChatInputTruncatedHint.access$setPreviousMaxLines$p(this.this$0, i);
    }
}
