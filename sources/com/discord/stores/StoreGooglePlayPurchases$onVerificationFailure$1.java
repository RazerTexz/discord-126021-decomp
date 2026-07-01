package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases$onVerificationFailure$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGooglePlayPurchases$VerificationResult $verificationResult;
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$onVerificationFailure$1(StoreGooglePlayPurchases storeGooglePlayPurchases, StoreGooglePlayPurchases$VerificationResult storeGooglePlayPurchases$VerificationResult) {
        super(0);
        this.this$0 = storeGooglePlayPurchases;
        this.$verificationResult = storeGooglePlayPurchases$VerificationResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ArrayList<String> arrayListB = this.$verificationResult.getPurchase().b();
        m.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
        for (String str : arrayListB) {
            PublishSubject publishSubjectAccess$getEventSubject$p = StoreGooglePlayPurchases.access$getEventSubject$p(this.this$0);
            m.checkNotNullExpressionValue(str, "sku");
            publishSubjectAccess$getEventSubject$p.k.onNext((T) new StoreGooglePlayPurchases$Event$PurchaseQueryFailure(str));
        }
        StoreGooglePlayPurchases.access$setQueryState$p(this.this$0, StoreGooglePlayPurchases$QueryState$NotInProgress.INSTANCE);
        this.this$0.markChanged();
    }
}
