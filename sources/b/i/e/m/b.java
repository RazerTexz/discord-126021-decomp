package b.i.e.m;

import b.i.e.c;
import b.i.e.d;
import b.i.e.i;
import b.i.e.j;
import b.i.e.k;
import b.i.e.l;
import b.i.e.n.e;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements i {
    @Override // b.i.e.i
    public Result a(c cVar, Map<d, ?> map) throws NotFoundException, FormatException {
        k[] kVarArr;
        k[] kVarArr2;
        FormatException formatException;
        l lVar;
        b.i.e.m.d.a aVar = new b.i.e.m.d.a(cVar.a());
        e eVarA = null;
        try {
            a aVarA = aVar.a(false);
            kVarArr = aVarA.f1836b;
            try {
                kVarArr2 = kVarArr;
                formatException = null;
                eVarA = new b.i.e.m.c.a().a(aVarA);
                e = null;
            } catch (FormatException e) {
                e = e;
                kVarArr2 = kVarArr;
                formatException = e;
                e = null;
            } catch (NotFoundException e2) {
                e = e2;
                kVarArr2 = kVarArr;
                formatException = null;
            }
        } catch (FormatException e3) {
            e = e3;
            kVarArr = null;
        } catch (NotFoundException e4) {
            e = e4;
            kVarArr = null;
        }
        if (eVarA == null) {
            try {
                a aVarA2 = aVar.a(true);
                kVarArr2 = aVarA2.f1836b;
                eVarA = new b.i.e.m.c.a().a(aVarA2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        k[] kVarArr3 = kVarArr2;
        if (map != null && (lVar = (l) map.get(d.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (k kVar : kVarArr3) {
                lVar.a(kVar);
            }
        }
        Result result = new Result(eVarA.c, eVarA.a, eVarA.f1835b, kVarArr3, b.i.e.a.AZTEC, System.currentTimeMillis());
        List<byte[]> list = eVarA.d;
        if (list != null) {
            result.b(j.BYTE_SEGMENTS, list);
        }
        String str = eVarA.e;
        if (str != null) {
            result.b(j.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // b.i.e.i
    public void reset() {
    }
}
