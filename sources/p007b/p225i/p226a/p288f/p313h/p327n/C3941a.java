package p007b.p225i.p226a.p288f.p313h.p327n;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import org.json.JSONException;
import p007b.p100d.p101a.p102a.C1632q;

/* JADX INFO: renamed from: b.i.a.f.h.n.a */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3941a {

    /* JADX INFO: renamed from: a */
    public static final int f10479a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: a */
    public static int m5411a(Bundle bundle, String str) {
        if (bundle == null) {
            m5416f(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            m5415e(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        String name = obj.getClass().getName();
        m5416f(str, name.length() != 0 ? "Unexpected type for bundle response code: ".concat(name) : new String("Unexpected type for bundle response code: "));
        return 6;
    }

    /* JADX INFO: renamed from: b */
    public static Bundle m5412b(int i, boolean z2, String str, @Nullable String str2, ArrayList<C1632q> arrayList) {
        Bundle bundle = new Bundle();
        if (i >= 9) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        if (i >= 9 && z2) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (i >= 14) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            boolean z3 = false;
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.get(i2);
                arrayList2.add(null);
                z3 |= !TextUtils.isEmpty(null);
            }
            if (z3) {
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList2);
            }
        }
        return bundle;
    }

    /* JADX INFO: renamed from: c */
    public static BillingResult m5413c(Intent intent, String str) {
        if (intent == null) {
            m5416f("BillingHelper", "Got null intent!");
            BillingResult billingResult = new BillingResult();
            billingResult.f14557a = 6;
            billingResult.f14558b = "An internal error occurred.";
            return billingResult;
        }
        int iM5411a = m5411a(intent.getExtras(), str);
        String strM5414d = m5414d(intent.getExtras(), str);
        BillingResult billingResult2 = new BillingResult();
        billingResult2.f14557a = iM5411a;
        billingResult2.f14558b = strM5414d;
        return billingResult2;
    }

    /* JADX INFO: renamed from: d */
    public static String m5414d(Bundle bundle, String str) {
        if (bundle == null) {
            m5416f(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            m5415e(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        String name = obj.getClass().getName();
        m5416f(str, name.length() != 0 ? "Unexpected type for debug message: ".concat(name) : new String("Unexpected type for debug message: "));
        return "";
    }

    /* JADX INFO: renamed from: e */
    public static void m5415e(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m5416f(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    /* JADX INFO: renamed from: g */
    public static Purchase m5417g(String str, String str2) {
        if (str == null || str2 == null) {
            m5416f("BillingHelper", "Received a bad purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
            sb.append("Got JSONException while parsing purchase data: ");
            sb.append(strValueOf);
            m5416f("BillingHelper", sb.toString());
            return null;
        }
    }
}
