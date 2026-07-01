package com.discord.utilities.billing;

import b.d.a.a.f;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GooglePlayBillingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayBillingManager$queryPurchases$1 implements f {
    public static final GooglePlayBillingManager$queryPurchases$1 INSTANCE = new GooglePlayBillingManager$queryPurchases$1();

    @Override // b.d.a.a.f
    public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
        m.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
        m.checkNotNullParameter(list, "purchasesList");
        StoreStream.Companion.getGooglePlayPurchases().processPurchases(list, "subs");
    }
}
