package b.i.e.q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatOneDReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends k {
    public final k[] a;

    public i(Map<b.i.e.d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(b.i.e.d.POSSIBLE_FORMATS);
        boolean z2 = (map == null || map.get(b.i.e.d.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(b.i.e.a.EAN_13) || collection.contains(b.i.e.a.UPC_A) || collection.contains(b.i.e.a.EAN_8) || collection.contains(b.i.e.a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(b.i.e.a.CODE_39)) {
                arrayList.add(new c(z2));
            }
            if (collection.contains(b.i.e.a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(b.i.e.a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(b.i.e.a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(b.i.e.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(b.i.e.a.RSS_14)) {
                arrayList.add(new b.i.e.q.r.e());
            }
            if (collection.contains(b.i.e.a.RSS_EXPANDED)) {
                arrayList.add(new b.i.e.q.r.f.c());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c(false));
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new b.i.e.q.r.e());
            arrayList.add(new b.i.e.q.r.f.c());
        }
        this.a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // b.i.e.q.k
    public Result b(int i, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException {
        for (k kVar : this.a) {
            try {
                return kVar.b(i, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.q.k, b.i.e.i
    public void reset() {
        for (k kVar : this.a) {
            kVar.reset();
        }
    }
}
