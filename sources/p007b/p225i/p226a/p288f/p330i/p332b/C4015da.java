package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3657f9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3663g1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3677h1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3899y0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3912z0;

/* JADX INFO: renamed from: b.i.a.f.i.b.da */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4015da {

    /* JADX INFO: renamed from: a */
    public String f10672a;

    /* JADX INFO: renamed from: b */
    public boolean f10673b;

    /* JADX INFO: renamed from: c */
    public C3663g1 f10674c;

    /* JADX INFO: renamed from: d */
    public BitSet f10675d;

    /* JADX INFO: renamed from: e */
    public BitSet f10676e;

    /* JADX INFO: renamed from: f */
    public Map<Integer, Long> f10677f;

    /* JADX INFO: renamed from: g */
    public Map<Integer, List<Long>> f10678g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ C3991ba f10679h;

    public C4015da(C3991ba c3991ba, String str, C3979aa c3979aa) {
        this.f10679h = c3991ba;
        this.f10672a = str;
        this.f10673b = true;
        this.f10675d = new BitSet();
        this.f10676e = new BitSet();
        this.f10677f = new ArrayMap();
        this.f10678g = new ArrayMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    @NonNull
    /* JADX INFO: renamed from: a */
    public final C3899y0 m5586a(int i) {
        ArrayList arrayList;
        ?? arrayList2;
        C3899y0.a aVarM5363F = C3899y0.m5363F();
        if (aVarM5363F.f10348l) {
            aVarM5363F.m5318n();
            aVarM5363F.f10348l = false;
        }
        C3899y0.m5365u((C3899y0) aVarM5363F.f10347k, i);
        boolean z2 = this.f10673b;
        if (aVarM5363F.f10348l) {
            aVarM5363F.m5318n();
            aVarM5363F.f10348l = false;
        }
        C3899y0.m5367w((C3899y0) aVarM5363F.f10347k, z2);
        C3663g1 c3663g1 = this.f10674c;
        if (c3663g1 != null) {
            if (aVarM5363F.f10348l) {
                aVarM5363F.m5318n();
                aVarM5363F.f10348l = false;
            }
            C3899y0.m5368z((C3899y0) aVarM5363F.f10347k, c3663g1);
        }
        C3663g1.a aVarM4893M = C3663g1.m4893M();
        List<Long> listM5819B = C4163q9.m5819B(this.f10675d);
        if (aVarM4893M.f10348l) {
            aVarM4893M.m5318n();
            aVarM4893M.f10348l = false;
        }
        C3663g1.m4890D((C3663g1) aVarM4893M.f10347k, listM5819B);
        List<Long> listM5819B2 = C4163q9.m5819B(this.f10676e);
        if (aVarM4893M.f10348l) {
            aVarM4893M.m5318n();
            aVarM4893M.f10348l = false;
        }
        C3663g1.m4898y((C3663g1) aVarM4893M.f10347k, listM5819B2);
        if (this.f10677f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f10677f.size());
            Iterator<Integer> it = this.f10677f.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                C3912z0.a aVarM5389A = C3912z0.m5389A();
                if (aVarM5389A.f10348l) {
                    aVarM5389A.m5318n();
                    aVarM5389A.f10348l = false;
                }
                C3912z0.m5391u((C3912z0) aVarM5389A.f10347k, iIntValue);
                long jLongValue = this.f10677f.get(Integer.valueOf(iIntValue)).longValue();
                if (aVarM5389A.f10348l) {
                    aVarM5389A.m5318n();
                    aVarM5389A.f10348l = false;
                }
                C3912z0.m5392v((C3912z0) aVarM5389A.f10347k, jLongValue);
                arrayList.add((C3912z0) ((AbstractC3851u4) aVarM5389A.m5320p()));
            }
        }
        if (aVarM4893M.f10348l) {
            aVarM4893M.m5318n();
            aVarM4893M.f10348l = false;
        }
        C3663g1.m4891F((C3663g1) aVarM4893M.f10347k, arrayList);
        if (this.f10678g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.f10678g.size());
            for (Integer num : this.f10678g.keySet()) {
                C3677h1.a aVarM4924B = C3677h1.m4924B();
                int iIntValue2 = num.intValue();
                if (aVarM4924B.f10348l) {
                    aVarM4924B.m5318n();
                    aVarM4924B.f10348l = false;
                }
                C3677h1.m4926v((C3677h1) aVarM4924B.f10347k, iIntValue2);
                List<Long> list = this.f10678g.get(num);
                if (list != null) {
                    Collections.sort(list);
                    if (aVarM4924B.f10348l) {
                        aVarM4924B.m5318n();
                        aVarM4924B.f10348l = false;
                    }
                    C3677h1.m4927w((C3677h1) aVarM4924B.f10347k, list);
                }
                arrayList2.add((C3677h1) ((AbstractC3851u4) aVarM4924B.m5320p()));
            }
        }
        if (aVarM4893M.f10348l) {
            aVarM4893M.m5318n();
            aVarM4893M.f10348l = false;
        }
        C3663g1.m4892H((C3663g1) aVarM4893M.f10347k, arrayList2);
        if (aVarM5363F.f10348l) {
            aVarM5363F.m5318n();
            aVarM5363F.f10348l = false;
        }
        C3899y0.m5366v((C3899y0) aVarM5363F.f10347k, (C3663g1) ((AbstractC3851u4) aVarM4893M.m5320p()));
        return (C3899y0) ((AbstractC3851u4) aVarM5363F.m5320p());
    }

    /* JADX INFO: renamed from: b */
    public final void m5587b(@NonNull AbstractC4027ea abstractC4027ea) {
        int iMo5593a = abstractC4027ea.mo5593a();
        Boolean bool = abstractC4027ea.f10700c;
        if (bool != null) {
            this.f10676e.set(iMo5593a, bool.booleanValue());
        }
        Boolean bool2 = abstractC4027ea.f10701d;
        if (bool2 != null) {
            this.f10675d.set(iMo5593a, bool2.booleanValue());
        }
        if (abstractC4027ea.f10702e != null) {
            Long l = this.f10677f.get(Integer.valueOf(iMo5593a));
            long jLongValue = abstractC4027ea.f10702e.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.f10677f.put(Integer.valueOf(iMo5593a), Long.valueOf(jLongValue));
            }
        }
        if (abstractC4027ea.f10703f != null) {
            List<Long> arrayList = this.f10678g.get(Integer.valueOf(iMo5593a));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f10678g.put(Integer.valueOf(iMo5593a), arrayList);
            }
            if (abstractC4027ea.mo5594g()) {
                arrayList.clear();
            }
            if (C3657f9.m4881b() && this.f10679h.f11202a.f11260h.m5532u(this.f10672a, C4142p.f11066c0) && abstractC4027ea.mo5595h()) {
                arrayList.clear();
            }
            if (!C3657f9.m4881b() || !this.f10679h.f11202a.f11260h.m5532u(this.f10672a, C4142p.f11066c0)) {
                arrayList.add(Long.valueOf(abstractC4027ea.f10703f.longValue() / 1000));
                return;
            }
            long jLongValue2 = abstractC4027ea.f10703f.longValue() / 1000;
            if (arrayList.contains(Long.valueOf(jLongValue2))) {
                return;
            }
            arrayList.add(Long.valueOf(jLongValue2));
        }
    }

    public C4015da(C3991ba c3991ba, String str, C3663g1 c3663g1, BitSet bitSet, BitSet bitSet2, Map map, Map map2, C3979aa c3979aa) {
        this.f10679h = c3991ba;
        this.f10672a = str;
        this.f10675d = bitSet;
        this.f10676e = bitSet2;
        this.f10677f = map;
        this.f10678g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f10678g.put(num, arrayList);
        }
        this.f10673b = false;
        this.f10674c = c3663g1;
    }
}
