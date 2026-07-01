package b.d.a.a;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Callable {
    public final /* synthetic */ a j;
    public final /* synthetic */ d k;
    public final /* synthetic */ e l;

    public /* synthetic */ t(a aVar, d dVar, e eVar) {
        this.j = aVar;
        this.k = dVar;
        this.l = eVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int iQ;
        String strD;
        a aVar = this.j;
        d dVar = this.k;
        e eVar = this.l;
        Objects.requireNonNull(aVar);
        String str = dVar.a;
        try {
            String strValueOf = String.valueOf(str);
            b.i.a.f.h.n.a.e("BillingClient", strValueOf.length() != 0 ? "Consuming purchase with token: ".concat(strValueOf) : new String("Consuming purchase with token: "));
            if (aVar.k) {
                b.i.a.f.h.n.d dVar2 = aVar.f;
                String packageName = aVar.e.getPackageName();
                boolean z2 = aVar.k;
                String str2 = aVar.f448b;
                Bundle bundle = new Bundle();
                if (z2) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle bundleR = dVar2.r(9, packageName, str, bundle);
                iQ = bundleR.getInt("RESPONSE_CODE");
                strD = b.i.a.f.h.n.a.d(bundleR, "BillingClient");
            } else {
                iQ = aVar.f.q(3, aVar.e.getPackageName(), str);
                strD = "";
            }
            BillingResult billingResult = new BillingResult();
            billingResult.a = iQ;
            billingResult.f2003b = strD;
            if (iQ == 0) {
                b.i.a.f.h.n.a.e("BillingClient", "Successfully consumed purchase.");
                eVar.onConsumeResponse(billingResult, str);
                return null;
            }
            StringBuilder sb = new StringBuilder(63);
            sb.append("Error consuming purchase with token. Response code: ");
            sb.append(iQ);
            b.i.a.f.h.n.a.f("BillingClient", sb.toString());
            eVar.onConsumeResponse(billingResult, str);
            return null;
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 30);
            sb2.append("Error consuming purchase; ex: ");
            sb2.append(strValueOf2);
            b.i.a.f.h.n.a.f("BillingClient", sb2.toString());
            eVar.onConsumeResponse(p.j, str);
            return null;
        }
    }
}
