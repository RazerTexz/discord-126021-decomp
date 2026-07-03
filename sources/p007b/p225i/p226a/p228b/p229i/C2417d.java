package p007b.p225i.p226a.p228b.p229i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2427j;
import p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2428k;
import p007b.p225i.p226a.p228b.p229i.p230e.AbstractC2432o;
import p007b.p225i.p226a.p228b.p229i.p230e.C2419b;
import p007b.p225i.p226a.p228b.p229i.p230e.C2420c;
import p007b.p225i.p226a.p228b.p229i.p230e.C2421d;
import p007b.p225i.p226a.p228b.p229i.p230e.C2422e;
import p007b.p225i.p226a.p228b.p229i.p230e.C2423f;
import p007b.p225i.p226a.p228b.p229i.p230e.C2424g;
import p007b.p225i.p226a.p228b.p229i.p230e.C2426i;
import p007b.p225i.p226a.p228b.p229i.p230e.EnumC2433p;
import p007b.p225i.p226a.p228b.p231j.AbstractC2439f;
import p007b.p225i.p226a.p228b.p231j.C2438e;
import p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2455f;
import p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2456g;
import p007b.p225i.p226a.p228b.p231j.p232q.C2450a;
import p007b.p225i.p226a.p228b.p231j.p232q.C2451b;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2462m;
import p007b.p225i.p226a.p228b.p231j.p235s.InterfaceC2465a;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p007b.p225i.p361c.p393p.InterfaceC4782a;
import p007b.p225i.p361c.p393p.p395h.C4793d;
import p007b.p225i.p361c.p393p.p395h.C4794e;

/* JADX INFO: renamed from: b.i.a.b.i.d */
/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2417d implements InterfaceC2462m {

    /* JADX INFO: renamed from: a */
    public final InterfaceC4782a f5132a;

    /* JADX INFO: renamed from: b */
    public final ConnectivityManager f5133b;

    /* JADX INFO: renamed from: c */
    public final Context f5134c;

    /* JADX INFO: renamed from: d */
    public final URL f5135d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2519a f5136e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC2519a f5137f;

    /* JADX INFO: renamed from: g */
    public final int f5138g;

    /* JADX INFO: renamed from: b.i.a.b.i.d$a */
    /* JADX INFO: compiled from: CctTransportBackend.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final URL f5139a;

        /* JADX INFO: renamed from: b */
        public final AbstractC2427j f5140b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public final String f5141c;

        public a(URL url, AbstractC2427j abstractC2427j, @Nullable String str) {
            this.f5139a = url;
            this.f5140b = abstractC2427j;
            this.f5141c = str;
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.d$b */
    /* JADX INFO: compiled from: CctTransportBackend.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f5142a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final URL f5143b;

        /* JADX INFO: renamed from: c */
        public final long f5144c;

        public b(int i, @Nullable URL url, long j) {
            this.f5142a = i;
            this.f5143b = url;
            this.f5144c = j;
        }
    }

    public C2417d(Context context, InterfaceC2519a interfaceC2519a, InterfaceC2519a interfaceC2519a2) {
        C4794e c4794e = new C4794e();
        ((C2419b) C2419b.f5145a).m2311a(c4794e);
        c4794e.f12825e = true;
        this.f5132a = new C4793d(c4794e);
        this.f5134c = context;
        this.f5133b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f5135d = m2296c(C2414a.f5123a);
        this.f5136e = interfaceC2519a2;
        this.f5137f = interfaceC2519a;
        this.f5138g = 40000;
    }

    /* JADX INFO: renamed from: c */
    public static URL m2296c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(C1643a.m883w("Invalid url: ", str), e);
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2462m
    /* JADX INFO: renamed from: a */
    public AbstractC2456g mo2297a(AbstractC2455f abstractC2455f) {
        AbstractC2456g.a aVar;
        Integer numValueOf;
        String str;
        C2423f.b bVar;
        AbstractC2456g.a aVar2 = AbstractC2456g.a.TRANSIENT_ERROR;
        HashMap map = new HashMap();
        C2450a c2450a = (C2450a) abstractC2455f;
        for (AbstractC2439f abstractC2439f : c2450a.f5300a) {
            String strMo2340g = abstractC2439f.mo2340g();
            if (map.containsKey(strMo2340g)) {
                ((List) map.get(strMo2340g)).add(abstractC2439f);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(abstractC2439f);
                map.put(strMo2340g, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            String str2 = null;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                AbstractC2439f abstractC2439f2 = (AbstractC2439f) ((List) entry.getValue()).get(0);
                EnumC2433p enumC2433p = EnumC2433p.DEFAULT;
                Long lValueOf = Long.valueOf(this.f5137f.mo2413a());
                Long lValueOf2 = Long.valueOf(this.f5136e.mo2413a());
                C2422e c2422e = new C2422e(AbstractC2428k.a.ANDROID_FIREBASE, new C2420c(Integer.valueOf(abstractC2439f2.m2355f("sdk-version")), abstractC2439f2.m2354a("model"), abstractC2439f2.m2354a("hardware"), abstractC2439f2.m2354a("device"), abstractC2439f2.m2354a("product"), abstractC2439f2.m2354a("os-uild"), abstractC2439f2.m2354a("manufacturer"), abstractC2439f2.m2354a("fingerprint"), abstractC2439f2.m2354a("locale"), abstractC2439f2.m2354a("country"), abstractC2439f2.m2354a("mcc_mnc"), abstractC2439f2.m2354a("application_build"), null), null);
                try {
                    str = null;
                    numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                } catch (NumberFormatException unused) {
                    numValueOf = null;
                    str = (String) entry.getKey();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    AbstractC2439f abstractC2439f3 = (AbstractC2439f) it2.next();
                    C2438e c2438eMo2338d = abstractC2439f3.mo2338d();
                    Iterator it3 = it;
                    C2407b c2407b = c2438eMo2338d.f5276a;
                    Iterator it4 = it2;
                    if (c2407b.equals(new C2407b("proto"))) {
                        byte[] bArr = c2438eMo2338d.f5277b;
                        bVar = new C2423f.b();
                        bVar.f5177d = bArr;
                    } else {
                        if (c2407b.equals(new C2407b("json"))) {
                            String str3 = new String(c2438eMo2338d.f5277b, Charset.forName(Constants.ENCODING));
                            bVar = new C2423f.b();
                            bVar.f5178e = str3;
                        } else {
                            Log.w(C1460d.m427D0("CctTransportBackend"), String.format("Received event of unsupported encoding %s. Skipping...", c2407b));
                        }
                        it2 = it4;
                        it = it3;
                        aVar2 = aVar2;
                    }
                    bVar.f5174a = Long.valueOf(abstractC2439f3.mo2339e());
                    bVar.f5176c = Long.valueOf(abstractC2439f3.mo2341h());
                    String str4 = abstractC2439f3.mo2336b().get("tz-offset");
                    bVar.f5179f = Long.valueOf(str4 == null ? 0L : Long.valueOf(str4).longValue());
                    bVar.f5180g = new C2426i(AbstractC2432o.b.f5219C.get(abstractC2439f3.m2355f("net-type")), AbstractC2432o.a.f5198E.get(abstractC2439f3.m2355f("mobile-subtype")), null);
                    if (abstractC2439f3.mo2337c() != null) {
                        bVar.f5175b = abstractC2439f3.mo2337c();
                    }
                    String strM883w = bVar.f5174a == null ? " eventTimeMs" : "";
                    if (bVar.f5176c == null) {
                        strM883w = C1643a.m883w(strM883w, " eventUptimeMs");
                    }
                    if (bVar.f5179f == null) {
                        strM883w = C1643a.m883w(strM883w, " timezoneOffsetSeconds");
                    }
                    if (!strM883w.isEmpty()) {
                        throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
                    }
                    arrayList3.add(new C2423f(bVar.f5174a.longValue(), bVar.f5175b, bVar.f5176c.longValue(), bVar.f5177d, bVar.f5178e, bVar.f5179f.longValue(), bVar.f5180g, null));
                    it2 = it4;
                    it = it3;
                    aVar2 = aVar2;
                }
                Iterator it5 = it;
                AbstractC2456g.a aVar3 = aVar2;
                String strM883w2 = lValueOf == null ? " requestTimeMs" : "";
                if (lValueOf2 == null) {
                    strM883w2 = C1643a.m883w(strM883w2, " requestUptimeMs");
                }
                if (!strM883w2.isEmpty()) {
                    throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w2));
                }
                arrayList2.add(new C2424g(lValueOf.longValue(), lValueOf2.longValue(), c2422e, numValueOf, str, arrayList3, enumC2433p, null));
                it = it5;
                aVar2 = aVar3;
            } else {
                AbstractC2456g.a aVar4 = aVar2;
                C2421d c2421d = new C2421d(arrayList2);
                URL urlM2296c = this.f5135d;
                if (c2450a.f5301b != null) {
                    try {
                        C2414a c2414aM2293a = C2414a.m2293a(((C2450a) abstractC2455f).f5301b);
                        String str5 = c2414aM2293a.f5129g;
                        str2 = str5 != null ? str5 : null;
                        String str6 = c2414aM2293a.f5128f;
                        if (str6 != null) {
                            urlM2296c = m2296c(str6);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return AbstractC2456g.m2370a();
                    }
                }
                try {
                    b bVar2 = (b) C1460d.m482V1(5, new a(urlM2296c, c2421d, str2), new C2415b(this), new InterfaceC2465a() { // from class: b.i.a.b.i.c
                    });
                    int i = bVar2.f5142a;
                    if (i == 200) {
                        return new C2451b(AbstractC2456g.a.OK, bVar2.f5144c);
                    }
                    if (i < 500 && i != 404) {
                        return AbstractC2456g.m2370a();
                    }
                    aVar = aVar4;
                    try {
                        return new C2451b(aVar, -1L);
                    } catch (IOException e) {
                        e = e;
                        C1460d.m504c0("CctTransportBackend", "Could not make request to the backend", e);
                        return new C2451b(aVar, -1L);
                    }
                } catch (IOException e2) {
                    e = e2;
                    aVar = aVar4;
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2462m
    /* JADX INFO: renamed from: b */
    public AbstractC2439f mo2298b(AbstractC2439f abstractC2439f) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f5133b.getActiveNetworkInfo();
        AbstractC2439f.a aVarM2356i = abstractC2439f.m2356i();
        aVarM2356i.mo2343c().put("sdk-version", String.valueOf(Build.VERSION.SDK_INT));
        aVarM2356i.mo2343c().put("model", Build.MODEL);
        aVarM2356i.mo2343c().put("hardware", Build.HARDWARE);
        aVarM2356i.mo2343c().put("device", Build.DEVICE);
        aVarM2356i.mo2343c().put("product", Build.PRODUCT);
        aVarM2356i.mo2343c().put("os-uild", Build.ID);
        aVarM2356i.mo2343c().put("manufacturer", Build.MANUFACTURER);
        aVarM2356i.mo2343c().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        aVarM2356i.mo2343c().put("tz-offset", String.valueOf(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        aVarM2356i.mo2343c().put("net-type", String.valueOf(activeNetworkInfo == null ? AbstractC2432o.b.NONE.m2335f() : activeNetworkInfo.getType()));
        int i = -1;
        if (activeNetworkInfo == null) {
            subtype = AbstractC2432o.a.UNKNOWN_MOBILE_SUBTYPE.m2334f();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = AbstractC2432o.a.COMBINED.m2334f();
            } else if (AbstractC2432o.a.f5198E.get(subtype) == null) {
                subtype = 0;
            }
        }
        aVarM2356i.mo2343c().put("mobile-subtype", String.valueOf(subtype));
        aVarM2356i.mo2343c().put("country", Locale.getDefault().getCountry());
        aVarM2356i.mo2343c().put("locale", Locale.getDefault().getLanguage());
        aVarM2356i.mo2343c().put("mcc_mnc", ((TelephonyManager) this.f5134c.getSystemService("phone")).getSimOperator());
        Context context = this.f5134c;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            C1460d.m504c0("CctTransportBackend", "Unable to find version code for package", e);
        }
        aVarM2356i.mo2343c().put("application_build", Integer.toString(i));
        return aVarM2356i.mo2342b();
    }
}
