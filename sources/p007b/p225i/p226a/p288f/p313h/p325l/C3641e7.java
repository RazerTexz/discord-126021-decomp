package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: b.i.a.f.h.l.e7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3641e7 extends AbstractList<String> implements InterfaceC3709j5, RandomAccess {

    /* JADX INFO: renamed from: j */
    public final InterfaceC3709j5 f9930j;

    public C3641e7(InterfaceC3709j5 interfaceC3709j5) {
        this.f9930j = interfaceC3709j5;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: A */
    public final Object mo4863A(int i) {
        return this.f9930j.mo4863A(i);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: b */
    public final List<?> mo4864b() {
        return this.f9930j.mo4864b();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.f9930j.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new C3669g7(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new C3683h7(this, i);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: s */
    public final InterfaceC3709j5 mo4865s() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9930j.size();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3709j5
    /* JADX INFO: renamed from: t */
    public final void mo4866t(AbstractC3837t3 abstractC3837t3) {
        throw new UnsupportedOperationException();
    }
}
