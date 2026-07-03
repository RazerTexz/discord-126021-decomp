package p507d0.p513e0.p514p.p515d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.EnumC11237j;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p513e0.InterfaceC11235h;
import p507d0.p513e0.p514p.p515d.C11251c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.C11413f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11649j;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12149o;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12226f0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.y */
/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12059y implements InterfaceC11235h {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f25067j = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C12059y.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* JADX INFO: renamed from: k */
    public final C11251c0.a f25068k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC12060z f25069l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC11477z0 f25070m;

    /* JADX INFO: renamed from: d0.e0.p.d.y$a */
    /* JADX INFO: compiled from: KTypeParameterImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends C12058x>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends C12058x> invoke() {
            List<AbstractC11913c0> upperBounds = C12059y.this.getDescriptor().getUpperBounds();
            C12238m.checkNotNullExpressionValue(upperBounds, "descriptor.upperBounds");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(upperBounds, 10));
            Iterator<T> it = upperBounds.iterator();
            while (it.hasNext()) {
                arrayList.add(new C12058x((AbstractC11913c0) it.next(), null, 2, null));
            }
            return arrayList;
        }
    }

    public C12059y(InterfaceC12060z interfaceC12060z, InterfaceC11477z0 interfaceC11477z0) {
        Class<?> klass;
        C11260h<?> c11260hM10058a;
        Object objAccept;
        C12238m.checkNotNullParameter(interfaceC11477z0, "descriptor");
        this.f25070m = interfaceC11477z0;
        this.f25068k = C11251c0.lazySoft(new a());
        if (interfaceC12060z == null) {
            InterfaceC11450m containingDeclaration = getDescriptor().getContainingDeclaration();
            C12238m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof InterfaceC11330e) {
                objAccept = m10058a((InterfaceC11330e) containingDeclaration);
            } else {
                if (!(containingDeclaration instanceof InterfaceC11321b)) {
                    throw new C11247a0("Unknown type parameter container: " + containingDeclaration);
                }
                InterfaceC11450m containingDeclaration2 = ((InterfaceC11321b) containingDeclaration).getContainingDeclaration();
                C12238m.checkNotNullExpressionValue(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof InterfaceC11330e) {
                    c11260hM10058a = m10058a((InterfaceC11330e) containingDeclaration2);
                } else {
                    InterfaceC11862g interfaceC11862g = (InterfaceC11862g) (!(containingDeclaration instanceof InterfaceC11862g) ? null : containingDeclaration);
                    if (interfaceC11862g == null) {
                        throw new C11247a0("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                    InterfaceC11861f containerSource = interfaceC11862g.getContainerSource();
                    C11649j c11649j = (C11649j) (containerSource instanceof C11649j ? containerSource : null);
                    InterfaceC11655p knownJvmBinaryClass = c11649j != null ? c11649j.getKnownJvmBinaryClass() : null;
                    C11413f c11413f = (C11413f) (knownJvmBinaryClass instanceof C11413f ? knownJvmBinaryClass : null);
                    if (c11413f == null || (klass = c11413f.getKlass()) == null) {
                        throw new C11247a0("Container of deserialized member is not resolved: " + interfaceC11862g);
                    }
                    InterfaceC11230c kotlinClass = C12209a.getKotlinClass(klass);
                    Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    c11260hM10058a = (C11260h) kotlinClass;
                }
                objAccept = containingDeclaration.accept(new C11246a(c11260hM10058a), Unit.f27425a);
            }
            C12238m.checkNotNullExpressionValue(objAccept, "when (val declaration = … $declaration\")\n        }");
            interfaceC12060z = (InterfaceC12060z) objAccept;
        }
        this.f25069l = interfaceC12060z;
    }

    /* JADX INFO: renamed from: a */
    public final C11260h<?> m10058a(InterfaceC11330e interfaceC11330e) {
        Class<?> javaClass = C11265j0.toJavaClass(interfaceC11330e);
        C11260h<?> c11260h = (C11260h) (javaClass != null ? C12209a.getKotlinClass(javaClass) : null);
        if (c11260h != null) {
            return c11260h;
        }
        StringBuilder sbM833U = C1643a.m833U("Type parameter container is not resolved: ");
        sbM833U.append(interfaceC11330e.getContainingDeclaration());
        throw new C11247a0(sbM833U.toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12059y) {
            C12059y c12059y = (C12059y) obj;
            if (C12238m.areEqual(this.f25069l, c12059y.f25069l) && C12238m.areEqual(getName(), c12059y.getName())) {
                return true;
            }
        }
        return false;
    }

    public InterfaceC11477z0 getDescriptor() {
        return this.f25070m;
    }

    @Override // p507d0.p513e0.InterfaceC11235h
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    @Override // p507d0.p513e0.InterfaceC11235h
    public List<KType> getUpperBounds() {
        return (List) this.f25068k.getValue(this, f25067j[0]);
    }

    @Override // p507d0.p513e0.InterfaceC11235h
    public EnumC11237j getVariance() {
        int iOrdinal = getDescriptor().getVariance().ordinal();
        if (iOrdinal == 0) {
            return EnumC11237j.INVARIANT;
        }
        if (iOrdinal == 1) {
            return EnumC11237j.IN;
        }
        if (iOrdinal == 2) {
            return EnumC11237j.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return getName().hashCode() + (this.f25069l.hashCode() * 31);
    }

    public String toString() {
        return C12226f0.f25289j.toString(this);
    }
}
