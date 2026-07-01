package b.i.e.q.r.f.d;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: AI013x0xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends i {
    public f(b.i.e.n.a aVar) {
        super(aVar);
    }

    @Override // b.i.e.q.r.f.d.j
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
