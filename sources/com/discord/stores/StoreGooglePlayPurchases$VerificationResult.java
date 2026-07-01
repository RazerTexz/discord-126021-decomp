package com.discord.stores;

import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams$VerifyPurchaseResponse;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGooglePlayPurchases$VerificationResult {
    private final RestAPIParams$VerifyPurchaseResponse apiResponse;
    private final Purchase purchase;

    public StoreGooglePlayPurchases$VerificationResult(Purchase purchase, RestAPIParams$VerifyPurchaseResponse restAPIParams$VerifyPurchaseResponse) {
        m.checkNotNullParameter(purchase, "purchase");
        this.purchase = purchase;
        this.apiResponse = restAPIParams$VerifyPurchaseResponse;
    }

    public static /* synthetic */ StoreGooglePlayPurchases$VerificationResult copy$default(StoreGooglePlayPurchases$VerificationResult storeGooglePlayPurchases$VerificationResult, Purchase purchase, RestAPIParams$VerifyPurchaseResponse restAPIParams$VerifyPurchaseResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            purchase = storeGooglePlayPurchases$VerificationResult.purchase;
        }
        if ((i & 2) != 0) {
            restAPIParams$VerifyPurchaseResponse = storeGooglePlayPurchases$VerificationResult.apiResponse;
        }
        return storeGooglePlayPurchases$VerificationResult.copy(purchase, restAPIParams$VerifyPurchaseResponse);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Purchase getPurchase() {
        return this.purchase;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RestAPIParams$VerifyPurchaseResponse getApiResponse() {
        return this.apiResponse;
    }

    public final StoreGooglePlayPurchases$VerificationResult copy(Purchase purchase, RestAPIParams$VerifyPurchaseResponse apiResponse) {
        m.checkNotNullParameter(purchase, "purchase");
        return new StoreGooglePlayPurchases$VerificationResult(purchase, apiResponse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGooglePlayPurchases$VerificationResult)) {
            return false;
        }
        StoreGooglePlayPurchases$VerificationResult storeGooglePlayPurchases$VerificationResult = (StoreGooglePlayPurchases$VerificationResult) other;
        return m.areEqual(this.purchase, storeGooglePlayPurchases$VerificationResult.purchase) && m.areEqual(this.apiResponse, storeGooglePlayPurchases$VerificationResult.apiResponse);
    }

    public final RestAPIParams$VerifyPurchaseResponse getApiResponse() {
        return this.apiResponse;
    }

    public final Purchase getPurchase() {
        return this.purchase;
    }

    public int hashCode() {
        Purchase purchase = this.purchase;
        int iHashCode = (purchase != null ? purchase.hashCode() : 0) * 31;
        RestAPIParams$VerifyPurchaseResponse restAPIParams$VerifyPurchaseResponse = this.apiResponse;
        return iHashCode + (restAPIParams$VerifyPurchaseResponse != null ? restAPIParams$VerifyPurchaseResponse.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VerificationResult(purchase=");
        sbU.append(this.purchase);
        sbU.append(", apiResponse=");
        sbU.append(this.apiResponse);
        sbU.append(")");
        return sbU.toString();
    }
}
