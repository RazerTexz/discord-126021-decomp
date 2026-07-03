package com.discord.widgets.chat.input;

import com.discord.widgets.chat.input.ChatInputViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$onMessageTooLong$1 extends AbstractC12240o implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ ChatInputViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$onMessageTooLong$1(ChatInputViewModel chatInputViewModel) {
        super(2);
        this.this$0 = chatInputViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.f27425a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void invoke(int i, int i2) {
        this.this$0.eventSubject.f27650k.onNext((T) new ChatInputViewModel.Event.MessageTooLong(i, i2));
    }
}
