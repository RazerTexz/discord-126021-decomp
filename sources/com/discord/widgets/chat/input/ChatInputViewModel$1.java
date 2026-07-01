package com.discord.widgets.chat.input;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChatInputViewModel$1 extends k implements Function1<ChatInputViewModel$StoreState, Unit> {
    public ChatInputViewModel$1(ChatInputViewModel chatInputViewModel) {
        super(1, chatInputViewModel, ChatInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel$StoreState chatInputViewModel$StoreState) {
        invoke2(chatInputViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChatInputViewModel$StoreState chatInputViewModel$StoreState) {
        m.checkNotNullParameter(chatInputViewModel$StoreState, "p1");
        ChatInputViewModel.access$handleStoreState((ChatInputViewModel) this.receiver, chatInputViewModel$StoreState);
    }
}
