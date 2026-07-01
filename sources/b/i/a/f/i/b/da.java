package b.i.a.f.i.b;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import b.i.a.f.h.l.g1;
import b.i.a.f.h.l.h1;
import b.i.a.f.h.l.y0;
import b.i.a.f.h.l.z0;
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
        y0.a aVarF = b.i.a.f.h.l.y0.F();
        if (aVarF.l) {
            aVarF.n();
            aVarF.l = false;
        }
        b.i.a.f.h.l.y0.u((b.i.a.f.h.l.y0) aVarF.k, i);
        boolean z2 = this.f1529b;
        if (aVarF.l) {
            aVarF.n();
            aVarF.l = false;
        }
        b.i.a.f.h.l.y0.w((b.i.a.f.h.l.y0) aVarF.k, z2);
        b.i.a.f.h.l.g1 g1Var = this.c;
        if (g1Var != null) {
            if (aVarF.l) {
                aVarF.n();
                aVarF.l = false;
            }
            b.i.a.f.h.l.y0.z((b.i.a.f.h.l.y0) aVarF.k, g1Var);
        }
        g1.a aVarM = b.i.a.f.h.l.g1.M();
        List<Long> listB = q9.B(this.d);
        if (aVarM.l) {
            aVarM.n();
            aVarM.l = false;
        }
        b.i.a.f.h.l.g1.D((b.i.a.f.h.l.g1) aVarM.k, listB);
        List<Long> listB2 = q9.B(this.e);
        if (aVarM.l) {
            aVarM.n();
            aVarM.l = false;
        }
        b.i.a.f.h.l.g1.y((b.i.a.f.h.l.g1) aVarM.k, listB2);
        if (this.f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f.size());
            Iterator<Integer> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                z0.a aVarA = b.i.a.f.h.l.z0.A();
                if (aVarA.l) {
                    aVarA.n();
                    aVarA.l = false;
                }
                b.i.a.f.h.l.z0.u((b.i.a.f.h.l.z0) aVarA.k, iIntValue);
                long jLongValue = this.f.get(Integer.valueOf(iIntValue)).longValue();
                if (aVarA.l) {
                    aVarA.n();
                    aVarA.l = false;
                }
                b.i.a.f.h.l.z0.v((b.i.a.f.h.l.z0) aVarA.k, jLongValue);
                arrayList.add((b.i.a.f.h.l.z0) ((b.i.a.f.h.l.u4) aVarA.p()));
            }
        }
        if (aVarM.l) {
            aVarM.n();
            aVarM.l = false;
        }
        b.i.a.f.h.l.g1.F((b.i.a.f.h.l.g1) aVarM.k, arrayList);
        if (this.g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.g.size());
            for (Integer num : this.g.keySet()) {
                h1.a aVarB = b.i.a.f.h.l.h1.B();
                int iIntValue2 = num.intValue();
                if (aVarB.l) {
                    aVarB.n();
                    aVarB.l = false;
                }
                b.i.a.f.h.l.h1.v((b.i.a.f.h.l.h1) aVarB.k, iIntValue2);
                List<Long> list = this.g.get(num);
                if (list != null) {
                    Collections.sort(list);
                    if (aVarB.l) {
                        aVarB.n();
                        aVarB.l = false;
                    }
                    b.i.a.f.h.l.h1.w((b.i.a.f.h.l.h1) aVarB.k, list);
                }
                arrayList2.add((b.i.a.f.h.l.h1) ((b.i.a.f.h.l.u4) aVarB.p()));
            }
        }
        if (aVarM.l) {
            aVarM.n();
            aVarM.l = false;
        }
        b.i.a.f.h.l.g1.H((b.i.a.f.h.l.g1) aVarM.k, arrayList2);
        if (aVarF.l) {
            aVarF.n();
            aVarF.l = false;
        }
        b.i.a.f.h.l.y0.v((b.i.a.f.h.l.y0) aVarF.k, (b.i.a.f.h.l.g1) ((b.i.a.f.h.l.u4) aVarM.p()));
        return (b.i.a.f.h.l.y0) ((b.i.a.f.h.l.u4) aVarF.p());
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
