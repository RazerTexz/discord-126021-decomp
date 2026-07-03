package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import p007b.p100d.p101a.p102a.C1630o;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class BillingFlowParams {

    /* JADX INFO: renamed from: a */
    public boolean f14546a;

    /* JADX INFO: renamed from: b */
    public String f14547b;

    /* JADX INFO: renamed from: c */
    public String f14548c;

    /* JADX INFO: renamed from: d */
    public String f14549d;

    /* JADX INFO: renamed from: e */
    public int f14550e = 0;

    /* JADX INFO: renamed from: f */
    public ArrayList<SkuDetails> f14551f;

    /* JADX INFO: renamed from: g */
    public boolean f14552g;

    /* JADX INFO: renamed from: com.android.billingclient.api.BillingFlowParams$a */
    /* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
    public static class C5412a {

        /* JADX INFO: renamed from: a */
        public String f14553a;

        /* JADX INFO: renamed from: b */
        public String f14554b;

        /* JADX INFO: renamed from: c */
        public int f14555c = 0;

        /* JADX INFO: renamed from: d */
        public ArrayList<SkuDetails> f14556d;

        @NonNull
        /* JADX INFO: renamed from: a */
        public BillingFlowParams m7495a() {
            ArrayList<SkuDetails> arrayList = this.f14556d;
            if (arrayList == null || arrayList.isEmpty()) {
                throw new IllegalArgumentException("SkuDetails must be provided.");
            }
            ArrayList<SkuDetails> arrayList2 = this.f14556d;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (arrayList2.get(i) == null) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                i = i2;
            }
            if (this.f14556d.size() > 1) {
                SkuDetails skuDetails = this.f14556d.get(0);
                String strM7504e = skuDetails.m7504e();
                ArrayList<SkuDetails> arrayList3 = this.f14556d;
                int size2 = arrayList3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    SkuDetails skuDetails2 = arrayList3.get(i3);
                    if (!strM7504e.equals("play_pass_subs") && !skuDetails2.m7504e().equals("play_pass_subs") && !strM7504e.equals(skuDetails2.m7504e())) {
                        throw new IllegalArgumentException("SKUs should have the same type.");
                    }
                }
                String strM7505f = skuDetails.m7505f();
                ArrayList<SkuDetails> arrayList4 = this.f14556d;
                int size3 = arrayList4.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    SkuDetails skuDetails3 = arrayList4.get(i4);
                    if (!strM7504e.equals("play_pass_subs") && !skuDetails3.m7504e().equals("play_pass_subs") && !strM7505f.equals(skuDetails3.m7505f())) {
                        throw new IllegalArgumentException("All SKUs must have the same package name.");
                    }
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams(null);
            billingFlowParams.f14546a = true ^ this.f14556d.get(0).m7505f().isEmpty();
            billingFlowParams.f14547b = this.f14553a;
            billingFlowParams.f14549d = null;
            billingFlowParams.f14548c = this.f14554b;
            billingFlowParams.f14550e = this.f14555c;
            billingFlowParams.f14551f = this.f14556d;
            billingFlowParams.f14552g = false;
            return billingFlowParams;
        }
    }

    public BillingFlowParams() {
    }

    public /* synthetic */ BillingFlowParams(C1630o c1630o) {
    }
}
