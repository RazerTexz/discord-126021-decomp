package b.i.e.q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: MultiFormatUPCEANReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends k {
    public final p[] a;

    public j(Map<b.i.e.d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(b.i.e.d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(b.i.e.a.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(b.i.e.a.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(b.i.e.a.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(b.i.e.a.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // b.i.e.q.k
    public Result b(int i, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException {
        b.i.e.a aVar2 = b.i.e.a.UPC_A;
        int[] iArrM = p.m(aVar);
        for (p pVar : this.a) {
            try {
                Result resultK = pVar.k(i, aVar, iArrM, map);
                boolean z2 = resultK.d == b.i.e.a.EAN_13 && resultK.a.charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(b.i.e.d.POSSIBLE_FORMATS);
                boolean z3 = collection == null || collection.contains(aVar2);
                if (!z2 || !z3) {
                    return resultK;
                }
                Result result = new Result(resultK.a.substring(1), resultK.f3140b, resultK.c, aVar2);
                result.a(resultK.e);
                return result;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.q.k, b.i.e.i
    public void reset() {
        for (p pVar : this.a) {
            Objects.requireNonNull(pVar);
        }
    }
}
