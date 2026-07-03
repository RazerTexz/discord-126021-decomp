package p007b.p100d.p101a.p102a;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3951k;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3953m;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;
import p007b.p225i.p226a.p288f.p313h.p327n.C3952l;

/* JADX INFO: renamed from: b.d.a.a.j */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC1625j implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f2961j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC1621f f2962k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C1614a f2963l;

    public CallableC1625j(C1614a c1614a, String str, InterfaceC1621f interfaceC1621f) {
        this.f2963l = c1614a;
        this.f2961j = str;
        this.f2962k = interfaceC1621f;
    }

    @Override // java.util.concurrent.Callable
    public final Void call() throws Exception {
        Purchase.C5413a c5413a;
        C1614a c1614a = this.f2963l;
        String str = this.f2961j;
        String strValueOf = String.valueOf(str);
        C3941a.m5415e("BillingClient", strValueOf.length() != 0 ? "Querying owned items, item type: ".concat(strValueOf) : new String("Querying owned items, item type: "));
        ArrayList arrayList = new ArrayList();
        boolean z2 = c1614a.f2941k;
        boolean z3 = c1614a.f2946p;
        String str2 = c1614a.f2932b;
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str2);
        int i = 1;
        if (z2 && z3) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        String string = null;
        while (true) {
            try {
                Bundle bundleMo5424o0 = c1614a.f2941k ? c1614a.f2936f.mo5424o0(9, c1614a.f2935e.getPackageName(), str, string, bundle) : c1614a.f2936f.mo5418E(3, c1614a.f2935e.getPackageName(), str, string);
                BillingResult billingResult = C1631p.f2979h;
                if (bundleMo5424o0 == null) {
                    Object[] objArr = new Object[i];
                    objArr[0] = "getPurchase()";
                    C3941a.m5416f("BillingClient", String.format("%s got null owned items list", objArr));
                } else {
                    int iM5411a = C3941a.m5411a(bundleMo5424o0, "BillingClient");
                    String strM5414d = C3941a.m5414d(bundleMo5424o0, "BillingClient");
                    BillingResult billingResult2 = new BillingResult();
                    billingResult2.f14557a = iM5411a;
                    billingResult2.f14558b = strM5414d;
                    if (iM5411a != 0) {
                        C3941a.m5416f("BillingClient", String.format("%s failed. Response code: %s", "getPurchase()", Integer.valueOf(iM5411a)));
                        billingResult = billingResult2;
                        i = 1;
                    } else if (bundleMo5424o0.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleMo5424o0.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleMo5424o0.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList = bundleMo5424o0.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList2 = bundleMo5424o0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList3 = bundleMo5424o0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList == null) {
                            i = 1;
                            C3941a.m5416f("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", "getPurchase()"));
                        } else {
                            i = 1;
                            if (stringArrayList2 == null) {
                                C3941a.m5416f("BillingClient", String.format("Bundle returned from %s contains null purchases list.", "getPurchase()"));
                            } else if (stringArrayList3 == null) {
                                C3941a.m5416f("BillingClient", String.format("Bundle returned from %s contains null signatures list.", "getPurchase()"));
                            } else {
                                billingResult = C1631p.f2980i;
                            }
                        }
                    } else {
                        i = 1;
                        C3941a.m5416f("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", "getPurchase()"));
                    }
                }
                if (billingResult != C1631p.f2980i) {
                    c5413a = new Purchase.C5413a(billingResult, null);
                    break;
                }
                ArrayList<String> stringArrayList4 = bundleMo5424o0.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList5 = bundleMo5424o0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList6 = bundleMo5424o0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i2 = 0; i2 < stringArrayList5.size(); i2++) {
                    String str3 = stringArrayList5.get(i2);
                    String str4 = stringArrayList6.get(i2);
                    String strValueOf2 = String.valueOf(stringArrayList4.get(i2));
                    C3941a.m5415e("BillingClient", strValueOf2.length() != 0 ? "Sku is owned: ".concat(strValueOf2) : new String("Sku is owned: "));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.m7497a())) {
                            C3941a.m5416f("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e) {
                        String strValueOf3 = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(strValueOf3.length() + 48);
                        sb.append("Got an exception trying to decode the purchase: ");
                        sb.append(strValueOf3);
                        C3941a.m5416f("BillingClient", sb.toString());
                        c5413a = new Purchase.C5413a(C1631p.f2979h, null);
                    }
                }
                string = bundleMo5424o0.getString("INAPP_CONTINUATION_TOKEN");
                String strValueOf4 = String.valueOf(string);
                C3941a.m5415e("BillingClient", strValueOf4.length() != 0 ? "Continuation token: ".concat(strValueOf4) : new String("Continuation token: "));
                if (TextUtils.isEmpty(string)) {
                    c5413a = new Purchase.C5413a(C1631p.f2980i, arrayList);
                    break;
                }
            } catch (Exception e2) {
                String strValueOf5 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(strValueOf5.length() + 57);
                sb2.append("Got exception trying to get purchases: ");
                sb2.append(strValueOf5);
                sb2.append("; try to reconnect");
                C3941a.m5416f("BillingClient", sb2.toString());
                c5413a = new Purchase.C5413a(C1631p.f2981j, null);
            }
        }
        List<Purchase> list = c5413a.f14564a;
        if (list != null) {
            this.f2962k.onQueryPurchasesResponse(c5413a.f14565b, list);
            return null;
        }
        InterfaceC1621f interfaceC1621f = this.f2962k;
        BillingResult billingResult3 = c5413a.f14565b;
        AbstractC3953m<Object> abstractC3953m = AbstractC3951k.f10489k;
        interfaceC1621f.onQueryPurchasesResponse(billingResult3, C3952l.f10490l);
        return null;
    }
}
