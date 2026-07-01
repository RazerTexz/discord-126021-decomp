package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.k, reason: use source file name */
/* JADX INFO: compiled from: AnyAIDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnyAIDecoder extends AbstractExpandedDecoder {
    public AnyAIDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // b.i.e.q.r.f.d.AbstractExpandedDecoder
    public String a() throws NotFoundException, FormatException {
        return this.f1867b.a(new StringBuilder(), 5);
    }
}
