package b.i.b.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: b.i.b.b.t, reason: use source file name */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Iterators2 implements Iterator<Object> {
    INSTANCE;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        b.i.a.f.e.o.f.E(false);
    }
}
