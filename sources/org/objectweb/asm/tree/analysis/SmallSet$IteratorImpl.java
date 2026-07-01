package org.objectweb.asm.tree.analysis;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/tree/analysis/SmallSet$IteratorImpl.SCL.lombok */
class SmallSet$IteratorImpl<T> implements Iterator<T> {
    private T firstElement;
    private T secondElement;

    SmallSet$IteratorImpl(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.firstElement != null;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.firstElement == null) {
            throw new NoSuchElementException();
        }
        T element = this.firstElement;
        this.firstElement = this.secondElement;
        this.secondElement = null;
        return element;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
