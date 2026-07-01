package d0.e0.p.d;

import b.d.b.a.outline;
import d0.e0.KClass;
import d0.e0.KTypeParameter;
import d0.e0.KVariance;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.k1.a.ReflectKotlinClass2;
import d0.e0.p.d.m0.e.b.JvmPackagePartSource;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Iterables2;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import d0.z.d.TypeParameterReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.p.d.y, reason: use source file name */
/* JADX INFO: compiled from: KTypeParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KTypeParameterImpl implements KTypeParameter {
    public static final /* synthetic */ KProperty[] j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    public final ReflectProperties.a k;
    public final KTypeParameterOwnerImpl l;
    public final TypeParameterDescriptor m;

    /* JADX INFO: renamed from: d0.e0.p.d.y$a */
    /* JADX INFO: compiled from: KTypeParameterImpl.kt */
    public static final class a extends Lambda implements Function0<List<? extends KTypeImpl>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KTypeImpl> invoke() {
            List<KotlinType> upperBounds = KTypeParameterImpl.this.getDescriptor().getUpperBounds();
            Intrinsics3.checkNotNullExpressionValue(upperBounds, "descriptor.upperBounds");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(upperBounds, 10));
            Iterator<T> it = upperBounds.iterator();
            while (it.hasNext()) {
                arrayList.add(new KTypeImpl((KotlinType) it.next(), null, 2, null));
            }
            return arrayList;
        }
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor typeParameterDescriptor) {
        Class<?> klass;
        KClassImpl<?> kClassImplA;
        Object objAccept;
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "descriptor");
        this.m = typeParameterDescriptor;
        this.k = ReflectProperties.lazySoft(new a());
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                objAccept = a((ClassDescriptor) containingDeclaration);
            } else {
                if (!(containingDeclaration instanceof CallableMemberDescriptor)) {
                    throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
                }
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                Intrinsics3.checkNotNullExpressionValue(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImplA = a((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor3 deserializedMemberDescriptor3 = (DeserializedMemberDescriptor3) (!(containingDeclaration instanceof DeserializedMemberDescriptor3) ? null : containingDeclaration);
                    if (deserializedMemberDescriptor3 == null) {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                    DeserializedContainerSource2 containerSource = deserializedMemberDescriptor3.getContainerSource();
                    JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) (containerSource instanceof JvmPackagePartSource ? containerSource : null);
                    KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
                    ReflectKotlinClass2 reflectKotlinClass2 = (ReflectKotlinClass2) (knownJvmBinaryClass instanceof ReflectKotlinClass2 ? knownJvmBinaryClass : null);
                    if (reflectKotlinClass2 == null || (klass = reflectKotlinClass2.getKlass()) == null) {
                        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor3);
                    }
                    KClass kotlinClass = JvmClassMapping.getKotlinClass(klass);
                    Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    kClassImplA = (KClassImpl) kotlinClass;
                }
                objAccept = containingDeclaration.accept(new util(kClassImplA), Unit.a);
            }
            Intrinsics3.checkNotNullExpressionValue(objAccept, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) objAccept;
        }
        this.l = kTypeParameterOwnerImpl;
    }

    public final KClassImpl<?> a(ClassDescriptor classDescriptor) {
        Class<?> javaClass = util2.toJavaClass(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? JvmClassMapping.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        StringBuilder sbU = outline.U("Type parameter container is not resolved: ");
        sbU.append(classDescriptor.getContainingDeclaration());
        throw new KotlinReflectionInternalError(sbU.toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            if (Intrinsics3.areEqual(this.l, kTypeParameterImpl.l) && Intrinsics3.areEqual(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    public TypeParameterDescriptor getDescriptor() {
        return this.m;
    }

    @Override // d0.e0.KTypeParameter
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    @Override // d0.e0.KTypeParameter
    public List<KType> getUpperBounds() {
        return (List) this.k.getValue(this, j[0]);
    }

    @Override // d0.e0.KTypeParameter
    public KVariance getVariance() {
        int iOrdinal = getDescriptor().getVariance().ordinal();
        if (iOrdinal == 0) {
            return KVariance.INVARIANT;
        }
        if (iOrdinal == 1) {
            return KVariance.IN;
        }
        if (iOrdinal == 2) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return getName().hashCode() + (this.l.hashCode() * 31);
    }

    public String toString() {
        return TypeParameterReference.j.toString(this);
    }
}
