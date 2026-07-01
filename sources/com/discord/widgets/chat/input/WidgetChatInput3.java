package com.discord.widgets.chat.input;

import com.discord.databinding.WidgetChatInputBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$binding$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput3 extends FunctionReferenceImpl implements Function1<WidgetChatInputBinding, Unit> {
    public WidgetChatInput3(WidgetChatInput widgetChatInput) {
        super(1, widgetChatInput, WidgetChatInput.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetChatInputBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatInputBinding widgetChatInputBinding) {
        invoke2(widgetChatInputBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatInputBinding widgetChatInputBinding) {
        Intrinsics3.checkNotNullParameter(widgetChatInputBinding, "p1");
        ((WidgetChatInput) this.receiver).onViewBindingDestroy(widgetChatInputBinding);
    }
}
