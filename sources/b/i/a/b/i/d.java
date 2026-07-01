package b.i.a.b.i;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build$VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;
import b.i.a.b.i.e.f$b;
import b.i.a.b.i.e.i;
import b.i.a.b.i.e.k$a;
import b.i.a.b.i.e.o$a;
import b.i.a.b.i.e.o$b;
import b.i.a.b.i.e.p;
import b.i.a.b.j.f$a;
import b.i.a.b.j.q.f;
import b.i.a.b.j.q.g;
import b.i.a.b.j.q.g$a;
import b.i.a.b.j.q.m;
import b.i.c.p.h.e;
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
import java.util.Map$Entry;
import java.util.TimeZone;

/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements m {
    public final b.i.c.p.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f744b;
    public final Context c;
    public final URL d;
    public final b.i.a.b.j.v.a e;
    public final b.i.a.b.j.v.a f;
    public final int g;

    public d(Context context, b.i.a.b.j.v.a aVar, b.i.a.b.j.v.a aVar2) {
        e eVar = new e();
        ((b.i.a.b.i.e.b) b.i.a.b.i.e.b.a).a(eVar);
        eVar.e = true;
        this.a = new b.i.c.p.h.d(eVar);
        this.c = context;
        this.f744b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = c(a.a);
        this.e = aVar2;
        this.f = aVar;
        this.g = 40000;
    }

    public static URL c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(b.d.b.a.a.w("Invalid url: ", str), e);
        }
    }

    @Override // b.i.a.b.j.q.m
    public g a(f fVar) {
        g$a g_a;
        Integer numValueOf;
        String str;
        f$b f_b;
        g$a g_a2 = g$a.TRANSIENT_ERROR;
        HashMap map = new HashMap();
        b.i.a.b.j.q.a aVar = (b.i.a.b.j.q.a) fVar;
        for (b.i.a.b.j.f fVar2 : aVar.a) {
            String strG = fVar2.g();
            if (map.containsKey(strG)) {
                ((List) map.get(strG)).add(fVar2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(fVar2);
                map.put(strG, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            String str2 = null;
            if (it.hasNext()) {
                Map$Entry map$Entry = (Map$Entry) it.next();
                b.i.a.b.j.f fVar3 = (b.i.a.b.j.f) ((List) map$Entry.getValue()).get(0);
                p pVar = p.DEFAULT;
                Long lValueOf = Long.valueOf(this.f.a());
                Long lValueOf2 = Long.valueOf(this.e.a());
                b.i.a.b.i.e.e eVar = new b.i.a.b.i.e.e(k$a.ANDROID_FIREBASE, new b.i.a.b.i.e.c(Integer.valueOf(fVar3.f("sdk-version")), fVar3.a("model"), fVar3.a("hardware"), fVar3.a("device"), fVar3.a("product"), fVar3.a("os-uild"), fVar3.a("manufacturer"), fVar3.a("fingerprint"), fVar3.a("locale"), fVar3.a("country"), fVar3.a("mcc_mnc"), fVar3.a("application_build"), null), null);
                try {
                    str = null;
                    numValueOf = Integer.valueOf(Integer.parseInt((String) map$Entry.getKey()));
                } catch (NumberFormatException unused) {
                    numValueOf = null;
                    str = (String) map$Entry.getKey();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) map$Entry.getValue()).iterator();
                while (it2.hasNext()) {
                    b.i.a.b.j.f fVar4 = (b.i.a.b.j.f) it2.next();
                    b.i.a.b.j.e eVarD = fVar4.d();
                    Iterator it3 = it;
                    b.i.a.b.b bVar = eVarD.a;
                    Iterator it4 = it2;
                    if (bVar.equals(new b.i.a.b.b("proto"))) {
                        byte[] bArr = eVarD.f766b;
                        f_b = new f$b();
                        f_b.d = bArr;
                    } else {
                        if (bVar.equals(new b.i.a.b.b("json"))) {
                            String str3 = new String(eVarD.f766b, Charset.forName(Constants.ENCODING));
                            f_b = new f$b();
                            f_b.e = str3;
                        } else {
                            Log.w(b.c.a.a0.d.D0("CctTransportBackend"), String.format("Received event of unsupported encoding %s. Skipping...", bVar));
                        }
                        it2 = it4;
                        it = it3;
                        g_a2 = g_a2;
                    }
                    f_b.a = Long.valueOf(fVar4.e());
                    f_b.c = Long.valueOf(fVar4.h());
                    String str4 = fVar4.b().get("tz-offset");
                    f_b.f = Long.valueOf(str4 == null ? 0L : Long.valueOf(str4).longValue());
                    f_b.g = new i(o$b.C.get(fVar4.f("net-type")), o$a.E.get(fVar4.f("mobile-subtype")), null);
                    if (fVar4.c() != null) {
                        f_b.f750b = fVar4.c();
                    }
                    String strW = f_b.a == null ? " eventTimeMs" : "";
                    if (f_b.c == null) {
                        strW = b.d.b.a.a.w(strW, " eventUptimeMs");
                    }
                    if (f_b.f == null) {
                        strW = b.d.b.a.a.w(strW, " timezoneOffsetSeconds");
                    }
                    if (!strW.isEmpty()) {
                        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
                    }
                    arrayList3.add(new b.i.a.b.i.e.f(f_b.a.longValue(), f_b.f750b, f_b.c.longValue(), f_b.d, f_b.e, f_b.f.longValue(), f_b.g, null));
                    it2 = it4;
                    it = it3;
                    g_a2 = g_a2;
                }
                Iterator it5 = it;
                g$a g_a3 = g_a2;
                String strW2 = lValueOf == null ? " requestTimeMs" : "";
                if (lValueOf2 == null) {
                    strW2 = b.d.b.a.a.w(strW2, " requestUptimeMs");
                }
                if (!strW2.isEmpty()) {
                    throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW2));
                }
                arrayList2.add(new b.i.a.b.i.e.g(lValueOf.longValue(), lValueOf2.longValue(), eVar, numValueOf, str, arrayList3, pVar, null));
                it = it5;
                g_a2 = g_a3;
            } else {
                g$a g_a4 = g_a2;
                b.i.a.b.i.e.d dVar = new b.i.a.b.i.e.d(arrayList2);
                URL urlC = this.d;
                if (aVar.f771b != null) {
                    try {
                        a aVarA = a.a(((b.i.a.b.j.q.a) fVar).f771b);
                        String str5 = aVarA.g;
                        str2 = str5 != null ? str5 : null;
                        String str6 = aVarA.f;
                        if (str6 != null) {
                            urlC = c(str6);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return g.a();
                    }
                }
                try {
                    d$b d_b = (d$b) b.c.a.a0.d.V1(5, new d$a(urlC, dVar, str2), new b(this), c.a);
                    int i = d_b.a;
                    if (i == 200) {
                        return new b.i.a.b.j.q.b(g$a.OK, d_b.c);
                    }
                    if (i < 500 && i != 404) {
                        return g.a();
                    }
                    g_a = g_a4;
                    try {
                        return new b.i.a.b.j.q.b(g_a, -1L);
                    } catch (IOException e) {
                        e = e;
                        b.c.a.a0.d.c0("CctTransportBackend", "Could not make request to the backend", e);
                        return new b.i.a.b.j.q.b(g_a, -1L);
                    }
                } catch (IOException e2) {
                    e = e2;
                    g_a = g_a4;
                }
            }
        }
    }

    @Override // b.i.a.b.j.q.m
    public b.i.a.b.j.f b(b.i.a.b.j.f fVar) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f744b.getActiveNetworkInfo();
        f$a f_aI = fVar.i();
        f_aI.c().put("sdk-version", String.valueOf(Build$VERSION.SDK_INT));
        f_aI.c().put("model", Build.MODEL);
        f_aI.c().put("hardware", Build.HARDWARE);
        f_aI.c().put("device", Build.DEVICE);
        f_aI.c().put("product", Build.PRODUCT);
        f_aI.c().put("os-uild", Build.ID);
        f_aI.c().put("manufacturer", Build.MANUFACTURER);
        f_aI.c().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        f_aI.c().put("tz-offset", String.valueOf(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        f_aI.c().put("net-type", String.valueOf(activeNetworkInfo == null ? o$b.NONE.f() : activeNetworkInfo.getType()));
        int i = -1;
        if (activeNetworkInfo == null) {
            subtype = o$a.UNKNOWN_MOBILE_SUBTYPE.f();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = o$a.COMBINED.f();
            } else if (o$a.E.get(subtype) == null) {
                subtype = 0;
            }
        }
        f_aI.c().put("mobile-subtype", String.valueOf(subtype));
        f_aI.c().put("country", Locale.getDefault().getCountry());
        f_aI.c().put("locale", Locale.getDefault().getLanguage());
        f_aI.c().put("mcc_mnc", ((TelephonyManager) this.c.getSystemService("phone")).getSimOperator());
        Context context = this.c;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager$NameNotFoundException e) {
            b.c.a.a0.d.c0("CctTransportBackend", "Unable to find version code for package", e);
        }
        f_aI.c().put("application_build", Integer.toString(i));
        return f_aI.b();
    }
}
