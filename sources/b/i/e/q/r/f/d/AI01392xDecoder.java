package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.c, reason: use source file name */
/* JADX INFO: compiled from: AI01392xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AI01392xDecoder extends AI01decoder {
    public AI01392xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // b.i.e.q.r.f.d.AbstractExpandedDecoder
    public String a() throws NotFoundException, FormatException {
        if (this.a.k < 48) {
            throw NotFoundException.l;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        int iC = this.f1867b.c(48, 2);
        sb.append("(392");
        sb.append(iC);
        sb.append(')');
        sb.append(this.f1867b.b(50, null).f1871b);
        return sb.toString();
    }
}
