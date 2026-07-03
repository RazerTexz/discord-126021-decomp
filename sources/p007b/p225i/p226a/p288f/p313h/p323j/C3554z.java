package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p308o.C3405g;

/* JADX INFO: renamed from: b.i.a.f.h.j.z */
/* JADX INFO: loaded from: classes3.dex */
public final class C3554z {

    /* JADX INFO: renamed from: a */
    public final C3515g f9826a;

    /* JADX INFO: renamed from: b */
    public volatile Boolean f9827b;

    /* JADX INFO: renamed from: c */
    public String f9828c;

    /* JADX INFO: renamed from: d */
    public Set<Integer> f9829d;

    public C3554z(C3515g c3515g) {
        this.f9826a = c3515g;
    }

    /* JADX INFO: renamed from: b */
    public static long m4508b() {
        return C3510e0.f9693e.f9716a.longValue();
    }

    /* JADX INFO: renamed from: c */
    public static int m4509c() {
        return C3510e0.f9695g.f9716a.intValue();
    }

    /* JADX INFO: renamed from: d */
    public static String m4510d() {
        return C3510e0.f9698j.f9716a;
    }

    /* JADX INFO: renamed from: e */
    public static String m4511e() {
        return C3510e0.f9697i.f9716a;
    }

    /* JADX INFO: renamed from: f */
    public static String m4512f() {
        return C3510e0.f9699k.f9716a;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4513a() {
        if (this.f9827b == null) {
            synchronized (this) {
                if (this.f9827b == null) {
                    ApplicationInfo applicationInfo = this.f9826a.f9722b.getApplicationInfo();
                    String strM4370a = C3405g.m4370a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f9827b = Boolean.valueOf(str != null && str.equals(strM4370a));
                    }
                    if ((this.f9827b == null || !this.f9827b.booleanValue()) && "com.google.android.gms.analytics".equals(strM4370a)) {
                        this.f9827b = Boolean.TRUE;
                    }
                    if (this.f9827b == null) {
                        this.f9827b = Boolean.TRUE;
                        this.f9826a.m4451c().m4429H("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f9827b.booleanValue();
    }

    /* JADX INFO: renamed from: g */
    public final Set<Integer> m4514g() {
        String str;
        String str2 = C3510e0.f9707s.f9716a;
        if (this.f9829d == null || (str = this.f9828c) == null || !str.equals(str2)) {
            String[] strArrSplit = TextUtils.split(str2, ",");
            HashSet hashSet = new HashSet();
            for (String str3 : strArrSplit) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str3)));
                } catch (NumberFormatException unused) {
                }
            }
            this.f9828c = str2;
            this.f9829d = hashSet;
        }
        return this.f9829d;
    }
}
