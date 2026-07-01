package b.d.a.a;

import com.android.billingclient.api.BillingResult;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ a j;
    public final /* synthetic */ BillingResult k;

    public /* synthetic */ w(a aVar, BillingResult billingResult) {
        this.j = aVar;
        this.k = billingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.j;
        aVar.d.f453b.a.onPurchasesUpdated(this.k, null);
    }
}
