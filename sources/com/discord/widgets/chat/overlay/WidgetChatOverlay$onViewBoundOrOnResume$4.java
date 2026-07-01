package com.discord.widgets.chat.overlay;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$onViewBoundOrOnResume$4 extends o implements Function1<ChatTypingModel, Unit> {
    public final /* synthetic */ WidgetChatOverlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatOverlay$onViewBoundOrOnResume$4(WidgetChatOverlay widgetChatOverlay) {
        super(1);
        this.this$0 = widgetChatOverlay;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChatTypingModel chatTypingModel) {
        invoke2(chatTypingModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChatTypingModel chatTypingModel) {
        WidgetChatOverlay$TypingIndicatorViewHolder widgetChatOverlay$TypingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p = WidgetChatOverlay.access$getTypingIndicatorViewHolder$p(this.this$0);
        m.checkNotNullExpressionValue(chatTypingModel, "it");
        widgetChatOverlay$TypingIndicatorViewHolderAccess$getTypingIndicatorViewHolder$p.configureUI(chatTypingModel);
    }
}
