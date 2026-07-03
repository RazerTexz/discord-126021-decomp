package p007b.p225i.p414e.p415m;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.List;
import java.util.Map;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.InterfaceC4954i;
import p007b.p225i.p414e.InterfaceC4957l;
import p007b.p225i.p414e.p415m.p416c.C4960a;
import p007b.p225i.p414e.p415m.p417d.C4961a;
import p007b.p225i.p414e.p418n.C4966e;

/* JADX INFO: renamed from: b.i.e.m.b */
/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4959b implements InterfaceC4954i {
    @Override // p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException, FormatException {
        C4956k[] c4956kArr;
        C4956k[] c4956kArr2;
        FormatException formatException;
        InterfaceC4957l interfaceC4957l;
        C4961a c4961a = new C4961a(c4948c.m6913a());
        C4966e c4966eM6926a = null;
        try {
            C4958a c4958aM6928a = c4961a.m6928a(false);
            c4956kArr = c4958aM6928a.f13276b;
            try {
                c4956kArr2 = c4956kArr;
                formatException = null;
                c4966eM6926a = new C4960a().m6926a(c4958aM6928a);
                e = null;
            } catch (FormatException e) {
                e = e;
                c4956kArr2 = c4956kArr;
                formatException = e;
                e = null;
            } catch (NotFoundException e2) {
                e = e2;
                c4956kArr2 = c4956kArr;
                formatException = null;
            }
        } catch (FormatException e3) {
            e = e3;
            c4956kArr = null;
        } catch (NotFoundException e4) {
            e = e4;
            c4956kArr = null;
        }
        if (c4966eM6926a == null) {
            try {
                C4958a c4958aM6928a2 = c4961a.m6928a(true);
                c4956kArr2 = c4958aM6928a2.f13276b;
                c4966eM6926a = new C4960a().m6926a(c4958aM6928a2);
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
        C4956k[] c4956kArr3 = c4956kArr2;
        if (map != null && (interfaceC4957l = (InterfaceC4957l) map.get(EnumC4949d.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (C4956k c4956k : c4956kArr3) {
                interfaceC4957l.m6924a(c4956k);
            }
        }
        Result result = new Result(c4966eM6926a.f13268c, c4966eM6926a.f13266a, c4966eM6926a.f13267b, c4956kArr3, EnumC4946a.AZTEC, System.currentTimeMillis());
        List<byte[]> list = c4966eM6926a.f13269d;
        if (list != null) {
            result.m9262b(EnumC4955j.BYTE_SEGMENTS, list);
        }
        String str = c4966eM6926a.f13270e;
        if (str != null) {
            result.m9262b(EnumC4955j.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
    }
}
