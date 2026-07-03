package p007b.p225i.p226a.p288f.p313h.p323j;

import p007b.p225i.p226a.p288f.p299e.p302i.AbstractC3336a;
import p007b.p225i.p226a.p288f.p299e.p302i.C3337b;
import p007b.p225i.p226a.p288f.p299e.p302i.C3338c;
import p007b.p225i.p226a.p288f.p299e.p302i.C3339d;
import p007b.p225i.p226a.p288f.p299e.p302i.C3341f;

/* JADX INFO: renamed from: b.i.a.f.h.j.f0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3513f0<V> {

    /* JADX INFO: renamed from: a */
    public final V f9716a;

    public C3513f0(AbstractC3336a<V> abstractC3336a, V v) {
        this.f9716a = v;
    }

    /* JADX INFO: renamed from: a */
    public static C3513f0<Integer> m4445a(String str, int i, int i2) {
        return new C3513f0<>(new C3339d(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: b */
    public static C3513f0<Long> m4446b(String str, long j, long j2) {
        return new C3513f0<>(new C3338c(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    /* JADX INFO: renamed from: c */
    public static C3513f0<String> m4447c(String str, String str2, String str3) {
        return new C3513f0<>(new C3341f(str, str3), str2);
    }

    /* JADX INFO: renamed from: d */
    public static C3513f0<Boolean> m4448d(String str, boolean z2, boolean z3) {
        return new C3513f0<>(new C3337b(str, Boolean.valueOf(z3)), Boolean.valueOf(z2));
    }
}
