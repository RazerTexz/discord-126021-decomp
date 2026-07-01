package com.discord.utilities.billing;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GooglePlayBillingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayBillingManager$onBillingServiceDisconnected$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ long $currentBackoffTimeMs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GooglePlayBillingManager$onBillingServiceDisconnected$1(long j) {
        super(1);
        this.$currentBackoffTimeMs = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
        if (GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).d()) {
            return;
        }
        GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).h(googlePlayBillingManager);
        GooglePlayBillingManager.access$getBackoffTimeMs$p(googlePlayBillingManager).set(this.$currentBackoffTimeMs * ((long) 2));
    }
}
