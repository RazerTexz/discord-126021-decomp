package d0.e0.p.d.m0.i;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: compiled from: RopeByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class r$c implements Iterator<m> {
    public final Stack<r> j = new Stack<>();
    public m k;

    public r$c(c cVar, r$a r_a) {
        while (cVar instanceof r) {
            r rVar = (r) cVar;
            this.j.push(rVar);
            cVar = rVar.m;
        }
        this.k = (m) cVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.k != null;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ m next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public m next() {
        m mVar;
        m mVar2 = this.k;
        if (mVar2 == null) {
            throw new NoSuchElementException();
        }
        while (!this.j.isEmpty()) {
            c cVar = this.j.pop().n;
            while (cVar instanceof r) {
                r rVar = (r) cVar;
                this.j.push(rVar);
                cVar = rVar.m;
            }
            mVar = (m) cVar;
            if (!mVar.isEmpty()) {
                this.k = mVar;
                return mVar2;
            }
        }
        mVar = null;
        this.k = mVar;
        return mVar2;
    }
}
