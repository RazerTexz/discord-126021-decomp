package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class BillingFlowParams$a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2002b;
    public int c = 0;
    public ArrayList<SkuDetails> d;

    @NonNull
    public BillingFlowParams a() {
        ArrayList<SkuDetails> arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalArgumentException("SkuDetails must be provided.");
        }
        ArrayList<SkuDetails> arrayList2 = this.d;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (arrayList2.get(i) == null) {
                throw new IllegalArgumentException("SKU cannot be null.");
            }
            i = i2;
        }
        if (this.d.size() > 1) {
            SkuDetails skuDetails = this.d.get(0);
            String strE = skuDetails.e();
            ArrayList<SkuDetails> arrayList3 = this.d;
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                SkuDetails skuDetails2 = arrayList3.get(i3);
                if (!strE.equals("play_pass_subs") && !skuDetails2.e().equals("play_pass_subs") && !strE.equals(skuDetails2.e())) {
                    throw new IllegalArgumentException("SKUs should have the same type.");
                }
            }
            String strF = skuDetails.f();
            ArrayList<SkuDetails> arrayList4 = this.d;
            int size3 = arrayList4.size();
            for (int i4 = 0; i4 < size3; i4++) {
                SkuDetails skuDetails3 = arrayList4.get(i4);
                if (!strE.equals("play_pass_subs") && !skuDetails3.e().equals("play_pass_subs") && !strF.equals(skuDetails3.f())) {
                    throw new IllegalArgumentException("All SKUs must have the same package name.");
                }
            }
        }
        BillingFlowParams billingFlowParams = new BillingFlowParams(null);
        billingFlowParams.a = true ^ this.d.get(0).f().isEmpty();
        billingFlowParams.f2001b = this.a;
        billingFlowParams.d = null;
        billingFlowParams.c = this.f2002b;
        billingFlowParams.e = this.c;
        billingFlowParams.f = this.d;
        billingFlowParams.g = false;
        return billingFlowParams;
    }
}
