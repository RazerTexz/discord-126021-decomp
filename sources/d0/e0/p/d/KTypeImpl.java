package d0.e0.p.d;

import b.d.b.a.outline;
import d0.Lazy5;
import d0.LazyJVM;
import d0.Standard2;
import d0.e0.KClassifier;
import d0.e0.KTypeProjection;
import d0.e0.p.KTypesJvm;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import d0.z.d.KTypeBase;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
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

/* JADX INFO: renamed from: d0.e0.p.d.x, reason: use source file name */
/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KTypeImpl implements KTypeBase {
    public static final /* synthetic */ KProperty[] j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    public final ReflectProperties.a<Type> k;
    public final ReflectProperties.a l;
    public final ReflectProperties.a m;
    public final KotlinType n;

    /* JADX INFO: renamed from: d0.e0.p.d.x$a */
    /* JADX INFO: compiled from: KTypeImpl.kt */
    public static final class a extends Lambda implements Function0<List<? extends KTypeProjection>> {
        public final /* synthetic */ Function0 $computeJavaType;

        /* JADX INFO: renamed from: d0.e0.p.d.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KTypeImpl.kt */
        public static final class C0419a extends Lambda implements Function0<Type> {
            public final /* synthetic */ int $i;
            public final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
            public final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined = null;
            public final /* synthetic */ a this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0419a(int i, a aVar, Lazy lazy, KProperty kProperty) {
                super(0);
                this.$i = i;
                this.this$0 = aVar;
                this.$parameterizedTypeArguments$inlined = lazy;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Type invoke() {
                Type javaType = KTypeImpl.this.getJavaType();
                if (javaType instanceof Class) {
                    Class cls = (Class) javaType;
                    Class<?> componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    Intrinsics3.checkNotNullExpressionValue(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                    return componentType;
                }
                if (javaType instanceof GenericArrayType) {
                    if (this.$i == 0) {
                        Type genericComponentType = ((GenericArrayType) javaType).getGenericComponentType();
                        Intrinsics3.checkNotNullExpressionValue(genericComponentType, "javaType.genericComponentType");
                        return genericComponentType;
                    }
                    StringBuilder sbU = outline.U("Array type has been queried for a non-0th argument: ");
                    sbU.append(KTypeImpl.this);
                    throw new KotlinReflectionInternalError(sbU.toString());
                }
                if (!(javaType instanceof ParameterizedType)) {
                    StringBuilder sbU2 = outline.U("Non-generic type has been queried for arguments: ");
                    sbU2.append(KTypeImpl.this);
                    throw new KotlinReflectionInternalError(sbU2.toString());
                }
                Type type = (Type) ((List) this.$parameterizedTypeArguments$inlined.getValue()).get(this.$i);
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Intrinsics3.checkNotNullExpressionValue(lowerBounds, "argument.lowerBounds");
                    Type type2 = (Type) _Arrays.firstOrNull(lowerBounds);
                    if (type2 != null) {
                        type = type2;
                    } else {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        Intrinsics3.checkNotNullExpressionValue(upperBounds, "argument.upperBounds");
                        type = (Type) _Arrays.first(upperBounds);
                    }
                }
                Intrinsics3.checkNotNullExpressionValue(type, "if (argument !is Wildcar…ument.upperBounds.first()");
                return type;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.x$a$b */
        /* JADX INFO: compiled from: KTypeImpl.kt */
        public static final class b extends Lambda implements Function0<List<? extends Type>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Type> invoke() {
                Type javaType = KTypeImpl.this.getJavaType();
                Intrinsics3.checkNotNull(javaType);
                return reflectClassUtil.getParameterizedTypeArguments(javaType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.$computeJavaType = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KTypeProjection> invoke() {
            KTypeProjection kTypeProjectionInvariant;
            List<TypeProjection> arguments = KTypeImpl.this.getType().getArguments();
            if (arguments.isEmpty()) {
                return Collections2.emptyList();
            }
            Lazy lazy = LazyJVM.lazy(Lazy5.PUBLICATION, new b());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
            int i = 0;
            for (Object obj : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                TypeProjection typeProjection = (TypeProjection) obj;
                if (typeProjection.isStarProjection()) {
                    kTypeProjectionInvariant = KTypeProjection.f3190b.getSTAR();
                } else {
                    KotlinType type = typeProjection.getType();
                    Intrinsics3.checkNotNullExpressionValue(type, "typeProjection.type");
                    KTypeImpl kTypeImpl = new KTypeImpl(type, this.$computeJavaType != null ? new C0419a(i, this, lazy, null) : null);
                    int iOrdinal = typeProjection.getProjectionKind().ordinal();
                    if (iOrdinal == 0) {
                        kTypeProjectionInvariant = KTypeProjection.f3190b.invariant(kTypeImpl);
                    } else if (iOrdinal == 1) {
                        kTypeProjectionInvariant = KTypeProjection.f3190b.contravariant(kTypeImpl);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        kTypeProjectionInvariant = KTypeProjection.f3190b.covariant(kTypeImpl);
                    }
                }
                arrayList.add(kTypeProjectionInvariant);
                i = i2;
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.x$b */
    /* JADX INFO: compiled from: KTypeImpl.kt */
    public static final class b extends Lambda implements Function0<KClassifier> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KClassifier invoke() {
            KTypeImpl kTypeImpl = KTypeImpl.this;
            return kTypeImpl.a(kTypeImpl.getType());
        }
    }

    public KTypeImpl(KotlinType kotlinType, Function0<? extends Type> function0) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        this.n = kotlinType;
        ReflectProperties.a<Type> aVarLazySoft = null;
        ReflectProperties.a<Type> aVar = (ReflectProperties.a) (!(function0 instanceof ReflectProperties.a) ? null : function0);
        if (aVar != null) {
            aVarLazySoft = aVar;
        } else if (function0 != null) {
            aVarLazySoft = ReflectProperties.lazySoft(function0);
        }
        this.k = aVarLazySoft;
        this.l = ReflectProperties.lazySoft(new b());
        this.m = ReflectProperties.lazySoft(new a(function0));
    }

    public final KClassifier a(KotlinType kotlinType) {
        KotlinType type;
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                return new KTypeParameterImpl(null, (TypeParameterDescriptor) declarationDescriptor);
            }
            if (declarationDescriptor instanceof TypeAliasDescriptor) {
                throw new Standard2(outline.w("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
            return null;
        }
        Class<?> javaClass = util2.toJavaClass((ClassDescriptor) declarationDescriptor);
        if (javaClass == null) {
            return null;
        }
        if (!javaClass.isArray()) {
            if (TypeUtils.isNullableType(kotlinType)) {
                return new KClassImpl(javaClass);
            }
            Class<?> primitiveByWrapper = reflectClassUtil.getPrimitiveByWrapper(javaClass);
            if (primitiveByWrapper != null) {
                javaClass = primitiveByWrapper;
            }
            return new KClassImpl(javaClass);
        }
        TypeProjection typeProjection = (TypeProjection) _Collections.singleOrNull((List) kotlinType.getArguments());
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return new KClassImpl(javaClass);
        }
        Intrinsics3.checkNotNullExpressionValue(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
        KClassifier kClassifierA = a(type);
        if (kClassifierA != null) {
            return new KClassImpl(reflectClassUtil.createArrayType(JvmClassMapping.getJavaClass(KTypesJvm.getJvmErasure(kClassifierA))));
        }
        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof KTypeImpl) && Intrinsics3.areEqual(this.n, ((KTypeImpl) obj).n);
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return (List) this.m.getValue(this, j[1]);
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return (KClassifier) this.l.getValue(this, j[0]);
    }

    @Override // d0.z.d.KTypeBase
    public Type getJavaType() {
        ReflectProperties.a<Type> aVar = this.k;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public final KotlinType getType() {
        return this.n;
    }

    public int hashCode() {
        return this.n.hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.f3197b.renderType(this.n);
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }
}
