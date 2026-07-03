package p007b.p225i.p355b.p357b;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.b.h0 */
/* JADX INFO: compiled from: RegularImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4508h0<E> extends AbstractC4523p<E> {

    /* JADX INFO: renamed from: l */
    public static final AbstractC4523p<Object> f12012l = new C4508h0(new Object[0], 0);

    /* JADX INFO: renamed from: m */
    public final transient Object[] f12013m;

    /* JADX INFO: renamed from: n */
    public final transient int f12014n;

    public C4508h0(Object[] objArr, int i) {
        this.f12013m = objArr;
        this.f12014n = i;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4523p, p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: d */
    public int mo6242d(Object[] objArr, int i) {
        System.arraycopy(this.f12013m, 0, objArr, i, this.f12014n);
        return i + this.f12014n;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: e */
    public Object[] mo6243e() {
        return this.f12013m;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: g */
    public int mo6244g() {
        return this.f12014n;
    }

    @Override // java.util.List
    public E get(int i) {
        C3404f.m4359x(i, this.f12014n);
        return (E) this.f12013m[i];
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: h */
    public int mo6245h() {
        return 0;
    }

    @Override // p007b.p225i.p355b.p357b.AbstractC4519n
    /* JADX INFO: renamed from: i */
    public boolean mo6246i() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f12014n;
    }
}
