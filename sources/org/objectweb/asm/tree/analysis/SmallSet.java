package org.objectweb.asm.tree.analysis;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/SmallSet.SCL.lombok */
final class SmallSet<T> extends AbstractSet<T> {
    private final T element1;
    private final T element2;

    SmallSet() {
        this.element1 = null;
        this.element2 = null;
    }

    SmallSet(T element) {
        this.element1 = element;
        this.element2 = null;
    }

    private SmallSet(T element1, T element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        return new IteratorImpl(this.element1, this.element2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (this.element1 == null) {
            return 0;
        }
        if (this.element2 == null) {
            return 1;
        }
        return 2;
    }

    Set<T> union(SmallSet<T> otherSet) {
        if ((otherSet.element1 == this.element1 && otherSet.element2 == this.element2) || (otherSet.element1 == this.element2 && otherSet.element2 == this.element1)) {
            return this;
        }
        if (otherSet.element1 == null) {
            return this;
        }
        if (this.element1 == null) {
            return otherSet;
        }
        if (otherSet.element2 == null) {
            if (this.element2 == null) {
                return new SmallSet(this.element1, otherSet.element1);
            }
            if (otherSet.element1 == this.element1 || otherSet.element1 == this.element2) {
                return this;
            }
        }
        if (this.element2 == null && (this.element1 == otherSet.element1 || this.element1 == otherSet.element2)) {
            return otherSet;
        }
        HashSet<T> result = new HashSet<>(4);
        result.add(this.element1);
        if (this.element2 != null) {
            result.add(this.element2);
        }
        result.add(otherSet.element1);
        if (otherSet.element2 != null) {
            result.add(otherSet.element2);
        }
        return result;
    }

    /* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/SmallSet$IteratorImpl.SCL.lombok */
    static class IteratorImpl<T> implements Iterator<T> {
        private T firstElement;
        private T secondElement;

        IteratorImpl(T firstElement, T secondElement) {
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
}
