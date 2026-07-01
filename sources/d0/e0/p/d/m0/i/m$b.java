package d0.e0.p.d.m0.i;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: LiteralByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class m$b implements c$a {
    public int j = 0;
    public final int k;
    public final /* synthetic */ m l;

    public m$b(m mVar, m$a m_a) {
        this.l = mVar;
        this.k = mVar.size();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j < this.k;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Byte next() {
        return next();
    }

    @Override // d0.e0.p.d.m0.i.c$a
    public byte nextByte() {
        try {
            byte[] bArr = this.l.k;
            int i = this.j;
            this.j = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Byte next() {
        return Byte.valueOf(nextByte());
    }
}
