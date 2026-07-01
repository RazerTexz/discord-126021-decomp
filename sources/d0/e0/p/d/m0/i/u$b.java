package d0.e0.p.d.m0.i;

import java.util.Iterator;

/* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
/* JADX INFO: loaded from: classes3.dex */
public class u$b implements Iterator<String> {
    public Iterator<String> j;
    public final /* synthetic */ u k;

    public u$b(u uVar) {
        this.k = uVar;
        this.j = uVar.j.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ String next() {
        return next2();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
    public String next2() {
        return this.j.next();
    }
}
