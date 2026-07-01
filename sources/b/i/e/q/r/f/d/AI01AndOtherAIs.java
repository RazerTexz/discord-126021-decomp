package b.i.e.q.r.f.d;

import b.d.b.a.outline;
import b.i.e.n.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.g, reason: use source file name */
/* JADX INFO: compiled from: AI01AndOtherAIs.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AI01AndOtherAIs extends AI01decoder {
    public AI01AndOtherAIs(BitArray bitArray) {
        super(bitArray);
    }

    @Override // b.i.e.q.r.f.d.AbstractExpandedDecoder
    public String a() throws NotFoundException, FormatException {
        StringBuilder sbU = outline.U("(01)");
        int length = sbU.length();
        sbU.append(this.f1867b.c(4, 4));
        c(sbU, 8, length);
        return this.f1867b.a(sbU, 48);
    }
}
