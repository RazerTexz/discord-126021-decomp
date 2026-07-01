package com.discord.widgets.chat.input;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput$onViewBoundOrOnResume$1 extends k implements Function1<ChatInputViewModel$ViewState, Unit> {
    public WidgetChatInput$onViewBoundOrOnResume$1(WidgetChatInput widgetChatInput) {
        super(1, widgetChatInput, WidgetChatInput.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel$ViewState chatInputViewModel$ViewState) {
        invoke2(chatInputViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChatInputViewModel$ViewState chatInputViewModel$ViewState) {
        m.checkNotNullParameter(chatInputViewModel$ViewState, "p1");
        WidgetChatInput.access$configureUI((WidgetChatInput) this.receiver, chatInputViewModel$ViewState);
    }
}
