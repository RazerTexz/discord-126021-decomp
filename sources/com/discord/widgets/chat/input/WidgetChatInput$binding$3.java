package com.discord.widgets.chat.input;

import com.discord.databinding.WidgetChatInputBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput$binding$3 extends k implements Function1<WidgetChatInputBinding, Unit> {
    public WidgetChatInput$binding$3(WidgetChatInput widgetChatInput) {
        super(1, widgetChatInput, WidgetChatInput.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChatInputBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatInputBinding widgetChatInputBinding) {
        invoke2(widgetChatInputBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatInputBinding widgetChatInputBinding) {
        m.checkNotNullParameter(widgetChatInputBinding, "p1");
        WidgetChatInput.access$onViewBindingDestroy((WidgetChatInput) this.receiver, widgetChatInputBinding);
    }
}
