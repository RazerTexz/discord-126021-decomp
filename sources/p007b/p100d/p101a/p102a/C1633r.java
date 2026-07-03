package p007b.p100d.p101a.p102a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;

/* JADX INFO: renamed from: b.d.a.a.r */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1633r extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1622g f2986a;

    /* JADX INFO: renamed from: b */
    public boolean f2987b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C1634s f2988c;

    public /* synthetic */ C1633r(C1634s c1634s, InterfaceC1622g interfaceC1622g) {
        this.f2988c = c1634s;
        this.f2986a = interfaceC1622g;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        BillingResult billingResultM5413c = C3941a.m5413c(intent, "BillingBroadcastManager");
        Bundle extras = intent.getExtras();
        ArrayList arrayList = null;
        if (extras != null) {
            ArrayList<String> stringArrayList = extras.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList2 = extras.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            ArrayList arrayList2 = new ArrayList();
            if (stringArrayList == null || stringArrayList2 == null) {
                C3941a.m5416f("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
                Purchase purchaseM5417g = C3941a.m5417g(extras.getString("INAPP_PURCHASE_DATA"), extras.getString("INAPP_DATA_SIGNATURE"));
                if (purchaseM5417g == null) {
                    C3941a.m5416f("BillingHelper", "Couldn't find single purchase data as well.");
                } else {
                    arrayList2.add(purchaseM5417g);
                }
            } else {
                for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
                    Purchase purchaseM5417g2 = C3941a.m5417g(stringArrayList.get(i), stringArrayList2.get(i));
                    if (purchaseM5417g2 != null) {
                        arrayList2.add(purchaseM5417g2);
                    }
                }
            }
            arrayList = arrayList2;
        }
        this.f2986a.onPurchasesUpdated(billingResultM5413c, arrayList);
    }
}
