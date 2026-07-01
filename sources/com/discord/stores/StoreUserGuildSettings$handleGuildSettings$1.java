package com.discord.stores;

import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$handleGuildSettings$1 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ StoreUserGuildSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserGuildSettings$handleGuildSettings$1(StoreUserGuildSettings storeUserGuildSettings) {
        super(1);
        this.this$0 = storeUserGuildSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        Subscription subscriptionAccess$getRecomputeSettingsSubscription$p = StoreUserGuildSettings.access$getRecomputeSettingsSubscription$p(this.this$0);
        if (subscriptionAccess$getRecomputeSettingsSubscription$p != null) {
            subscriptionAccess$getRecomputeSettingsSubscription$p.unsubscribe();
        }
        StoreUserGuildSettings.access$setRecomputeSettingsSubscription$p(this.this$0, subscription);
    }
}
