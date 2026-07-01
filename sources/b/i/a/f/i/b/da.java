package b.i.a.f.i.b;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import b.i.a.f.h.l.g1$a;
import b.i.a.f.h.l.h1$a;
import b.i.a.f.h.l.y0$a;
import b.i.a.f.h.l.z0$a;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class da {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1529b;
    public b.i.a.f.h.l.g1 c;
    public BitSet d;
    public BitSet e;
    public Map<Integer, Long> f;
    public Map<Integer, List<Long>> g;
    public final /* synthetic */ ba h;

    public da(ba baVar, String str, aa aaVar) {
        this.h = baVar;
        this.a = str;
        this.f1529b = true;
        this.d = new BitSet();
        this.e = new BitSet();
        this.f = new ArrayMap();
        this.g = new ArrayMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    @NonNull
    public final b.i.a.f.h.l.y0 a(int i) {
        ArrayList arrayList;
        ?? arrayList2;
        y0$a y0_aF = b.i.a.f.h.l.y0.F();
        if (y0_aF.l) {
            y0_aF.n();
            y0_aF.l = false;
        }
        b.i.a.f.h.l.y0.u((b.i.a.f.h.l.y0) y0_aF.k, i);
        boolean z2 = this.f1529b;
        if (y0_aF.l) {
            y0_aF.n();
            y0_aF.l = false;
        }
        b.i.a.f.h.l.y0.w((b.i.a.f.h.l.y0) y0_aF.k, z2);
        b.i.a.f.h.l.g1 g1Var = this.c;
        if (g1Var != null) {
            if (y0_aF.l) {
                y0_aF.n();
                y0_aF.l = false;
            }
            b.i.a.f.h.l.y0.z((b.i.a.f.h.l.y0) y0_aF.k, g1Var);
        }
        g1$a g1_aM = b.i.a.f.h.l.g1.M();
        List<Long> listB = q9.B(this.d);
        if (g1_aM.l) {
            g1_aM.n();
            g1_aM.l = false;
        }
        b.i.a.f.h.l.g1.D((b.i.a.f.h.l.g1) g1_aM.k, listB);
        List<Long> listB2 = q9.B(this.e);
        if (g1_aM.l) {
            g1_aM.n();
            g1_aM.l = false;
        }
        b.i.a.f.h.l.g1.y((b.i.a.f.h.l.g1) g1_aM.k, listB2);
        if (this.f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f.size());
            Iterator<Integer> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                z0$a z0_aA = b.i.a.f.h.l.z0.A();
                if (z0_aA.l) {
                    z0_aA.n();
                    z0_aA.l = false;
                }
                b.i.a.f.h.l.z0.u((b.i.a.f.h.l.z0) z0_aA.k, iIntValue);
                long jLongValue = this.f.get(Integer.valueOf(iIntValue)).longValue();
                if (z0_aA.l) {
                    z0_aA.n();
                    z0_aA.l = false;
                }
                b.i.a.f.h.l.z0.v((b.i.a.f.h.l.z0) z0_aA.k, jLongValue);
                arrayList.add((b.i.a.f.h.l.z0) ((b.i.a.f.h.l.u4) z0_aA.p()));
            }
        }
        if (g1_aM.l) {
            g1_aM.n();
            g1_aM.l = false;
        }
        b.i.a.f.h.l.g1.F((b.i.a.f.h.l.g1) g1_aM.k, arrayList);
        if (this.g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.g.size());
            for (Integer num : this.g.keySet()) {
                h1$a h1_aB = b.i.a.f.h.l.h1.B();
                int iIntValue2 = num.intValue();
                if (h1_aB.l) {
                    h1_aB.n();
                    h1_aB.l = false;
                }
                b.i.a.f.h.l.h1.v((b.i.a.f.h.l.h1) h1_aB.k, iIntValue2);
                List<Long> list = this.g.get(num);
                if (list != null) {
                    Collections.sort(list);
                    if (h1_aB.l) {
                        h1_aB.n();
                        h1_aB.l = false;
                    }
                    b.i.a.f.h.l.h1.w((b.i.a.f.h.l.h1) h1_aB.k, list);
                }
                arrayList2.add((b.i.a.f.h.l.h1) ((b.i.a.f.h.l.u4) h1_aB.p()));
            }
        }
        if (g1_aM.l) {
            g1_aM.n();
            g1_aM.l = false;
        }
        b.i.a.f.h.l.g1.H((b.i.a.f.h.l.g1) g1_aM.k, arrayList2);
        if (y0_aF.l) {
            y0_aF.n();
            y0_aF.l = false;
        }
        b.i.a.f.h.l.y0.v((b.i.a.f.h.l.y0) y0_aF.k, (b.i.a.f.h.l.g1) ((b.i.a.f.h.l.u4) g1_aM.p()));
        return (b.i.a.f.h.l.y0) ((b.i.a.f.h.l.u4) y0_aF.p());
    }

    public final void b(@NonNull ea eaVar) {
        int iA = eaVar.a();
        Boolean bool = eaVar.c;
        if (bool != null) {
            this.e.set(iA, bool.booleanValue());
        }
        Boolean bool2 = eaVar.d;
        if (bool2 != null) {
            this.d.set(iA, bool2.booleanValue());
        }
        if (eaVar.e != null) {
            Long l = this.f.get(Integer.valueOf(iA));
            long jLongValue = eaVar.e.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.f.put(Integer.valueOf(iA), Long.valueOf(jLongValue));
            }
        }
        if (eaVar.f != null) {
            List<Long> arrayList = this.g.get(Integer.valueOf(iA));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.g.put(Integer.valueOf(iA), arrayList);
            }
            if (eaVar.g()) {
                arrayList.clear();
            }
            if (b.i.a.f.h.l.f9.b() && this.h.a.h.u(this.a, p.f1554c0) && eaVar.h()) {
                arrayList.clear();
            }
            if (!b.i.a.f.h.l.f9.b() || !this.h.a.h.u(this.a, p.f1554c0)) {
                arrayList.add(Long.valueOf(eaVar.f.longValue() / 1000));
                return;
            }
            long jLongValue2 = eaVar.f.longValue() / 1000;
            if (arrayList.contains(Long.valueOf(jLongValue2))) {
                return;
            }
            arrayList.add(Long.valueOf(jLongValue2));
        }
    }

    public da(ba baVar, String str, b.i.a.f.h.l.g1 g1Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, aa aaVar) {
        this.h = baVar;
        this.a = str;
        this.d = bitSet;
        this.e = bitSet2;
        this.f = map;
        this.g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.g.put(num, arrayList);
        }
        this.f1529b = false;
        this.c = g1Var;
    }
}
