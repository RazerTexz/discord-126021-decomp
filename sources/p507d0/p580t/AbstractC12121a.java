package p507d0.p580t;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12227g;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.t.a */
/* JADX INFO: compiled from: AbstractCollection.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12121a<E> implements Collection<E>, InterfaceC12228a {

    /* JADX INFO: renamed from: d0.t.a$a */
    /* JADX INFO: compiled from: AbstractCollection.kt */
    public static final class a extends AbstractC12240o implements Function1<E, CharSequence> {
        public a() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(E e) {
            return e == AbstractC12121a.this ? "(this Collection)" : String.valueOf(e);
        }
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (C12238m.areEqual(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        C12238m.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return C12227g.toArray(this);
    }

    public String toString() {
        return C12163u.joinToString$default(this, ", ", "[", "]", 0, null, new a(), 24, null);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C12238m.checkNotNullParameter(tArr, "array");
        T[] tArr2 = (T[]) C12227g.toArray(this, tArr);
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr2;
    }
}
