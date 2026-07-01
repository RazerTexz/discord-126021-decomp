package b.d.a.a;

import com.android.billingclient.api.BillingResult;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ f j;

    public /* synthetic */ y(f fVar) {
        this.j = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.j;
        BillingResult billingResult = p.k;
        b.i.a.f.h.n.m<Object> mVar = b.i.a.f.h.n.k.k;
        fVar.onQueryPurchasesResponse(billingResult, b.i.a.f.h.n.l.l);
    }
}
