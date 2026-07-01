package b.d.a.a;

import android.os.Bundle;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.SkuDetails;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements Callable {
    public final /* synthetic */ a j;
    public final /* synthetic */ int k;
    public final /* synthetic */ SkuDetails l;
    public final /* synthetic */ String m;
    public final /* synthetic */ BillingFlowParams n;
    public final /* synthetic */ Bundle o;

    public /* synthetic */ b0(a aVar, int i, SkuDetails skuDetails, String str, BillingFlowParams billingFlowParams, Bundle bundle) {
        this.j = aVar;
        this.k = i;
        this.l = skuDetails;
        this.m = str;
        this.n = billingFlowParams;
        this.o = bundle;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        a aVar = this.j;
        int i = this.k;
        SkuDetails skuDetails = this.l;
        return aVar.f.c0(i, aVar.e.getPackageName(), skuDetails.d(), this.m, null, this.o);
    }
}
