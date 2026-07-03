package p007b.p085c.p086a;

import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p095y.C1565d;
import p007b.p085c.p086a.p095y.C1566e;
import p007b.p085c.p086a.p095y.C1570i;
import p007b.p085c.p086a.p095y.p098m.C1606e;

/* JADX INFO: renamed from: b.c.a.d */
/* JADX INFO: compiled from: LottieComposition.java */
/* JADX INFO: loaded from: classes.dex */
public class C1505d {

    /* JADX INFO: renamed from: c */
    public Map<String, List<C1606e>> f2338c;

    /* JADX INFO: renamed from: d */
    public Map<String, C1512k> f2339d;

    /* JADX INFO: renamed from: e */
    public Map<String, C1565d> f2340e;

    /* JADX INFO: renamed from: f */
    public List<C1570i> f2341f;

    /* JADX INFO: renamed from: g */
    public SparseArrayCompat<C1566e> f2342g;

    /* JADX INFO: renamed from: h */
    public LongSparseArray<C1606e> f2343h;

    /* JADX INFO: renamed from: i */
    public List<C1606e> f2344i;

    /* JADX INFO: renamed from: j */
    public Rect f2345j;

    /* JADX INFO: renamed from: k */
    public float f2346k;

    /* JADX INFO: renamed from: l */
    public float f2347l;

    /* JADX INFO: renamed from: m */
    public float f2348m;

    /* JADX INFO: renamed from: n */
    public boolean f2349n;

    /* JADX INFO: renamed from: a */
    public final C1520s f2336a = new C1520s();

    /* JADX INFO: renamed from: b */
    public final HashSet<String> f2337b = new HashSet<>();

    /* JADX INFO: renamed from: o */
    public int f2350o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: a */
    public void m669a(String str) {
        C1495c.m640b(str);
        this.f2337b.add(str);
    }

    /* JADX INFO: renamed from: b */
    public float m670b() {
        return (long) ((m671c() / this.f2348m) * 1000.0f);
    }

    /* JADX INFO: renamed from: c */
    public float m671c() {
        return this.f2347l - this.f2346k;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003d  */
    @Nullable
    /* JADX INFO: renamed from: d */
    public C1570i m672d(String str) {
        this.f2341f.size();
        for (int i = 0; i < this.f2341f.size(); i++) {
            C1570i c1570i = this.f2341f.get(i);
            boolean z2 = true;
            if (!c1570i.f2717a.equalsIgnoreCase(str)) {
                if (c1570i.f2717a.endsWith("\r")) {
                    String str2 = c1570i.f2717a;
                    if (!str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return c1570i;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: e */
    public C1606e m673e(long j) {
        return this.f2343h.get(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<C1606e> it = this.f2344i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().m788a("\t"));
        }
        return sb.toString();
    }
}
