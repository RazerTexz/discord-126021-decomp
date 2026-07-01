package com.discord.widgets.chat.list.actions;

import b.a.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageActionDialogs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageActionDialogs$showPinMessageConfirmation$1$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ MessageActionDialogs$showPinMessageConfirmation$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageActionDialogs$showPinMessageConfirmation$1$1(MessageActionDialogs$showPinMessageConfirmation$1 messageActionDialogs$showPinMessageConfirmation$1) {
        super(1);
        this.this$0 = messageActionDialogs$showPinMessageConfirmation$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r5) {
        MessageActionDialogs$showPinMessageConfirmation$1 messageActionDialogs$showPinMessageConfirmation$1 = this.this$0;
        m.g(messageActionDialogs$showPinMessageConfirmation$1.$context, messageActionDialogs$showPinMessageConfirmation$1.$isPinned ? 2131892979 : 2131892963, 0, null, 12);
        this.this$0.$onSuccess.invoke();
    }
}
