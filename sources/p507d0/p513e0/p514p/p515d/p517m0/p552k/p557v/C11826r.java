package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11470w;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.r */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11826r extends AbstractC11815g<b> {

    /* JADX INFO: renamed from: b */
    public static final a f24451b = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.r$a */
    /* JADX INFO: compiled from: constantValues.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC11815g<?> create(AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(abstractC11913c0, "argumentType");
            if (C11919e0.isError(abstractC11913c0)) {
                return null;
            }
            AbstractC11913c0 type = abstractC11913c0;
            int i = 0;
            while (AbstractC11288h.isArray(type)) {
                type = ((InterfaceC12012w0) C12163u.single((List) type.getArguments())).getType();
                C12238m.checkNotNullExpressionValue(type, "type.arguments.single().type");
                i++;
            }
            InterfaceC11352h declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof InterfaceC11330e) {
                C11712a classId = C11836a.getClassId(declarationDescriptor);
                return classId == null ? new C11826r(new b.a(abstractC11913c0)) : new C11826r(classId, i);
            }
            if (!(declarationDescriptor instanceof InterfaceC11477z0)) {
                return null;
            }
            C11712a c11712a = C11712a.topLevel(C11291k.a.f22532b.toSafe());
            C12238m.checkNotNullExpressionValue(c11712a, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new C11826r(c11712a, 0);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.r$b */
    /* JADX INFO: compiled from: constantValues.kt */
    public static abstract class b {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.r$b$a */
        /* JADX INFO: compiled from: constantValues.kt */
        public static final class a extends b {

            /* JADX INFO: renamed from: a */
            public final AbstractC11913c0 f24452a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AbstractC11913c0 abstractC11913c0) {
                super(null);
                C12238m.checkNotNullParameter(abstractC11913c0, "type");
                this.f24452a = abstractC11913c0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && C12238m.areEqual(this.f24452a, ((a) obj).f24452a);
            }

            public final AbstractC11913c0 getType() {
                return this.f24452a;
            }

            public int hashCode() {
                return this.f24452a.hashCode();
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("LocalClass(type=");
                sbM833U.append(this.f24452a);
                sbM833U.append(')');
                return sbM833U.toString();
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.r$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: constantValues.kt */
        public static final class C13329b extends b {

            /* JADX INFO: renamed from: a */
            public final C11814f f24453a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13329b(C11814f c11814f) {
                super(null);
                C12238m.checkNotNullParameter(c11814f, "value");
                this.f24453a = c11814f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C13329b) && C12238m.areEqual(this.f24453a, ((C13329b) obj).f24453a);
            }

            public final int getArrayDimensions() {
                return this.f24453a.getArrayNestedness();
            }

            public final C11712a getClassId() {
                return this.f24453a.getClassId();
            }

            public final C11814f getValue() {
                return this.f24453a;
            }

            public int hashCode() {
                return this.f24453a.hashCode();
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("NormalClass(value=");
                sbM833U.append(this.f24453a);
                sbM833U.append(')');
                return sbM833U.toString();
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11826r(b bVar) {
        super(bVar);
        C12238m.checkNotNullParameter(bVar, "value");
    }

    public final AbstractC11913c0 getArgumentType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        b value = getValue();
        if (value instanceof b.a) {
            return ((b.a) getValue()).getType();
        }
        if (!(value instanceof b.C13329b)) {
            throw new NoWhenBranchMatchedException();
        }
        C11814f value2 = ((b.C13329b) getValue()).getValue();
        C11712a c11712aComponent1 = value2.component1();
        int iComponent2 = value2.component2();
        InterfaceC11330e interfaceC11330eFindClassAcrossModuleDependencies = C11470w.findClassAcrossModuleDependencies(interfaceC11325c0, c11712aComponent1);
        if (interfaceC11330eFindClassAcrossModuleDependencies == null) {
            AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType("Unresolved type: " + c11712aComponent1 + " (arrayDimensions=" + iComponent2 + ')');
            C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
            return abstractC11934j0CreateErrorType;
        }
        AbstractC11934j0 defaultType = interfaceC11330eFindClassAcrossModuleDependencies.getDefaultType();
        C12238m.checkNotNullExpressionValue(defaultType, "descriptor.defaultType");
        AbstractC11913c0 abstractC11913c0ReplaceArgumentsWithStarProjections = C11992a.replaceArgumentsWithStarProjections(defaultType);
        for (int i = 0; i < iComponent2; i++) {
            abstractC11913c0ReplaceArgumentsWithStarProjections = interfaceC11325c0.getBuiltIns().getArrayType(EnumC11935j1.INVARIANT, abstractC11913c0ReplaceArgumentsWithStarProjections);
            C12238m.checkNotNullExpressionValue(abstractC11913c0ReplaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
        }
        return abstractC11913c0ReplaceArgumentsWithStarProjections;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public AbstractC11913c0 getType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C11916d0 c11916d0 = C11916d0.f24748a;
        InterfaceC11344g empty = InterfaceC11344g.f22735f.getEMPTY();
        InterfaceC11330e kClass = interfaceC11325c0.getBuiltIns().getKClass();
        C12238m.checkNotNullExpressionValue(kClass, "module.builtIns.kClass");
        return C11916d0.simpleNotNullType(empty, kClass, C12145m.listOf(new C12016y0(getArgumentType(interfaceC11325c0))));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11826r(C11814f c11814f) {
        this(new b.C13329b(c11814f));
        C12238m.checkNotNullParameter(c11814f, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11826r(C11712a c11712a, int i) {
        this(new C11814f(c11712a, i));
        C12238m.checkNotNullParameter(c11712a, "classId");
    }
}
