package b.d.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends BroadcastReceiver {
    public final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f452b;
    public final /* synthetic */ s c;

    public /* synthetic */ r(s sVar, g gVar) {
        this.c = sVar;
        this.a = gVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        BillingResult billingResultC = b.i.a.f.h.n.a.c(intent, "BillingBroadcastManager");
        Bundle extras = intent.getExtras();
        ArrayList arrayList = null;
        if (extras != null) {
            ArrayList<String> stringArrayList = extras.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList2 = extras.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            ArrayList arrayList2 = new ArrayList();
            if (stringArrayList == null || stringArrayList2 == null) {
                b.i.a.f.h.n.a.f("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
                Purchase purchaseG = b.i.a.f.h.n.a.g(extras.getString("INAPP_PURCHASE_DATA"), extras.getString("INAPP_DATA_SIGNATURE"));
                if (purchaseG == null) {
                    b.i.a.f.h.n.a.f("BillingHelper", "Couldn't find single purchase data as well.");
                } else {
                    arrayList2.add(purchaseG);
                }
            } else {
                for (int i = 0; i < stringArrayList.size() && i < stringArrayList2.size(); i++) {
                    Purchase purchaseG2 = b.i.a.f.h.n.a.g(stringArrayList.get(i), stringArrayList2.get(i));
                    if (purchaseG2 != null) {
                        arrayList2.add(purchaseG2);
                    }
                }
            }
            arrayList = arrayList2;
        }
        this.a.onPurchasesUpdated(billingResultC, arrayList);
    }
}
