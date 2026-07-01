package b.i.b.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v$h<T> implements Iterator<T> {
    public int j;
    public int k = -1;

    @MonotonicNonNullDecl
    public v$n<K, V, E, S> l;

    @MonotonicNonNullDecl
    public AtomicReferenceArray<E> m;

    /* JADX INFO: Incorrect field signature: TE; */
    @NullableDecl
    public v$i n;

    /* JADX WARN: Incorrect inner types in field signature: Lb/i/b/b/v<TK;TV;TE;TS;>.d0; */
    @NullableDecl
    public v$d0 o;

    /* JADX WARN: Incorrect inner types in field signature: Lb/i/b/b/v<TK;TV;TE;TS;>.d0; */
    @NullableDecl
    public v$d0 p;
    public final /* synthetic */ v q;

    public v$h(v vVar) {
        this.q = vVar;
        this.j = vVar.m.length - 1;
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        this.o = null;
        if (d() || e()) {
            return;
        }
        while (true) {
            int i = this.j;
            if (i < 0) {
                return;
            }
            v$n<K, V, E, S>[] v_nArr = this.q.m;
            this.j = i - 1;
            v$z v_z = v_nArr[i];
            this.l = v_z;
            if (v_z.count != 0) {
                AtomicReferenceArray<E> atomicReferenceArray = this.l.table;
                this.m = atomicReferenceArray;
                this.k = atomicReferenceArray.length() - 1;
                if (e()) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Incorrect types in method signature: (TE;)Z */
    public boolean b(v$i v_i) {
        Object value;
        boolean z2;
        try {
            Object key = v_i.getKey();
            Objects.requireNonNull(this.q);
            Object obj = null;
            if (v_i.getKey() != null && (value = v_i.getValue()) != null) {
                obj = value;
            }
            if (obj != null) {
                this.o = new v$d0(this.q, key, obj);
                z2 = true;
            } else {
                z2 = false;
            }
            return z2;
        } finally {
            this.l.h();
        }
    }

    /* JADX WARN: Incorrect inner types in method signature: ()Lb/i/b/b/v<TK;TV;TE;TS;>.d0; */
    public v$d0 c() {
        v$d0 v_d0 = this.o;
        if (v_d0 == null) {
            throw new NoSuchElementException();
        }
        this.p = v_d0;
        a();
        return this.p;
    }

    public boolean d() {
        v$i v_i = this.n;
        if (v_i == null) {
            return false;
        }
        while (true) {
            this.n = v_i.a();
            v$i v_i2 = this.n;
            if (v_i2 == null) {
                return false;
            }
            if (b(v_i2)) {
                return true;
            }
            v_i = this.n;
        }
    }

    public boolean e() {
        while (true) {
            int i = this.k;
            if (i < 0) {
                return false;
            }
            AtomicReferenceArray<E> atomicReferenceArray = this.m;
            this.k = i - 1;
            v$i v_i = (v$i) atomicReferenceArray.get(i);
            this.n = v_i;
            if (v_i != null && (b(v_i) || d())) {
                return true;
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.o != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        b.i.a.f.e.o.f.E(this.p != null);
        this.q.remove(this.p.j);
        this.p = null;
    }
}
