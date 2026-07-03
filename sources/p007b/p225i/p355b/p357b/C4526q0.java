package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.b.b.q0 */
/* JADX INFO: compiled from: SingletonImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4526q0<E> extends AbstractC4527r<E> {

    /* JADX INFO: renamed from: m */
    public final transient E f12055m;

    /* JADX INFO: renamed from: n */
    @LazyInit
    public transient int f12056n;

    public C4526q0(E e) {
        Objects.requireNonNull(e);
        this.f12055m = e;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12055m.equals(obj);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        objArr[i] = this.f12055m;
        return i + 1;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4527r, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.f12056n;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.f12055m.hashCode();
        this.f12056n = iHashCode;
        return iHashCode;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: i */
    public boolean mo6246i() {
        return false;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4527r, p007b.p225i.p355b.p357b.AbstractC4519n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public AbstractC4530s0<E> iterator() {
        return new C4529s(this.f12055m);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4527r
    /* JADX INFO: renamed from: o */
    public AbstractC4523p<E> mo6252o() {
        return AbstractC4523p.m6266u(this.f12055m);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4527r
    /* JADX INFO: renamed from: p */
    public boolean mo6278p() {
        return this.f12056n != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sbM829Q = C1643a.m829Q('[');
        sbM829Q.append(this.f12055m.toString());
        sbM829Q.append(']');
        return sbM829Q.toString();
    }

    public C4526q0(E e, int i) {
        this.f12055m = e;
        this.f12056n = i;
    }
}
