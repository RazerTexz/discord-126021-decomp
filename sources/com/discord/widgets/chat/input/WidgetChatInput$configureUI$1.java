package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureUI$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ChatInputViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureUI$1(WidgetChatInput widgetChatInput, ChatInputViewModel$ViewState chatInputViewModel$ViewState) {
        super(0);
        this.this$0 = widgetChatInput;
        this.$viewState = chatInputViewModel$ViewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetChatInputTruncatedHint widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p = WidgetChatInput.access$getChatInputTruncatedHint$p(this.this$0);
        if (widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p != null) {
            WidgetChatInput widgetChatInput = this.this$0;
            widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p.setHint(WidgetChatInput.access$getHint(widgetChatInput, widgetChatInput.requireContext(), ((ChatInputViewModel$ViewState$Loaded) this.$viewState).getChannel(), ((ChatInputViewModel$ViewState$Loaded) this.$viewState).isBlocked(), ((ChatInputViewModel$ViewState$Loaded) this.$viewState).getAbleToSendMessage()));
        }
        WidgetChatInput.access$configureSendListeners(this.this$0, (ChatInputViewModel$ViewState$Loaded) this.$viewState);
    }
}
