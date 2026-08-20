package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12111j;
import p507d0.EnumC12110i;
import p507d0.p513e0.C11236i;
import p507d0.p513e0.InterfaceC11231d;
import p507d0.p513e0.p514p.C11243a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11423b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;
import p507d0.p592z.p594d.InterfaceC12239n;

/* JADX INFO: renamed from: d0.e0.p.d.x */
/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12058x implements InterfaceC12239n {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f25061j = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C12058x.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C12058x.class), "arguments", "getArguments()Ljava/util/List;"))};

    /* JADX INFO: renamed from: k */
    public final C11251c0.a<Type> f25062k;

    /* JADX INFO: renamed from: l */
    public final C11251c0.a f25063l;

    /* JADX INFO: renamed from: m */
    public final C11251c0.a f25064m;

    /* JADX INFO: renamed from: n */
    public final AbstractC11913c0 f25065n;

    /* JADX INFO: renamed from: d0.e0.p.d.x$a */
    /* JADX INFO: compiled from: KTypeImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends C11236i>> {
        public final /* synthetic */ Function0 $computeJavaType;

        /* JADX INFO: renamed from: d0.e0.p.d.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KTypeImpl.kt */
        public static final class C13342a extends AbstractC12240o implements Function0<Type> {

            /* JADX INFO: renamed from: $i */
            public final /* synthetic */ int f25066$i;
            public final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
            public final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined = null;
            public final /* synthetic */ a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13342a(int i, a aVar, Lazy lazy, KProperty kProperty) {
                super(0);
                this.f25066$i = i;
                this.this$0 = aVar;
                this.$parameterizedTypeArguments$inlined = lazy;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Type invoke() {
                Type javaType = C12058x.this.getJavaType();
                if (javaType instanceof Class) {
                    Class cls = (Class) javaType;
                    Class<?> componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    C12238m.checkNotNullExpressionValue(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                    return componentType;
                }
                if (javaType instanceof GenericArrayType) {
                    if (this.f25066$i == 0) {
                        Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                        C12238m.checkNotNullExpressionValue(genericComponentType, "javaType.genericComponentType");
                        return genericComponentType;
                    }
                    StringBuilder sbM833U = C1643a.m833U("Array type has been queried for a non-0th argument: ");
                    sbM833U.append(C12058x.this);
                    throw new C11247a0(sbM833U.toString());
                }
                if (!(javaType instanceof ParameterizedType)) {
                    StringBuilder sbM833U2 = C1643a.m833U("Non-generic type has been queried for arguments: ");
                    sbM833U2.append(C12058x.this);
                    throw new C11247a0(sbM833U2.toString());
                }
                Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.f25066$i);
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    C12238m.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                    Type type2 = (Type) C12141k.firstOrNull(lowerBounds);
                    if (type2 != null) {
                        type = type2;
                    } else {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        C12238m.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                        type = (Type) C12141k.first(upperBounds);
                    }
                }
                C12238m.checkNotNullExpressionValue(type, "if (argument !is Wildcar…ument.upperBounds.first()");
                return type;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.x$a$b */
        /* JADX INFO: compiled from: KTypeImpl.kt */
        public static final class b extends AbstractC12240o implements Function0<List<? extends Type>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Type> invoke() {
                Type javaType = C12058x.this.getJavaType();
                C12238m.checkNotNull(javaType);
                return C11423b.getParameterizedTypeArguments(javaType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.$computeJavaType = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends C11236i> invoke() {
            C11236i c11236iInvariant;
            List<InterfaceC12012w0> arguments = C12058x.this.getType().getArguments();
            if (arguments.isEmpty()) {
                return C12147n.emptyList();
            }
            Lazy lazy = C12083g.lazy(EnumC12110i.PUBLICATION, new b());
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(arguments, 10));
            int i = 0;
            for (Object obj : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    C12147n.throwIndexOverflow();
                }
                InterfaceC12012w0 interfaceC12012w0 = (InterfaceC12012w0) obj;
                if (interfaceC12012w0.isStarProjection()) {
                    c11236iInvariant = C11236i.f22301b.getSTAR();
                } else {
                    AbstractC11913c0 type = interfaceC12012w0.getType();
                    C12238m.checkNotNullExpressionValue(type, "typeProjection.type");
                    C12058x c12058x = new C12058x(type, this.$computeJavaType != null ? new C13342a(i, this, lazy, null) : null);
                    int iOrdinal = interfaceC12012w0.getProjectionKind().ordinal();
                    if (iOrdinal == 0) {
                        c11236iInvariant = C11236i.f22301b.invariant(c12058x);
                    } else if (iOrdinal == 1) {
                        c11236iInvariant = C11236i.f22301b.contravariant(c12058x);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        c11236iInvariant = C11236i.f22301b.covariant(c12058x);
                    }
                }
                arrayList.add(c11236iInvariant);
                i = i2;
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.x$b */
    /* JADX INFO: compiled from: KTypeImpl.kt */
    public static final class b extends AbstractC12240o implements Function0<InterfaceC11231d> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11231d invoke() {
            C12058x c12058x = C12058x.this;
            return c12058x.m10057a(c12058x.getType());
        }
    }

    public C12058x(AbstractC11913c0 abstractC11913c0, Function0<? extends Type> function0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        this.f25065n = abstractC11913c0;
        C11251c0.a<Type> aVarLazySoft = null;
        C11251c0.a<Type> aVar = (C11251c0.a) (!(function0 instanceof C11251c0.a) ? null : function0);
        if (aVar != null) {
            aVarLazySoft = aVar;
        } else if (function0 != null) {
            aVarLazySoft = C11251c0.lazySoft(function0);
        }
        this.f25062k = aVarLazySoft;
        this.f25063l = C11251c0.lazySoft(new b());
        this.f25064m = C11251c0.lazySoft(new a(function0));
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC11231d m10057a(AbstractC11913c0 abstractC11913c0) {
        AbstractC11913c0 type;
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof InterfaceC11330e)) {
            if (declarationDescriptor instanceof InterfaceC11477z0) {
                return new C12059y(null, (InterfaceC11477z0) declarationDescriptor);
            }
            if (declarationDescriptor instanceof InterfaceC11475y0) {
                throw new C12111j(C1643a.m883w("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
            return null;
        }
        Class<?> javaClass = C11265j0.toJavaClass((InterfaceC11330e) declarationDescriptor);
        if (javaClass == null) {
            return null;
        }
        if (!javaClass.isArray()) {
            if (C11920e1.isNullableType(abstractC11913c0)) {
                return new C11260h(javaClass);
            }
            Class<?> primitiveByWrapper = C11423b.getPrimitiveByWrapper(javaClass);
            if (primitiveByWrapper != null) {
                javaClass = primitiveByWrapper;
            }
            return new C11260h(javaClass);
        }
        InterfaceC12012w0 interfaceC12012w0 = (InterfaceC12012w0) C12163u.singleOrNull((List) abstractC11913c0.getArguments());
        if (interfaceC12012w0 == null || (type = interfaceC12012w0.getType()) == null) {
            return new C11260h(javaClass);
        }
        C12238m.checkNotNullExpressionValue(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
        InterfaceC11231d interfaceC11231dM10057a = m10057a(type);
        if (interfaceC11231dM10057a != null) {
            return new C11260h(C11423b.createArrayType(C12209a.getJavaClass(C11243a.getJvmErasure(interfaceC11231dM10057a))));
        }
        throw new C11247a0("Cannot determine classifier for array element type: " + this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C12058x) && C12238m.areEqual(this.f25065n, ((C12058x) obj).f25065n);
    }

    @Override // kotlin.reflect.KType
    public List<C11236i> getArguments() {
        return (List) this.f25064m.getValue(this, f25061j[1]);
    }

    @Override // kotlin.reflect.KType
    public InterfaceC11231d getClassifier() {
        return (InterfaceC11231d) this.f25063l.getValue(this, f25061j[0]);
    }

    @Override // p507d0.p592z.p594d.InterfaceC12239n
    public Type getJavaType() {
        C11251c0.a<Type> aVar = this.f25062k;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public final AbstractC11913c0 getType() {
        return this.f25065n;
    }

    public int hashCode() {
        return this.f25065n.hashCode();
    }

    public String toString() {
        return C11255e0.f22349b.renderType(this.f25065n);
    }

    public /* synthetic */ C12058x(AbstractC11913c0 abstractC11913c0, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(abstractC11913c0, (i & 2) != 0 ? null : function0);
    }
}
