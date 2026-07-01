package b.d.a.a;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements Callable {
    public final /* synthetic */ a j;
    public final /* synthetic */ String k;
    public final /* synthetic */ List l;
    public final /* synthetic */ i m;

    public /* synthetic */ v(a aVar, String str, List list, i iVar) {
        this.j = aVar;
        this.k = str;
        this.l = list;
        this.m = iVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String strD;
        int iA;
        a aVar = this.j;
        String str = this.k;
        List list = this.l;
        i iVar = this.m;
        Objects.requireNonNull(aVar);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                strD = "";
                iA = 0;
            } else {
                int i2 = i + 20;
                ArrayList arrayList2 = new ArrayList(list.subList(i, i2 > size ? size : i2));
                ArrayList<String> arrayList3 = new ArrayList<>();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    arrayList3.add(((q) arrayList2.get(i3)).a);
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
                bundle.putString("playBillingLibraryVersion", aVar.f448b);
                try {
                    Bundle bundleO = aVar.l ? aVar.f.o(10, aVar.e.getPackageName(), str, bundle, b.i.a.f.h.n.a.b(aVar.i, aVar.p, aVar.f448b, null, arrayList2)) : aVar.f.e0(3, aVar.e.getPackageName(), str, bundle);
                    if (bundleO == null) {
                        b.i.a.f.h.n.a.f("BillingClient", "querySkuDetailsAsync got null sku details list");
                    } else {
                        if (bundleO.containsKey("DETAILS_LIST")) {
                            ArrayList<String> stringArrayList = bundleO.getStringArrayList("DETAILS_LIST");
                            if (stringArrayList == null) {
                                b.i.a.f.h.n.a.f("BillingClient", "querySkuDetailsAsync got null response list");
                            } else {
                                for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                                    try {
                                        SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                                        String strValueOf = String.valueOf(skuDetails);
                                        StringBuilder sb = new StringBuilder(strValueOf.length() + 17);
                                        sb.append("Got sku details: ");
                                        sb.append(strValueOf);
                                        b.i.a.f.h.n.a.e("BillingClient", sb.toString());
                                        arrayList.add(skuDetails);
                                    } catch (JSONException unused) {
                                        b.i.a.f.h.n.a.f("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                                        strD = "Error trying to decode SkuDetails.";
                                        arrayList = null;
                                    }
                                }
                                i = i2;
                            }
                        } else {
                            iA = b.i.a.f.h.n.a.a(bundleO, "BillingClient");
                            strD = b.i.a.f.h.n.a.d(bundleO, "BillingClient");
                            if (iA != 0) {
                                StringBuilder sb2 = new StringBuilder(50);
                                sb2.append("getSkuDetails() failed. Response code: ");
                                sb2.append(iA);
                                b.i.a.f.h.n.a.f("BillingClient", sb2.toString());
                            } else {
                                b.i.a.f.h.n.a.f("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                            }
                        }
                        iA = 6;
                    }
                    iA = 4;
                    strD = "Item is unavailable for purchase.";
                } catch (Exception e) {
                    String strValueOf2 = String.valueOf(e);
                    StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 63);
                    sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                    sb3.append(strValueOf2);
                    b.i.a.f.h.n.a.f("BillingClient", sb3.toString());
                    iA = -1;
                    strD = "Service connection is disconnected.";
                }
                arrayList = null;
            }
            BillingResult billingResult = new BillingResult();
            billingResult.a = iA;
            billingResult.f2003b = strD;
            iVar.onSkuDetailsResponse(billingResult, arrayList);
            return null;
        }
    }
}
