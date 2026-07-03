package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11949i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11954n;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11936k extends AbstractC11967m implements InterfaceC11933j, InterfaceC11975d {

    /* JADX INFO: renamed from: k */
    public static final a f24788k = new a(null);

    /* JADX INFO: renamed from: l */
    public final AbstractC11934j0 f24789l;

    /* JADX INFO: renamed from: m */
    public final boolean f24790m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.k$a */
    /* JADX INFO: compiled from: SpecialTypes.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11936k makeDefinitelyNotNull$descriptors(AbstractC11932i1 abstractC11932i1, boolean z2) {
            C12238m.checkNotNullParameter(abstractC11932i1, "type");
            if (abstractC11932i1 instanceof C11936k) {
                return (C11936k) abstractC11932i1;
            }
            abstractC11932i1.getConstructor();
            boolean zIsNullableType = false;
            if ((abstractC11932i1.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11477z0) || (abstractC11932i1 instanceof C11949i)) {
                zIsNullableType = (z2 && (abstractC11932i1.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11477z0)) ? C11920e1.isNullableType(abstractC11932i1) : !C11954n.f24825a.isSubtypeOfAny(abstractC11932i1);
            }
            if (!zIsNullableType) {
                return null;
            }
            if (abstractC11932i1 instanceof AbstractC12009v) {
                AbstractC12009v abstractC12009v = (AbstractC12009v) abstractC11932i1;
                C12238m.areEqual(abstractC12009v.getLowerBound().getConstructor(), abstractC12009v.getUpperBound().getConstructor());
            }
            return new C11936k(C12015y.lowerIfFlexible(abstractC11932i1), z2, null);
        }
    }

    public C11936k(AbstractC11934j0 abstractC11934j0, boolean z2) {
        this.f24789l = abstractC11934j0;
        this.f24790m = z2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public AbstractC11934j0 getDelegate() {
        return this.f24789l;
    }

    public final AbstractC11934j0 getOriginal() {
        return this.f24789l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11933j
    public boolean isTypeVariable() {
        this.f24789l.getConstructor();
        return this.f24789l.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11477z0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11933j
    public AbstractC11913c0 substitutionResult(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "replacement");
        return C11968m0.makeDefinitelyNotNullOrNotNull(abstractC11913c0.unwrap(), this.f24790m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0
    public String toString() {
        return this.f24789l + "!!";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.f24789l.makeNullableAsSpecified(z2) : this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11967m
    public C11936k replaceDelegate(AbstractC11934j0 abstractC11934j0) {
        C12238m.checkNotNullParameter(abstractC11934j0, "delegate");
        return new C11936k(abstractC11934j0, this.f24790m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11936k replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return new C11936k(this.f24789l.replaceAnnotations(interfaceC11344g), this.f24790m);
    }

    public C11936k(AbstractC11934j0 abstractC11934j0, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24789l = abstractC11934j0;
        this.f24790m = z2;
    }
}
