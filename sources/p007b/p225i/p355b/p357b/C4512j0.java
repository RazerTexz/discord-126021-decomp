package p007b.p225i.p355b.p357b;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.b.j0 */
/* JADX INFO: compiled from: RegularImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4512j0<E> extends AbstractC4527r<E> {

    /* JADX INFO: renamed from: m */
    public static final C4512j0<Object> f12032m = new C4512j0<>(new Object[0], 0, null, 0, 0);

    /* JADX INFO: renamed from: n */
    public final transient Object[] f12033n;

    /* JADX INFO: renamed from: o */
    public final transient Object[] f12034o;

    /* JADX INFO: renamed from: p */
    public final transient int f12035p;

    /* JADX INFO: renamed from: q */
    public final transient int f12036q;

    /* JADX INFO: renamed from: r */
    public final transient int f12037r;

    public C4512j0(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f12033n = objArr;
        this.f12034o = objArr2;
        this.f12035p = i2;
        this.f12036q = i;
        this.f12037r = i3;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.f12034o;
        if (obj == null || objArr == null) {
            return false;
        }
        int iM4277c1 = C3404f.m4277c1(obj.hashCode());
        while (true) {
            int i = iM4277c1 & this.f12035p;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iM4277c1 = i + 1;
        }
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        System.arraycopy(this.f12033n, 0, objArr, i, this.f12037r);
        return i + this.f12037r;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: e */
    public Object[] mo6243e() {
        return this.f12033n;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: g */
    public int mo6244g() {
        return this.f12037r;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: h */
    public int mo6245h() {
        return 0;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4527r, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f12036q;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: i */
    public boolean mo6246i() {
        return false;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4527r, p007b.p225i.p355b.p357b.AbstractC4519n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public AbstractC4530s0<E> iterator() {
        return mo6253c().listIterator();
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4527r
    /* JADX INFO: renamed from: o */
    public AbstractC4523p<E> mo6252o() {
        return AbstractC4523p.m6262l(this.f12033n, this.f12037r);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f12037r;
    }
}
