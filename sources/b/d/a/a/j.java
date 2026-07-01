package b.d.a.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.Purchase$a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Callable<Void> {
    public final /* synthetic */ String j;
    public final /* synthetic */ f k;
    public final /* synthetic */ a l;

    public j(a aVar, String str, f fVar) {
        this.l = aVar;
        this.j = str;
        this.k = fVar;
    }

    @Override // java.util.concurrent.Callable
    public final Void call() throws Exception {
        Purchase$a purchase$a;
        a aVar = this.l;
        String str = this.j;
        String strValueOf = String.valueOf(str);
        b.i.a.f.h.n.a.e("BillingClient", strValueOf.length() != 0 ? "Querying owned items, item type: ".concat(strValueOf) : new String("Querying owned items, item type: "));
        ArrayList arrayList = new ArrayList();
        boolean z2 = aVar.k;
        boolean z3 = aVar.p;
        String str2 = aVar.f448b;
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str2);
        int i = 1;
        if (z2 && z3) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        String string = null;
        while (true) {
            try {
                Bundle bundleO0 = aVar.k ? aVar.f.o0(9, aVar.e.getPackageName(), str, string, bundle) : aVar.f.E(3, aVar.e.getPackageName(), str, string);
                BillingResult billingResult = p.h;
                if (bundleO0 == null) {
                    Object[] objArr = new Object[i];
                    objArr[0] = "getPurchase()";
                    b.i.a.f.h.n.a.f("BillingClient", String.format("%s got null owned items list", objArr));
                } else {
                    int iA = b.i.a.f.h.n.a.a(bundleO0, "BillingClient");
                    String strD = b.i.a.f.h.n.a.d(bundleO0, "BillingClient");
                    BillingResult billingResult2 = new BillingResult();
                    billingResult2.a = iA;
                    billingResult2.f2003b = strD;
                    if (iA != 0) {
                        b.i.a.f.h.n.a.f("BillingClient", String.format("%s failed. Response code: %s", "getPurchase()", Integer.valueOf(iA)));
                        billingResult = billingResult2;
                        i = 1;
                    } else if (bundleO0.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleO0.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleO0.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList = bundleO0.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList2 = bundleO0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList3 = bundleO0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList == null) {
                            i = 1;
                            b.i.a.f.h.n.a.f("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", "getPurchase()"));
                        } else {
                            i = 1;
                            if (stringArrayList2 == null) {
                                b.i.a.f.h.n.a.f("BillingClient", String.format("Bundle returned from %s contains null purchases list.", "getPurchase()"));
                            } else if (stringArrayList3 == null) {
                                b.i.a.f.h.n.a.f("BillingClient", String.format("Bundle returned from %s contains null signatures list.", "getPurchase()"));
                            } else {
                                billingResult = p.i;
                            }
                        }
                    } else {
                        i = 1;
                        b.i.a.f.h.n.a.f("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", "getPurchase()"));
                    }
                }
                if (billingResult != p.i) {
                    purchase$a = new Purchase$a(billingResult, null);
                    break;
                }
                ArrayList<String> stringArrayList4 = bundleO0.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList5 = bundleO0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList6 = bundleO0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i2 = 0; i2 < stringArrayList5.size(); i2++) {
                    String str3 = stringArrayList5.get(i2);
                    String str4 = stringArrayList6.get(i2);
                    String strValueOf2 = String.valueOf(stringArrayList4.get(i2));
                    b.i.a.f.h.n.a.e("BillingClient", strValueOf2.length() != 0 ? "Sku is owned: ".concat(strValueOf2) : new String("Sku is owned: "));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.a())) {
                            b.i.a.f.h.n.a.f("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e) {
                        String strValueOf3 = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(strValueOf3.length() + 48);
                        sb.append("Got an exception trying to decode the purchase: ");
                        sb.append(strValueOf3);
                        b.i.a.f.h.n.a.f("BillingClient", sb.toString());
                        purchase$a = new Purchase$a(p.h, null);
                    }
                }
                string = bundleO0.getString("INAPP_CONTINUATION_TOKEN");
                String strValueOf4 = String.valueOf(string);
                b.i.a.f.h.n.a.e("BillingClient", strValueOf4.length() != 0 ? "Continuation token: ".concat(strValueOf4) : new String("Continuation token: "));
                if (TextUtils.isEmpty(string)) {
                    purchase$a = new Purchase$a(p.i, arrayList);
                    break;
                }
            } catch (Exception e2) {
                String strValueOf5 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(strValueOf5.length() + 57);
                sb2.append("Got exception trying to get purchases: ");
                sb2.append(strValueOf5);
                sb2.append("; try to reconnect");
                b.i.a.f.h.n.a.f("BillingClient", sb2.toString());
                purchase$a = new Purchase$a(p.j, null);
            }
        }
        List<Purchase> list = purchase$a.a;
        if (list != null) {
            this.k.onQueryPurchasesResponse(purchase$a.f2005b, list);
            return null;
        }
        f fVar = this.k;
        BillingResult billingResult3 = purchase$a.f2005b;
        b.i.a.f.h.n.m<Object> mVar = b.i.a.f.h.n.k.k;
        fVar.onQueryPurchasesResponse(billingResult3, b.i.a.f.h.n.l.l);
        return null;
    }
}
