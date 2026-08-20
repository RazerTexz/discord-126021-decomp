package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.h */
/* JADX INFO: compiled from: AnnotationsImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11345h implements InterfaceC11344g {

    /* JADX INFO: renamed from: j */
    public final List<InterfaceC11340c> f22738j;

    /* JADX WARN: Multi-variable type inference failed */
    public C11345h(List<? extends InterfaceC11340c> list) {
        C12238m.checkNotNullParameter(list, "annotations");
        this.f22738j = list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public InterfaceC11340c findAnnotation(C11713b c11713b) {
        return InterfaceC11344g.b.findAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean hasAnnotation(C11713b c11713b) {
        return InterfaceC11344g.b.hasAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g
    public boolean isEmpty() {
        return this.f22738j.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<InterfaceC11340c> iterator() {
        return this.f22738j.iterator();
    }

    public String toString() {
        return this.f22738j.toString();
    }
}
