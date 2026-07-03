package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11926g1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11933j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.g */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11601g extends AbstractC11967m implements InterfaceC11933j {

    /* JADX INFO: renamed from: k */
    public final AbstractC11934j0 f23459k;

    public C11601g(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        this.f23459k = abstractC11934j0;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC11934j0 m9508a(AbstractC11934j0 abstractC11934j0) {
        AbstractC11934j0 abstractC11934j0MakeNullableAsSpecified = abstractC11934j0.makeNullableAsSpecified(false);
        return !C11992a.isTypeParameter(abstractC11934j0) ? abstractC11934j0MakeNullableAsSpecified : new C11601g(abstractC11934j0MakeNullableAsSpecified);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public AbstractC11934j0 getDelegate() {
        return this.f23459k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11933j
    public boolean isTypeVariable() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.f23459k.makeNullableAsSpecified(true) : this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11933j
    public AbstractC11913c0 substitutionResult(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "replacement");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (!C11992a.isTypeParameter(abstractC11932i1Unwrap) && !C11920e1.isNullableType(abstractC11932i1Unwrap)) {
            return abstractC11932i1Unwrap;
        }
        if (abstractC11932i1Unwrap instanceof AbstractC11934j0) {
            return m9508a((AbstractC11934j0) abstractC11932i1Unwrap);
        }
        if (!(abstractC11932i1Unwrap instanceof AbstractC12009v)) {
            throw new IllegalStateException(C12238m.stringPlus("Incorrect type: ", abstractC11932i1Unwrap).toString());
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        AbstractC12009v abstractC12009v = (AbstractC12009v) abstractC11932i1Unwrap;
        return C11926g1.wrapEnhancement(C11916d0.flexibleType(m9508a(abstractC12009v.getLowerBound()), m9508a(abstractC12009v.getUpperBound())), C11926g1.getEnhancement(abstractC11932i1Unwrap));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public C11601g replaceDelegate(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        return new C11601g(abstractC11934j0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11601g replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return new C11601g(this.f23459k.replaceAnnotations(interfaceC11344g));
    }
}
