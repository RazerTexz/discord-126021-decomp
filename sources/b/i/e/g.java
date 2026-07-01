package b.i.e;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements i {
    public Map<d, ?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i[] f1824b;

    @Override // b.i.e.i
    public Result a(c cVar, Map<d, ?> map) throws NotFoundException {
        c(map);
        return b(cVar);
    }

    public final Result b(c cVar) throws NotFoundException {
        i[] iVarArr = this.f1824b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                try {
                    return iVar.a(cVar, this.a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.l;
    }

    public void c(Map<d, ?> map) {
        this.a = map;
        boolean z2 = map != null && map.containsKey(d.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z3 = collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODABAR) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED);
            if (z3 && !z2) {
                arrayList.add(new b.i.e.q.i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new b.i.e.s.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new b.i.e.o.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new b.i.e.m.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new b.i.e.r.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new b.i.e.p.a());
            }
            if (z3 && z2) {
                arrayList.add(new b.i.e.q.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new b.i.e.q.i(map));
            }
            arrayList.add(new b.i.e.s.a());
            arrayList.add(new b.i.e.o.a());
            arrayList.add(new b.i.e.m.b());
            arrayList.add(new b.i.e.r.b());
            arrayList.add(new b.i.e.p.a());
            if (z2) {
                arrayList.add(new b.i.e.q.i(map));
            }
        }
        this.f1824b = (i[]) arrayList.toArray(new i[arrayList.size()]);
    }

    @Override // b.i.e.i
    public void reset() {
        i[] iVarArr = this.f1824b;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                iVar.reset();
            }
        }
    }
}
