package com.discord.widgets.chat.input;

import com.discord.stores.StoreChat$Event;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChatInputViewModel$2 extends k implements Function1<StoreChat$Event, Unit> {
    public ChatInputViewModel$2(ChatInputViewModel chatInputViewModel) {
        super(1, chatInputViewModel, ChatInputViewModel.class, "handleStoreChatEvent", "handleStoreChatEvent(Lcom/discord/stores/StoreChat$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreChat$Event storeChat$Event) {
        invoke2(storeChat$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreChat$Event storeChat$Event) {
        m.checkNotNullParameter(storeChat$Event, "p1");
        ChatInputViewModel.access$handleStoreChatEvent((ChatInputViewModel) this.receiver, storeChat$Event);
    }
}
