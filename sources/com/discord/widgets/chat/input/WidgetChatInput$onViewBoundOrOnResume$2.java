package com.discord.widgets.chat.input;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatInput$onViewBoundOrOnResume$2 extends k implements Function1<ChatInputViewModel$Event, Unit> {
    public WidgetChatInput$onViewBoundOrOnResume$2(WidgetChatInput widgetChatInput) {
        super(1, widgetChatInput, WidgetChatInput.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel$Event chatInputViewModel$Event) {
        invoke2(chatInputViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChatInputViewModel$Event chatInputViewModel$Event) {
        m.checkNotNullParameter(chatInputViewModel$Event, "p1");
        WidgetChatInput.access$handleEvent((WidgetChatInput) this.receiver, chatInputViewModel$Event);
    }
}
