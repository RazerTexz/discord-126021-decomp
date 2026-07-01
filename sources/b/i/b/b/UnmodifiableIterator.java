package b.i.b.b;

import java.util.Iterator;

/* JADX INFO: renamed from: b.i.b.b.s0, reason: use source file name */
/* JADX INFO: compiled from: UnmodifiableIterator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
