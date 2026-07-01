package b.i.a.f.h.j;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public final g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Boolean f1430b;
    public String c;
    public Set<Integer> d;

    public z(g gVar) {
        this.a = gVar;
    }

    public static long b() {
        return e0.e.a.longValue();
    }

    public static int c() {
        return e0.g.a.intValue();
    }

    public static String d() {
        return e0.j.a;
    }

    public static String e() {
        return e0.i.a;
    }

    public static String f() {
        return e0.k.a;
    }

    public final boolean a() {
        if (this.f1430b == null) {
            synchronized (this) {
                if (this.f1430b == null) {
                    ApplicationInfo applicationInfo = this.a.f1417b.getApplicationInfo();
                    String strA = b.i.a.f.e.o.g.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f1430b = Boolean.valueOf(str != null && str.equals(strA));
                    }
                    if ((this.f1430b == null || !this.f1430b.booleanValue()) && "com.google.android.gms.analytics".equals(strA)) {
                        this.f1430b = Boolean.TRUE;
                    }
                    if (this.f1430b == null) {
                        this.f1430b = Boolean.TRUE;
                        this.a.c().H("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f1430b.booleanValue();
    }

    public final Set<Integer> g() {
        String str;
        String str2 = e0.f1412s.a;
        if (this.d == null || (str = this.c) == null || !str.equals(str2)) {
            String[] strArrSplit = TextUtils.split(str2, ",");
            HashSet hashSet = new HashSet();
            for (String str3 : strArrSplit) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str3)));
                } catch (NumberFormatException unused) {
                }
            }
            this.c = str2;
            this.d = hashSet;
        }
        return this.d;
    }
}
