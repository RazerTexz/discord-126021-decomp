package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;
import p007b.p109f.p115d.p122g.C1697d;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.j.l.w */
/* JADX INFO: compiled from: PoolConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1951w {

    /* JADX INFO: renamed from: a */
    public final C1953y f3958a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1954z f3959b;

    /* JADX INFO: renamed from: c */
    public final C1953y f3960c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1696c f3961d;

    /* JADX INFO: renamed from: e */
    public final C1953y f3962e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1954z f3963f;

    /* JADX INFO: renamed from: g */
    public final C1953y f3964g;

    /* JADX INFO: renamed from: h */
    public final InterfaceC1954z f3965h;

    /* JADX INFO: renamed from: i */
    public final String f3966i;

    /* JADX INFO: renamed from: j */
    public final int f3967j;

    /* JADX INFO: renamed from: b.f.j.l.w$b */
    /* JADX INFO: compiled from: PoolConfig.java */
    public static class b {
        public b(a aVar) {
        }
    }

    public C1951w(b bVar, a aVar) {
        C2030b.m1527b();
        this.f3958a = C1938j.m1390a();
        this.f3959b = C1950v.m1398h();
        int i = C1939k.f3942a;
        int i2 = i * 4194304;
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i3 = 131072; i3 <= 4194304; i3 *= 2) {
            sparseIntArray.put(i3, i);
        }
        this.f3960c = new C1953y(4194304, i2, sparseIntArray, 131072, 4194304, C1939k.f3942a);
        this.f3961d = C1697d.m990b();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray2.put(1024, 5);
        sparseIntArray2.put(2048, 5);
        sparseIntArray2.put(4096, 5);
        sparseIntArray2.put(8192, 5);
        sparseIntArray2.put(16384, 5);
        sparseIntArray2.put(32768, 5);
        sparseIntArray2.put(65536, 5);
        sparseIntArray2.put(131072, 5);
        sparseIntArray2.put(262144, 2);
        sparseIntArray2.put(524288, 2);
        sparseIntArray2.put(1048576, 2);
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        int i4 = iMin < 16777216 ? 3145728 : iMin < 33554432 ? 6291456 : 12582912;
        int iMin2 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        this.f3962e = new C1953y(i4, iMin2 < 16777216 ? iMin2 / 2 : (iMin2 / 4) * 3, sparseIntArray2);
        this.f3963f = C1950v.m1398h();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        sparseIntArray3.put(16384, 5);
        this.f3964g = new C1953y(81920, 1048576, sparseIntArray3);
        this.f3965h = C1950v.m1398h();
        this.f3966i = "legacy";
        this.f3967j = 4194304;
        C2030b.m1527b();
    }
}
