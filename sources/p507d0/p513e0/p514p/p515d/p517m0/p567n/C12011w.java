package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.w */
/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12011w extends AbstractC12009v implements InterfaceC11933j {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.w$a */
    /* JADX INFO: compiled from: flexibleTypes.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12011w(AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
        super(abstractC11934j0, abstractC11934j1);
        C12238m.checkNotNullParameter(abstractC11934j0, "lowerBound");
        C12238m.checkNotNullParameter(abstractC11934j1, "upperBound");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public AbstractC11934j0 getDelegate() {
        return getLowerBound();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11933j
    public boolean isTypeVariable() {
        return (getLowerBound().getConstructor().getDeclarationDescriptor() instanceof InterfaceC11477z0) && C12238m.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11932i1 makeNullableAsSpecified(boolean z2) {
        C11916d0 c11916d0 = C11916d0.f24748a;
        return C11916d0.flexibleType(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public String render(AbstractC11746c abstractC11746c, InterfaceC11751h interfaceC11751h) {
        C12238m.checkNotNullParameter(abstractC11746c, "renderer");
        C12238m.checkNotNullParameter(interfaceC11751h, "options");
        if (!interfaceC11751h.getDebugMode()) {
            return abstractC11746c.renderFlexibleType(abstractC11746c.renderType(getLowerBound()), abstractC11746c.renderType(getUpperBound()), C11992a.getBuiltIns(this));
        }
        StringBuilder sbM829Q = C1643a.m829Q('(');
        sbM829Q.append(abstractC11746c.renderType(getLowerBound()));
        sbM829Q.append("..");
        sbM829Q.append(abstractC11746c.renderType(getUpperBound()));
        sbM829Q.append(')');
        return sbM829Q.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11932i1 replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        C11916d0 c11916d0 = C11916d0.f24748a;
        return C11916d0.flexibleType(getLowerBound().replaceAnnotations(interfaceC11344g), getUpperBound().replaceAnnotations(interfaceC11344g));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11933j
    public AbstractC11913c0 substitutionResult(AbstractC11913c0 abstractC11913c0) {
        AbstractC11932i1 abstractC11932i1FlexibleType;
        C12238m.checkNotNullParameter(abstractC11913c0, "replacement");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (abstractC11932i1Unwrap instanceof AbstractC12009v) {
            abstractC11932i1FlexibleType = abstractC11932i1Unwrap;
        } else {
            if (!(abstractC11932i1Unwrap instanceof AbstractC11934j0)) {
                throw new NoWhenBranchMatchedException();
            }
            C11916d0 c11916d0 = C11916d0.f24748a;
            AbstractC11934j0 abstractC11934j0 = (AbstractC11934j0) abstractC11932i1Unwrap;
            abstractC11932i1FlexibleType = C11916d0.flexibleType(abstractC11934j0, abstractC11934j0.makeNullableAsSpecified(true));
        }
        return C11926g1.inheritEnhancement(abstractC11932i1FlexibleType, abstractC11932i1Unwrap);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public AbstractC12009v refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return new C12011w((AbstractC11934j0) abstractC11947g.refineType(getLowerBound()), (AbstractC11934j0) abstractC11947g.refineType(getUpperBound()));
    }
}
