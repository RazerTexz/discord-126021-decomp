package com.discord.stores;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$handleTypingStart$2 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreUserTyping this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserTyping$handleTypingStart$2(StoreUserTyping storeUserTyping, long j, long j2) {
        super(1);
        this.this$0 = storeUserTyping;
        this.$channelId = j;
        this.$userId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        StoreUserTyping.access$getDispatcher$p(this.this$0).schedule(new StoreUserTyping$handleTypingStart$2$1(this, subscription));
    }
}
