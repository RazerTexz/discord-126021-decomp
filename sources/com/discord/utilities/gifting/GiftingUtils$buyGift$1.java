package com.discord.utilities.gifting;

import androidx.fragment.app.FragmentActivity;
import com.android.billingclient.api.BillingFlowParams;
import com.discord.utilities.billing.GooglePlayBillingManager;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GiftingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftingUtils$buyGift$1 extends o implements Function0<Unit> {
    public final /* synthetic */ FragmentActivity $activity;
    public final /* synthetic */ BillingFlowParams $billingParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftingUtils$buyGift$1(FragmentActivity fragmentActivity, BillingFlowParams billingFlowParams) {
        super(0);
        this.$activity = fragmentActivity;
        this.$billingParams = billingFlowParams;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
        if (googlePlayBillingManager.launchBillingFlow(this.$activity, this.$billingParams) == 7) {
            googlePlayBillingManager.queryPurchases();
        }
    }
}
