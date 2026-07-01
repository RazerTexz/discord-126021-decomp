package d0.e0.p.d.m0.i;

/* JADX INFO: compiled from: RopeByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class r$d implements c$a {
    public final r$c j;
    public c$a k;
    public int l;

    /* JADX WARN: Type inference failed for: r3v3, types: [d0.e0.p.d.m0.i.c$a] */
    public r$d(r rVar, r$a r_a) {
        r$c r_c = new r$c(rVar, null);
        this.j = r_c;
        this.k = r_c.next().iterator();
        this.l = rVar.size();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.l > 0;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Byte next() {
        return next();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [d0.e0.p.d.m0.i.c$a] */
    @Override // d0.e0.p.d.m0.i.c$a
    public byte nextByte() {
        if (!this.k.hasNext()) {
            this.k = this.j.next().iterator();
        }
        this.l--;
        return this.k.nextByte();
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
