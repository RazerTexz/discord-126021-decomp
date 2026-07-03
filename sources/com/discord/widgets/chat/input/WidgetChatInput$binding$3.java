package com.discord.widgets.chat.input;

import com.discord.databinding.WidgetChatInputBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput$binding$3 extends C12236k implements Function1<WidgetChatInputBinding, Unit> {
    public WidgetChatInput$binding$3(WidgetChatInput widgetChatInput) {
        super(1, widgetChatInput, WidgetChatInput.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChatInputBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatInputBinding widgetChatInputBinding) {
        invoke2(widgetChatInputBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatInputBinding widgetChatInputBinding) {
        C12238m.checkNotNullParameter(widgetChatInputBinding, "p1");
        ((WidgetChatInput) this.receiver).onViewBindingDestroy(widgetChatInputBinding);
    }
}
