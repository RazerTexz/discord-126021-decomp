package b.a.q;

import com.discord.rtcconnection.EncodeQuality;
import d0.t.n0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e$b a = new e$b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f257b;
    public final Map<EncodeQuality, n> c;
    public final List<e$c> d;
    public final j0 e;

    public e(j0 j0Var, int i) {
        n nVar;
        Object objPrevious;
        EncodeQuality encodeQuality;
        j0 j0Var2 = (i & 1) != 0 ? f.a : null;
        d0.z.d.m.checkNotNullParameter(j0Var2, "options");
        this.e = j0Var2;
        b bVar = j0Var2.a;
        int i2 = bVar.a * bVar.f256b;
        this.f257b = i2;
        Set of = n0.setOf((Object[]) new Double[]{Double.valueOf(0.0d), Double.valueOf(4.0d), Double.valueOf(8.0d), Double.valueOf(10.0d)});
        ArrayList arrayList = new ArrayList();
        for (int i3 = 1; i3 < 4096; i3++) {
            double d = i3;
            double d2 = (d * 16.0d) / 9.0d;
            if (of.contains(Double.valueOf(d2 % 16.0d)) && of.contains(Double.valueOf(d % 16.0d))) {
                double d3 = d * d2;
                arrayList.add(new e$a((int) d2, i3, d3 / ((double) i2), (int) d3));
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        EncodeQuality encodeQuality2 = EncodeQuality.Hundred;
        int i4 = 1;
        int i5 = 0;
        while (i4 <= 25) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!(((e$a) objPrevious).d * i4 <= i2));
            e$a e_a = (e$a) objPrevious;
            e_a = e_a == null ? (e$a) d0.t.u.first((List) arrayList) : e_a;
            if (i5 != e_a.a) {
                linkedHashMap.put(encodeQuality2, new n(e_a.a, e_a.f258b, e_a.c, encodeQuality2.compareTo(EncodeQuality.Twenty) <= 0 ? 12 : 20, 30));
                EncodeQuality[] encodeQualityArrValues = EncodeQuality.values();
                int i6 = 10;
                while (true) {
                    if (i6 < 0) {
                        encodeQuality = null;
                        break;
                    }
                    encodeQuality = encodeQualityArrValues[i6];
                    if (encodeQuality.getValue() < encodeQuality2.getValue()) {
                        break;
                    } else {
                        i6--;
                    }
                }
                encodeQuality2 = encodeQuality == null ? EncodeQuality.Zero : encodeQuality;
                i5 = e_a.a;
            }
            i4++;
            i2 = i2;
        }
        this.c = linkedHashMap;
        EncodeQuality[] encodeQualityArrValues2 = EncodeQuality.values();
        ArrayList arrayList2 = new ArrayList(11);
        for (int i7 = 0; i7 < 11; i7++) {
            EncodeQuality encodeQuality3 = encodeQualityArrValues2[i7];
            arrayList2.add((encodeQuality3 == EncodeQuality.Zero || (nVar = (n) linkedHashMap.get(encodeQuality3)) == null) ? null : new e$c(nVar, nVar.f274b * nVar.a, encodeQuality3));
        }
        this.d = d0.t.u.filterNotNull(arrayList2);
    }
}
