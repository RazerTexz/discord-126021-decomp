package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.f, reason: use source file name */
/* JADX INFO: compiled from: AI013x0xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AI013x0xDecoder extends AI01weightDecoder {
    public AI013x0xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // b.i.e.q.r.f.d.AbstractExpandedDecoder
    public String a() throws NotFoundException {
        if (this.a.k != 60) {
            throw NotFoundException.l;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 5);
        f(sb, 45, 15);
        return sb.toString();
    }
}
