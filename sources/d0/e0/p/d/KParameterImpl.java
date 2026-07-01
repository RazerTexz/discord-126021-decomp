package d0.e0.p.d;

import d0.e0.KParameter;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.ParameterDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.p.d.o, reason: use source file name */
/* JADX INFO: compiled from: KParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KParameterImpl implements KParameter {
    public static final /* synthetic */ KProperty[] j = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final ReflectProperties.a k;
    public final KCallableImpl<?> l;
    public final int m;
    public final KParameter.a n;

    /* JADX INFO: renamed from: d0.e0.p.d.o$a */
    /* JADX INFO: compiled from: KParameterImpl.kt */
    public static final class a extends Lambda implements Function0<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Annotation> invoke() {
            return util2.computeAnnotations(KParameterImpl.this.a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.o$b */
    /* JADX INFO: compiled from: KParameterImpl.kt */
    public static final class b extends Lambda implements Function0<Type> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Type invoke() {
            ParameterDescriptor parameterDescriptorA = KParameterImpl.this.a();
            if (!(parameterDescriptorA instanceof ReceiverParameterDescriptor) || !Intrinsics3.areEqual(util2.getInstanceReceiverParameter(KParameterImpl.this.getCallable().getDescriptor()), parameterDescriptorA) || KParameterImpl.this.getCallable().getDescriptor().getKind() != CallableMemberDescriptor.a.FAKE_OVERRIDE) {
                return KParameterImpl.this.getCallable().getCaller().getParameterTypes().get(KParameterImpl.this.getIndex());
            }
            DeclarationDescriptor containingDeclaration = KParameterImpl.this.getCallable().getDescriptor().getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> javaClass = util2.toJavaClass((ClassDescriptor) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + parameterDescriptorA);
        }
    }

    public KParameterImpl(KCallableImpl<?> kCallableImpl, int i, KParameter.a aVar, Function0<? extends ParameterDescriptor> function0) {
        Intrinsics3.checkNotNullParameter(kCallableImpl, "callable");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(function0, "computeDescriptor");
        this.l = kCallableImpl;
        this.m = i;
        this.n = aVar;
        this.k = ReflectProperties.lazySoft(function0);
        ReflectProperties.lazySoft(new a());
    }

    public final ParameterDescriptor a() {
        return (ParameterDescriptor) this.k.getValue(this, j[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            if (Intrinsics3.areEqual(this.l, kParameterImpl.l) && getIndex() == kParameterImpl.getIndex()) {
                return true;
            }
        }
        return false;
    }

    public final KCallableImpl<?> getCallable() {
        return this.l;
    }

    public int getIndex() {
        return this.m;
    }

    @Override // d0.e0.KParameter
    public KParameter.a getKind() {
        return this.n;
    }

    @Override // d0.e0.KParameter
    public String getName() {
        ParameterDescriptor parameterDescriptorA = a();
        if (!(parameterDescriptorA instanceof ValueParameterDescriptor)) {
            parameterDescriptorA = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) parameterDescriptorA;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // d0.e0.KParameter
    public KType getType() {
        KotlinType type = a().getType();
        Intrinsics3.checkNotNullExpressionValue(type, "descriptor.type");
        return new KTypeImpl(type, new b());
    }

    public int hashCode() {
        return Integer.valueOf(getIndex()).hashCode() + (this.l.hashCode() * 31);
    }

    @Override // d0.e0.KParameter
    public boolean isOptional() {
        ParameterDescriptor parameterDescriptorA = a();
        if (!(parameterDescriptorA instanceof ValueParameterDescriptor)) {
            parameterDescriptorA = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) parameterDescriptorA;
        if (valueParameterDescriptor != null) {
            return DescriptorUtils2.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    @Override // d0.e0.KParameter
    public boolean isVararg() {
        ParameterDescriptor parameterDescriptorA = a();
        return (parameterDescriptorA instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) parameterDescriptorA).getVarargElementType() != null;
    }

    public String toString() {
        return ReflectionObjectRenderer.f3197b.renderParameter(this);
    }
}
