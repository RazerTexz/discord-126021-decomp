package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$handleTypingStart$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Subscription $subscription;
    public final /* synthetic */ StoreUserTyping$handleTypingStart$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserTyping$handleTypingStart$2$1(StoreUserTyping$handleTypingStart$2 storeUserTyping$handleTypingStart$2, Subscription subscription) {
        super(0);
        this.this$0 = storeUserTyping$handleTypingStart$2;
        this.$subscription = subscription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map map = (Map) StoreUserTyping.access$getTypingUsersRemoveCallbacks$p(this.this$0.this$0).get(Long.valueOf(this.this$0.$channelId));
        if (map != null) {
        }
    }
}
