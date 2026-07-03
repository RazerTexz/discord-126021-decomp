package p007b.p100d.p101a.p102a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProxyBillingActivity;
import com.android.billingclient.api.SkuDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3951k;
import p007b.p225i.p226a.p288f.p313h.p327n.AbstractC3953m;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;
import p007b.p225i.p226a.p288f.p313h.p327n.C3952l;
import p007b.p225i.p226a.p288f.p313h.p327n.InterfaceC3944d;

/* JADX INFO: renamed from: b.d.a.a.a */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class C1614a extends BillingClient {

    /* JADX INFO: renamed from: a */
    public volatile int f2931a;

    /* JADX INFO: renamed from: b */
    public final String f2932b;

    /* JADX INFO: renamed from: c */
    public final Handler f2933c;

    /* JADX INFO: renamed from: d */
    public volatile C1634s f2934d;

    /* JADX INFO: renamed from: e */
    public Context f2935e;

    /* JADX INFO: renamed from: f */
    public volatile InterfaceC3944d f2936f;

    /* JADX INFO: renamed from: g */
    public volatile ServiceConnectionC1629n f2937g;

    /* JADX INFO: renamed from: h */
    public boolean f2938h;

    /* JADX INFO: renamed from: i */
    public int f2939i;

    /* JADX INFO: renamed from: j */
    public boolean f2940j;

    /* JADX INFO: renamed from: k */
    public boolean f2941k;

    /* JADX INFO: renamed from: l */
    public boolean f2942l;

    /* JADX INFO: renamed from: m */
    public boolean f2943m;

    /* JADX INFO: renamed from: n */
    public boolean f2944n;

    /* JADX INFO: renamed from: o */
    public boolean f2945o;

    /* JADX INFO: renamed from: p */
    public boolean f2946p;

    /* JADX INFO: renamed from: q */
    public ExecutorService f2947q;

    @AnyThread
    public C1614a(@Nullable String str, boolean z2, Context context, InterfaceC1622g interfaceC1622g) {
        String str2;
        try {
            str2 = (String) Class.forName("b.d.a.b.a").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            str2 = "4.0.0";
        }
        this.f2931a = 0;
        this.f2933c = new Handler(Looper.getMainLooper());
        this.f2939i = 0;
        this.f2932b = str2;
        Context applicationContext = context.getApplicationContext();
        this.f2935e = applicationContext;
        this.f2934d = new C1634s(applicationContext, interfaceC1622g);
        this.f2946p = z2;
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: a */
    public final void mo799a(final C1619d c1619d, final InterfaceC1620e interfaceC1620e) {
        if (!mo802d()) {
            interfaceC1620e.onConsumeResponse(C1631p.f2981j, c1619d.f2958a);
        } else if (m810l(new Callable() { // from class: b.d.a.a.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int iMo5425q;
                String strM5414d;
                C1614a c1614a = this.f2991j;
                C1619d c1619d2 = c1619d;
                InterfaceC1620e interfaceC1620e2 = interfaceC1620e;
                Objects.requireNonNull(c1614a);
                String str = c1619d2.f2958a;
                try {
                    String strValueOf = String.valueOf(str);
                    C3941a.m5415e("BillingClient", strValueOf.length() != 0 ? "Consuming purchase with token: ".concat(strValueOf) : new String("Consuming purchase with token: "));
                    if (c1614a.f2941k) {
                        InterfaceC3944d interfaceC3944d = c1614a.f2936f;
                        String packageName = c1614a.f2935e.getPackageName();
                        boolean z2 = c1614a.f2941k;
                        String str2 = c1614a.f2932b;
                        Bundle bundle = new Bundle();
                        if (z2) {
                            bundle.putString("playBillingLibraryVersion", str2);
                        }
                        Bundle bundleMo5426r = interfaceC3944d.mo5426r(9, packageName, str, bundle);
                        iMo5425q = bundleMo5426r.getInt("RESPONSE_CODE");
                        strM5414d = C3941a.m5414d(bundleMo5426r, "BillingClient");
                    } else {
                        iMo5425q = c1614a.f2936f.mo5425q(3, c1614a.f2935e.getPackageName(), str);
                        strM5414d = "";
                    }
                    BillingResult billingResult = new BillingResult();
                    billingResult.f14557a = iMo5425q;
                    billingResult.f14558b = strM5414d;
                    if (iMo5425q == 0) {
                        C3941a.m5415e("BillingClient", "Successfully consumed purchase.");
                        interfaceC1620e2.onConsumeResponse(billingResult, str);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder(63);
                    sb.append("Error consuming purchase with token. Response code: ");
                    sb.append(iMo5425q);
                    C3941a.m5416f("BillingClient", sb.toString());
                    interfaceC1620e2.onConsumeResponse(billingResult, str);
                    return null;
                } catch (Exception e) {
                    String strValueOf2 = String.valueOf(e);
                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 30);
                    sb2.append("Error consuming purchase; ex: ");
                    sb2.append(strValueOf2);
                    C3941a.m5416f("BillingClient", sb2.toString());
                    interfaceC1620e2.onConsumeResponse(C1631p.f2981j, str);
                    return null;
                }
            }
        }, 30000L, new Runnable() { // from class: b.d.a.a.x
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC1620e.onConsumeResponse(C1631p.f2982k, c1619d.f2958a);
            }
        }, m807i()) == null) {
            interfaceC1620e.onConsumeResponse(m809k(), c1619d.f2958a);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: b */
    public final void mo800b() {
        try {
            try {
                this.f2934d.m812a();
                if (this.f2937g != null) {
                    ServiceConnectionC1629n serviceConnectionC1629n = this.f2937g;
                    synchronized (serviceConnectionC1629n.f2968j) {
                        serviceConnectionC1629n.f2970l = null;
                        serviceConnectionC1629n.f2969k = true;
                    }
                }
                if (this.f2937g != null && this.f2936f != null) {
                    C3941a.m5415e("BillingClient", "Unbinding from service.");
                    this.f2935e.unbindService(this.f2937g);
                    this.f2937g = null;
                }
                this.f2936f = null;
                ExecutorService executorService = this.f2947q;
                if (executorService != null) {
                    executorService.shutdownNow();
                    this.f2947q = null;
                }
                this.f2931a = 3;
            } catch (Exception e) {
                String strValueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 48);
                sb.append("There was an exception while ending connection: ");
                sb.append(strValueOf);
                C3941a.m5416f("BillingClient", sb.toString());
                this.f2931a = 3;
            }
        } catch (Throwable th) {
            this.f2931a = 3;
            throw th;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: c */
    public final int mo801c() {
        return this.f2931a;
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: d */
    public final boolean mo802d() {
        return (this.f2931a != 2 || this.f2936f == null || this.f2937g == null) ? false : true;
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: e */
    public final BillingResult mo803e(Activity activity, final BillingFlowParams billingFlowParams) {
        String str;
        Future futureM810l;
        String str2;
        String str3;
        boolean z2;
        final int i;
        String strOptString;
        if (!mo802d()) {
            BillingResult billingResult = C1631p.f2981j;
            m808j(billingResult);
            return billingResult;
        }
        Objects.requireNonNull(billingFlowParams);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(billingFlowParams.f14551f);
        final SkuDetails skuDetails = (SkuDetails) arrayList.get(0);
        final String strM7504e = skuDetails.m7504e();
        String str4 = "BillingClient";
        if (strM7504e.equals("subs") && !this.f2938h) {
            C3941a.m5416f("BillingClient", "Current client doesn't support subscriptions.");
            BillingResult billingResult2 = C1631p.f2983l;
            m808j(billingResult2);
            return billingResult2;
        }
        if (((!billingFlowParams.f14552g && billingFlowParams.f14547b == null && billingFlowParams.f14549d == null && billingFlowParams.f14550e == 0 && !billingFlowParams.f14546a) ? false : true) && !this.f2940j) {
            C3941a.m5416f("BillingClient", "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult3 = C1631p.f2977f;
            m808j(billingResult3);
            return billingResult3;
        }
        if (arrayList.size() > 1 && !this.f2945o) {
            C3941a.m5416f("BillingClient", "Current client doesn't support multi-item purchases.");
            BillingResult billingResult4 = C1631p.f2984m;
            m808j(billingResult4);
            return billingResult4;
        }
        String str5 = "";
        int i2 = 0;
        String str6 = "";
        while (i2 < arrayList.size()) {
            String strValueOf = String.valueOf(str6);
            String strValueOf2 = String.valueOf(arrayList.get(i2));
            String str7 = str5;
            String strM822J = C1643a.m822J(new StringBuilder(strValueOf.length() + strValueOf2.length()), strValueOf, strValueOf2);
            if (i2 < arrayList.size() - 1) {
                strM822J = String.valueOf(strM822J).concat(", ");
            }
            str6 = strM822J;
            i2++;
            str5 = str7;
        }
        String str8 = str5;
        StringBuilder sb = new StringBuilder(String.valueOf(str6).length() + 41 + strM7504e.length());
        sb.append("Constructing buy intent for ");
        sb.append(str6);
        sb.append(", item type: ");
        sb.append(strM7504e);
        C3941a.m5415e("BillingClient", sb.toString());
        if (this.f2940j) {
            boolean z3 = this.f2941k;
            boolean z4 = this.f2946p;
            String str9 = this.f2932b;
            final Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str9);
            int i3 = billingFlowParams.f14550e;
            if (i3 != 0) {
                bundle.putInt("prorationMode", i3);
            }
            if (!TextUtils.isEmpty(billingFlowParams.f14547b)) {
                bundle.putString("accountId", billingFlowParams.f14547b);
            }
            if (!TextUtils.isEmpty(billingFlowParams.f14549d)) {
                bundle.putString("obfuscatedProfileId", billingFlowParams.f14549d);
            }
            if (billingFlowParams.f14552g) {
                bundle.putBoolean("vr", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.f14548c)) {
                bundle.putString("oldSkuPurchaseToken", billingFlowParams.f14548c);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("paymentsPurchaseParams", null);
            }
            if (z3 && z4) {
                bundle.putBoolean("enablePendingPurchases", true);
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            ArrayList<String> arrayList4 = new ArrayList<>();
            ArrayList<Integer> arrayList5 = new ArrayList<>();
            ArrayList<String> arrayList6 = new ArrayList<>();
            int size = arrayList.size();
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int i4 = 0;
            while (i4 < size) {
                int i5 = size;
                SkuDetails skuDetails2 = (SkuDetails) arrayList.get(i4);
                String str10 = str4;
                if (!skuDetails2.f14567b.optString("skuDetailsToken").isEmpty()) {
                    arrayList2.add(skuDetails2.f14567b.optString("skuDetailsToken"));
                }
                try {
                    strOptString = new JSONObject(skuDetails2.f14566a).optString("offer_id_token");
                } catch (JSONException unused) {
                    strOptString = str8;
                }
                String str11 = strM7504e;
                String strOptString2 = skuDetails2.f14567b.optString("offer_id");
                int iOptInt = skuDetails2.f14567b.optInt("offer_type");
                String strOptString3 = skuDetails2.f14567b.optString("serializedDocid");
                arrayList3.add(strOptString);
                z5 |= !TextUtils.isEmpty(strOptString);
                arrayList4.add(strOptString2);
                z6 |= !TextUtils.isEmpty(strOptString2);
                arrayList5.add(Integer.valueOf(iOptInt));
                z7 |= iOptInt != 0;
                z8 |= !TextUtils.isEmpty(strOptString3);
                arrayList6.add(strOptString3);
                i4++;
                str4 = str10;
                size = i5;
                strM7504e = str11;
            }
            final String str12 = strM7504e;
            str = str4;
            if (!arrayList2.isEmpty()) {
                bundle.putStringArrayList("skuDetailsTokens", arrayList2);
            }
            if (z5) {
                if (!this.f2943m) {
                    BillingResult billingResult5 = C1631p.f2978g;
                    m808j(billingResult5);
                    return billingResult5;
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList3);
            }
            if (z6) {
                bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList4);
            }
            if (z7) {
                bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList5);
            }
            if (z8) {
                bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
            }
            if (TextUtils.isEmpty(skuDetails.m7505f())) {
                str3 = null;
                z2 = false;
            } else {
                bundle.putString("skuPackageName", skuDetails.m7505f());
                str3 = null;
                z2 = true;
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("accountName", str3);
            }
            if (arrayList.size() > 1) {
                ArrayList<String> arrayList7 = new ArrayList<>(arrayList.size() - 1);
                ArrayList<String> arrayList8 = new ArrayList<>(arrayList.size() - 1);
                for (int i6 = 1; i6 < arrayList.size(); i6++) {
                    arrayList7.add(((SkuDetails) arrayList.get(i6)).m7503d());
                    arrayList8.add(((SkuDetails) arrayList.get(i6)).m7504e());
                }
                bundle.putStringArrayList("additionalSkus", arrayList7);
                bundle.putStringArrayList("additionalSkuTypes", arrayList8);
            }
            if (!TextUtils.isEmpty(activity.getIntent().getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = activity.getIntent().getStringExtra("PROXY_PACKAGE");
                bundle.putString("proxyPackage", stringExtra);
                try {
                    bundle.putString("proxyPackageVersion", this.f2935e.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                } catch (PackageManager.NameNotFoundException unused2) {
                    bundle.putString("proxyPackageVersion", "package not found");
                }
            }
            if (this.f2944n && z2) {
                i = 15;
            } else if (this.f2941k) {
                i = 9;
            } else {
                i = billingFlowParams.f14552g ? 7 : 6;
            }
            futureM810l = m810l(new Callable() { // from class: b.d.a.a.b0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C1614a c1614a = this.f2950j;
                    int i7 = i;
                    SkuDetails skuDetails3 = skuDetails;
                    return c1614a.f2936f.mo5421c0(i7, c1614a.f2935e.getPackageName(), skuDetails3.m7503d(), str12, null, bundle);
                }
            }, 5000L, null, this.f2933c);
        } else {
            str = "BillingClient";
            futureM810l = m810l(new Callable() { // from class: b.d.a.a.u
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C1614a c1614a = this.f2994j;
                    SkuDetails skuDetails3 = skuDetails;
                    return c1614a.f2936f.mo5419F(3, c1614a.f2935e.getPackageName(), skuDetails3.m7503d(), strM7504e, null);
                }
            }, 5000L, null, this.f2933c);
        }
        try {
            try {
                try {
                    Bundle bundle2 = (Bundle) futureM810l.get(5000L, TimeUnit.MILLISECONDS);
                    str2 = str;
                    try {
                        int iM5411a = C3941a.m5411a(bundle2, str2);
                        String strM5414d = C3941a.m5414d(bundle2, str2);
                        if (iM5411a == 0) {
                            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                            intent.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                            activity.startActivity(intent);
                            return C1631p.f2980i;
                        }
                        StringBuilder sb2 = new StringBuilder(52);
                        sb2.append("Unable to buy item, Error response code: ");
                        sb2.append(iM5411a);
                        C3941a.m5416f(str2, sb2.toString());
                        BillingResult billingResult6 = new BillingResult();
                        billingResult6.f14557a = iM5411a;
                        billingResult6.f14558b = strM5414d;
                        m808j(billingResult6);
                        return billingResult6;
                    } catch (CancellationException | TimeoutException unused3) {
                        StringBuilder sb3 = new StringBuilder(String.valueOf(str6).length() + 68);
                        sb3.append("Time out while launching billing flow: ; for sku: ");
                        sb3.append(str6);
                        sb3.append("; try to reconnect");
                        C3941a.m5416f(str2, sb3.toString());
                        BillingResult billingResult7 = C1631p.f2982k;
                        m808j(billingResult7);
                        return billingResult7;
                    } catch (Exception unused4) {
                        StringBuilder sb4 = new StringBuilder(String.valueOf(str6).length() + 69);
                        sb4.append("Exception while launching billing flow: ; for sku: ");
                        sb4.append(str6);
                        sb4.append("; try to reconnect");
                        C3941a.m5416f(str2, sb4.toString());
                        BillingResult billingResult8 = C1631p.f2981j;
                        m808j(billingResult8);
                        return billingResult8;
                    }
                } catch (CancellationException | TimeoutException unused5) {
                    str2 = str;
                }
            } catch (Exception unused6) {
                str2 = str;
            }
        } catch (CancellationException | TimeoutException unused7) {
            str2 = str;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: f */
    public void mo804f(String str, final InterfaceC1621f interfaceC1621f) {
        if (!mo802d()) {
            BillingResult billingResult = C1631p.f2981j;
            AbstractC3953m<Object> abstractC3953m = AbstractC3951k.f10489k;
            interfaceC1621f.onQueryPurchasesResponse(billingResult, C3952l.f10490l);
        } else {
            if (TextUtils.isEmpty(str)) {
                C3941a.m5416f("BillingClient", "Please provide a valid SKU type.");
                BillingResult billingResult2 = C1631p.f2976e;
                AbstractC3953m<Object> abstractC3953m2 = AbstractC3951k.f10489k;
                interfaceC1621f.onQueryPurchasesResponse(billingResult2, C3952l.f10490l);
                return;
            }
            if (m810l(new CallableC1625j(this, str, interfaceC1621f), 30000L, new Runnable() { // from class: b.d.a.a.y
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC1621f interfaceC1621f2 = interfaceC1621f;
                    BillingResult billingResult3 = C1631p.f2982k;
                    AbstractC3953m<Object> abstractC3953m3 = AbstractC3951k.f10489k;
                    interfaceC1621f2.onQueryPurchasesResponse(billingResult3, C3952l.f10490l);
                }
            }, m807i()) == null) {
                BillingResult billingResultM809k = m809k();
                AbstractC3953m<Object> abstractC3953m3 = AbstractC3951k.f10489k;
                interfaceC1621f.onQueryPurchasesResponse(billingResultM809k, C3952l.f10490l);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: g */
    public final void mo805g(C1623h c1623h, final InterfaceC1624i interfaceC1624i) {
        if (!mo802d()) {
            interfaceC1624i.onSkuDetailsResponse(C1631p.f2981j, null);
            return;
        }
        final String str = c1623h.f2959a;
        List<String> list = c1623h.f2960b;
        if (TextUtils.isEmpty(str)) {
            C3941a.m5416f("BillingClient", "Please fix the input params. SKU type can't be empty.");
            interfaceC1624i.onSkuDetailsResponse(C1631p.f2976e, null);
            return;
        }
        if (list == null) {
            C3941a.m5416f("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
            interfaceC1624i.onSkuDetailsResponse(C1631p.f2975d, null);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("SKU must be set.");
            }
            arrayList.add(new C1632q(str2));
        }
        if (m810l(new Callable() { // from class: b.d.a.a.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String strM5414d;
                int iM5411a;
                C1614a c1614a = this.f2997j;
                String str3 = str;
                List list2 = arrayList;
                InterfaceC1624i interfaceC1624i2 = interfaceC1624i;
                Objects.requireNonNull(c1614a);
                ArrayList arrayList2 = new ArrayList();
                int size = list2.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        strM5414d = "";
                        iM5411a = 0;
                    } else {
                        int i2 = i + 20;
                        ArrayList arrayList3 = new ArrayList(list2.subList(i, i2 > size ? size : i2));
                        ArrayList<String> arrayList4 = new ArrayList<>();
                        int size2 = arrayList3.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            arrayList4.add(((C1632q) arrayList3.get(i3)).f2985a);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
                        bundle.putString("playBillingLibraryVersion", c1614a.f2932b);
                        try {
                            Bundle bundleMo5423o = c1614a.f2942l ? c1614a.f2936f.mo5423o(10, c1614a.f2935e.getPackageName(), str3, bundle, C3941a.m5412b(c1614a.f2939i, c1614a.f2946p, c1614a.f2932b, null, arrayList3)) : c1614a.f2936f.mo5422e0(3, c1614a.f2935e.getPackageName(), str3, bundle);
                            if (bundleMo5423o == null) {
                                C3941a.m5416f("BillingClient", "querySkuDetailsAsync got null sku details list");
                            } else {
                                if (bundleMo5423o.containsKey("DETAILS_LIST")) {
                                    ArrayList<String> stringArrayList = bundleMo5423o.getStringArrayList("DETAILS_LIST");
                                    if (stringArrayList == null) {
                                        C3941a.m5416f("BillingClient", "querySkuDetailsAsync got null response list");
                                    } else {
                                        for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                                            try {
                                                SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                                                String strValueOf = String.valueOf(skuDetails);
                                                StringBuilder sb = new StringBuilder(strValueOf.length() + 17);
                                                sb.append("Got sku details: ");
                                                sb.append(strValueOf);
                                                C3941a.m5415e("BillingClient", sb.toString());
                                                arrayList2.add(skuDetails);
                                            } catch (JSONException unused) {
                                                C3941a.m5416f("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                                                strM5414d = "Error trying to decode SkuDetails.";
                                                arrayList2 = null;
                                            }
                                        }
                                        i = i2;
                                    }
                                } else {
                                    iM5411a = C3941a.m5411a(bundleMo5423o, "BillingClient");
                                    strM5414d = C3941a.m5414d(bundleMo5423o, "BillingClient");
                                    if (iM5411a != 0) {
                                        StringBuilder sb2 = new StringBuilder(50);
                                        sb2.append("getSkuDetails() failed. Response code: ");
                                        sb2.append(iM5411a);
                                        C3941a.m5416f("BillingClient", sb2.toString());
                                    } else {
                                        C3941a.m5416f("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                                    }
                                }
                                iM5411a = 6;
                            }
                            iM5411a = 4;
                            strM5414d = "Item is unavailable for purchase.";
                        } catch (Exception e) {
                            String strValueOf2 = String.valueOf(e);
                            StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 63);
                            sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                            sb3.append(strValueOf2);
                            C3941a.m5416f("BillingClient", sb3.toString());
                            iM5411a = -1;
                            strM5414d = "Service connection is disconnected.";
                        }
                        arrayList2 = null;
                    }
                    BillingResult billingResult = new BillingResult();
                    billingResult.f14557a = iM5411a;
                    billingResult.f14558b = strM5414d;
                    interfaceC1624i2.onSkuDetailsResponse(billingResult, arrayList2);
                    return null;
                }
            }
        }, 30000L, new Runnable() { // from class: b.d.a.a.z
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC1624i.onSkuDetailsResponse(C1631p.f2982k, null);
            }
        }, m807i()) == null) {
            interfaceC1624i.onSkuDetailsResponse(m809k(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    /* JADX INFO: renamed from: h */
    public final void mo806h(InterfaceC1616b interfaceC1616b) {
        ServiceInfo serviceInfo;
        if (mo802d()) {
            C3941a.m5415e("BillingClient", "Service connection is valid. No need to re-initialize.");
            interfaceC1616b.onBillingSetupFinished(C1631p.f2980i);
            return;
        }
        if (this.f2931a == 1) {
            C3941a.m5416f("BillingClient", "Client is already in the process of connecting to billing service.");
            interfaceC1616b.onBillingSetupFinished(C1631p.f2974c);
            return;
        }
        if (this.f2931a == 3) {
            C3941a.m5416f("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            interfaceC1616b.onBillingSetupFinished(C1631p.f2981j);
            return;
        }
        this.f2931a = 1;
        C1634s c1634s = this.f2934d;
        C1633r c1633r = c1634s.f2990b;
        Context context = c1634s.f2989a;
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        if (!c1633r.f2987b) {
            context.registerReceiver(c1633r.f2988c.f2990b, intentFilter);
            c1633r.f2987b = true;
        }
        C3941a.m5415e("BillingClient", "Starting in-app billing setup.");
        this.f2937g = new ServiceConnectionC1629n(this, interfaceC1616b);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.f2935e.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty() && (serviceInfo = listQueryIntentServices.get(0).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (!"com.android.vending".equals(str) || str2 == null) {
                C3941a.m5416f("BillingClient", "The device doesn't have valid Play Store.");
            } else {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                intent2.putExtra("playBillingLibraryVersion", this.f2932b);
                if (this.f2935e.bindService(intent2, this.f2937g, 1)) {
                    C3941a.m5415e("BillingClient", "Service was bonded successfully.");
                    return;
                }
                C3941a.m5416f("BillingClient", "Connection to Billing service is blocked.");
            }
        }
        this.f2931a = 0;
        C3941a.m5415e("BillingClient", "Billing service unavailable on device.");
        interfaceC1616b.onBillingSetupFinished(C1631p.f2973b);
    }

    /* JADX INFO: renamed from: i */
    public final Handler m807i() {
        return Looper.myLooper() == null ? this.f2933c : new Handler(Looper.myLooper());
    }

    /* JADX INFO: renamed from: j */
    public final BillingResult m808j(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.f2933c.post(new Runnable() { // from class: b.d.a.a.w
            @Override // java.lang.Runnable
            public final void run() {
                C1614a c1614a = this.f3001j;
                c1614a.f2934d.f2990b.f2986a.onPurchasesUpdated(billingResult, null);
            }
        });
        return billingResult;
    }

    /* JADX INFO: renamed from: k */
    public final BillingResult m809k() {
        return (this.f2931a == 0 || this.f2931a == 3) ? C1631p.f2981j : C1631p.f2979h;
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public final <T> Future<T> m810l(Callable<T> callable, long j, @Nullable final Runnable runnable, Handler handler) {
        long j2 = (long) (j * 0.95d);
        if (this.f2947q == null) {
            this.f2947q = Executors.newFixedThreadPool(C3941a.f10479a, new ThreadFactoryC1626k(this));
        }
        try {
            final Future<T> futureSubmit = this.f2947q.submit(callable);
            handler.postDelayed(new Runnable() { // from class: b.d.a.a.a0
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    Runnable runnable2 = runnable;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    future.cancel(true);
                    C3941a.m5416f("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, j2);
            return futureSubmit;
        } catch (Exception e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("Async task throws exception ");
            sb.append(strValueOf);
            C3941a.m5416f("BillingClient", sb.toString());
            return null;
        }
    }
}
