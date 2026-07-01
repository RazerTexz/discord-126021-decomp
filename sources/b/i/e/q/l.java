package b.i.e.q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends p {
    public final p h = new e();

    public static Result o(Result result) throws FormatException {
        String str = result.a;
        if (str.charAt(0) != '0') {
            throw FormatException.a();
        }
        Result result2 = new Result(str.substring(1), null, result.c, b.i.e.a.UPC_A);
        Map<b.i.e.j, Object> map = result.e;
        if (map != null) {
            result2.a(map);
        }
        return result2;
    }

    @Override // b.i.e.q.k, b.i.e.i
    public Result a(b.i.e.c cVar, Map<b.i.e.d, ?> map) throws NotFoundException, FormatException {
        return o(this.h.a(cVar, map));
    }

    @Override // b.i.e.q.p, b.i.e.q.k
    public Result b(int i, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return o(this.h.b(i, aVar, map));
    }

    @Override // b.i.e.q.p
    public int j(b.i.e.n.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.h.j(aVar, iArr, sb);
    }

    @Override // b.i.e.q.p
    public Result k(int i, b.i.e.n.a aVar, int[] iArr, Map<b.i.e.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return o(this.h.k(i, aVar, iArr, map));
    }

    @Override // b.i.e.q.p
    public b.i.e.a n() {
        return b.i.e.a.UPC_A;
    }
}
