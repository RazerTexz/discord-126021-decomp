package com.discord.stores;

import com.discord.api.user.TypingUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$handleTypingStart$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ TypingUser $prevTyping;
    public final /* synthetic */ StoreUserTyping$handleTypingStart$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserTyping$handleTypingStart$1$1(StoreUserTyping$handleTypingStart$1 storeUserTyping$handleTypingStart$1, TypingUser typingUser) {
        super(0);
        this.this$0 = storeUserTyping$handleTypingStart$1;
        this.$prevTyping = typingUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserTyping storeUserTyping = this.this$0.this$0;
        TypingUser typingUser = this.$prevTyping;
        m.checkNotNullExpressionValue(typingUser, "prevTyping");
        StoreUserTyping.access$handleTypingStop(storeUserTyping, typingUser);
    }
}
