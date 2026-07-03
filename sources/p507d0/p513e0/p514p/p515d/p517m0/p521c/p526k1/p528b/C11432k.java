package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11575h;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11591x;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.k */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11432k extends AbstractC11425d implements InterfaceC11575h {

    /* JADX INFO: renamed from: c */
    public final Class<?> f23054c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11432k(C11716e c11716e, Class<?> cls) {
        super(c11716e);
        C12238m.checkNotNullParameter(cls, "klass");
        this.f23054c = cls;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11575h
    public InterfaceC11591x getReferencedType() {
        return AbstractC11444w.f23065a.create(this.f23054c);
    }
}
