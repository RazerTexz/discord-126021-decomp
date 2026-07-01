package d0.e0.p.d.m0.p;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SmartList.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$b<T> implements Iterator<T> {
    public static final i$b j = new i$b();

    public static <T> i$b<T> getInstance() {
        return j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException();
    }
}
