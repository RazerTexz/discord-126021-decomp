package com.discord.stores;

import com.discord.api.user.TypingUser;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$handleTypingStart$1 extends o implements Function1<TypingUser, Unit> {
    public final /* synthetic */ StoreUserTyping this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserTyping$handleTypingStart$1(StoreUserTyping storeUserTyping) {
        super(1);
        this.this$0 = storeUserTyping;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
        invoke2(typingUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TypingUser typingUser) {
        StoreUserTyping.access$getDispatcher$p(this.this$0).schedule(new StoreUserTyping$handleTypingStart$1$1(this, typingUser));
    }
}
