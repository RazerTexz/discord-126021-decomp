package d0.e0.p.d;

import b.d.b.a.outline;
import d0.e0.KParameter;
import d0.e0.KTypeParameter;
import d0.e0.p.KTypesJvm;
import d0.e0.p.ReflectJvmMapping;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.l0.Caller2;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ParameterDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaCallableMemberDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Iterables2;
import d0.t.MutableCollectionsJVM;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.exceptions;

/* JADX INFO: renamed from: d0.e0.p.d.f, reason: use source file name */
/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    public final ReflectProperties.a<List<Annotation>> j;
    public final ReflectProperties.a<ArrayList<KParameter>> k;
    public final ReflectProperties.a<KTypeImpl> l;
    public final ReflectProperties.a<List<KTypeParameterImpl>> m;

    /* JADX INFO: renamed from: d0.e0.p.d.f$a */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class a extends Lambda implements Function0<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Annotation> invoke() {
            return util2.computeAnnotations(KCallableImpl.this.getDescriptor());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.f$b */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class b extends Lambda implements Function0<ArrayList<KParameter>> {

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$a */
        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return d0.u.a.compareValues(((KParameter) t).getName(), ((KParameter) t2).getName());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class C0374b extends Lambda implements Function0<ParameterDescriptor> {
            public final /* synthetic */ ReceiverParameterDescriptor $instanceReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0374b(ReceiverParameterDescriptor receiverParameterDescriptor) {
                super(0);
                this.$instanceReceiver = receiverParameterDescriptor;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ParameterDescriptor invoke() {
                return this.$instanceReceiver;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$c */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class c extends Lambda implements Function0<ParameterDescriptor> {
            public final /* synthetic */ ReceiverParameterDescriptor $extensionReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(ReceiverParameterDescriptor receiverParameterDescriptor) {
                super(0);
                this.$extensionReceiver = receiverParameterDescriptor;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ParameterDescriptor invoke() {
                return this.$extensionReceiver;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$d */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class d extends Lambda implements Function0<ParameterDescriptor> {
            public final /* synthetic */ CallableMemberDescriptor $descriptor;
            public final /* synthetic */ int $i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(CallableMemberDescriptor callableMemberDescriptor, int i) {
                super(0);
                this.$descriptor = callableMemberDescriptor;
                this.$i = i;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ParameterDescriptor invoke() {
                ValueParameterDescriptor valueParameterDescriptor = this.$descriptor.getValueParameters().get(this.$i);
                Intrinsics3.checkNotNullExpressionValue(valueParameterDescriptor, "descriptor.valueParameters[i]");
                return valueParameterDescriptor;
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ArrayList<KParameter> invoke() {
            int i;
            CallableMemberDescriptor descriptor = KCallableImpl.this.getDescriptor();
            ArrayList<KParameter> arrayList = new ArrayList<>();
            int i2 = 0;
            if (KCallableImpl.this.isBound()) {
                i = 0;
            } else {
                ReceiverParameterDescriptor instanceReceiverParameter = util2.getInstanceReceiverParameter(descriptor);
                if (instanceReceiverParameter != null) {
                    arrayList.add(new KParameterImpl(KCallableImpl.this, 0, KParameter.a.INSTANCE, new C0374b(instanceReceiverParameter)));
                    i = 1;
                } else {
                    i = 0;
                }
                ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                if (extensionReceiverParameter != null) {
                    arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.a.EXTENSION_RECEIVER, new c(extensionReceiverParameter)));
                    i++;
                }
            }
            List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
            Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            int size = valueParameters.size();
            while (i2 < size) {
                arrayList.add(new KParameterImpl(KCallableImpl.this, i, KParameter.a.VALUE, new d(descriptor, i2)));
                i2++;
                i++;
            }
            if (KCallableImpl.this.b() && (descriptor instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                MutableCollectionsJVM.sortWith(arrayList, new a());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.f$c */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class c extends Lambda implements Function0<KTypeImpl> {

        /* JADX INFO: renamed from: d0.e0.p.d.f$c$a */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class a extends Lambda implements Function0<Type> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Type invoke() {
                Type typeAccess$extractContinuationArgument = KCallableImpl.access$extractContinuationArgument(KCallableImpl.this);
                return typeAccess$extractContinuationArgument != null ? typeAccess$extractContinuationArgument : KCallableImpl.this.getCaller().getReturnType();
            }
        }

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KTypeImpl invoke() {
            KotlinType returnType = KCallableImpl.this.getDescriptor().getReturnType();
            Intrinsics3.checkNotNull(returnType);
            Intrinsics3.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
            return new KTypeImpl(returnType, new a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.f$d */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class d extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KTypeParameterImpl> invoke() {
            List<TypeParameterDescriptor> typeParameters = KCallableImpl.this.getDescriptor().getTypeParameters();
            Intrinsics3.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(typeParameters, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : typeParameters) {
                KCallableImpl kCallableImpl = KCallableImpl.this;
                Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
                arrayList.add(new KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
            }
            return arrayList;
        }
    }

    public KCallableImpl() {
        ReflectProperties.a<List<Annotation>> aVarLazySoft = ReflectProperties.lazySoft(new a());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.j = aVarLazySoft;
        ReflectProperties.a<ArrayList<KParameter>> aVarLazySoft2 = ReflectProperties.lazySoft(new b());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.k = aVarLazySoft2;
        ReflectProperties.a<KTypeImpl> aVarLazySoft3 = ReflectProperties.lazySoft(new c());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.l = aVarLazySoft3;
        ReflectProperties.a<List<KTypeParameterImpl>> aVarLazySoft4 = ReflectProperties.lazySoft(new d());
        Intrinsics3.checkNotNullExpressionValue(aVarLazySoft4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.m = aVarLazySoft4;
    }

    public static final Type access$extractContinuationArgument(KCallableImpl kCallableImpl) {
        Type[] lowerBounds;
        CallableMemberDescriptor descriptor = kCallableImpl.getDescriptor();
        if (!(descriptor instanceof FunctionDescriptor)) {
            descriptor = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor) descriptor;
        if (functionDescriptor == null || !functionDescriptor.isSuspend()) {
            return null;
        }
        Object objLastOrNull = _Collections.lastOrNull((List<? extends Object>) kCallableImpl.getCaller().getParameterTypes());
        if (!(objLastOrNull instanceof ParameterizedType)) {
            objLastOrNull = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) objLastOrNull;
        if (!Intrinsics3.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics3.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objSingle = _Arrays.single(actualTypeArguments);
        if (!(objSingle instanceof WildcardType)) {
            objSingle = null;
        }
        WildcardType wildcardType = (WildcardType) objSingle;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) _Arrays.first(lowerBounds);
    }

    public final Object a(KType kType) {
        Class javaClass = JvmClassMapping.getJavaClass(KTypesJvm.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object objNewInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics3.checkNotNullExpressionValue(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        StringBuilder sbU = outline.U("Cannot instantiate the default empty array of type ");
        sbU.append(javaClass.getSimpleName());
        sbU.append(", because it is not an array type");
        throw new KotlinReflectionInternalError(sbU.toString());
    }

    public final boolean b() {
        return Intrinsics3.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... objArr) throws exceptions {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new exceptions(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> map) throws exceptions {
        Object objA;
        Intrinsics3.checkNotNullParameter(map, "args");
        if (!b()) {
            return callDefaultMethod$kotlin_reflection(map, null);
        }
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                objA = map.get(kParameter);
                if (objA == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                objA = null;
            } else {
                if (!kParameter.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                objA = a(kParameter.getType());
            }
            arrayList.add(objA);
        }
        Caller2<?> defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            StringBuilder sbU = outline.U("This callable does not support a default call: ");
            sbU.append(getDescriptor());
            throw new KotlinReflectionInternalError(sbU.toString());
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return (R) defaultCaller.call(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e) {
            throw new exceptions(e);
        }
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> map, Continuation<?> continuation) throws exceptions {
        Intrinsics3.checkNotNullParameter(map, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z2) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i2));
                Caller2<?> defaultCaller = getDefaultCaller();
                if (defaultCaller == null) {
                    StringBuilder sbU = outline.U("This callable does not support a default call: ");
                    sbU.append(getDescriptor());
                    throw new KotlinReflectionInternalError(sbU.toString());
                }
                arrayList.addAll(arrayList2);
                arrayList.add(null);
                try {
                    Object[] array2 = arrayList.toArray(new Object[0]);
                    if (array2 != null) {
                        return (R) defaultCaller.call(array2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                } catch (IllegalAccessException e) {
                    throw new exceptions(e);
                }
            }
            KParameter next = it.next();
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.isOptional()) {
                arrayList.add(util2.isInlineClassType(next.getType()) ? null : util2.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(next.getType())));
                i2 = (1 << (i % 32)) | i2;
                z2 = true;
            } else {
                if (!next.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                arrayList.add(a(next.getType()));
            }
            if (next.getKind() == KParameter.a.VALUE) {
                i++;
            }
        }
    }

    @Override // d0.e0.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this.j.invoke();
        Intrinsics3.checkNotNullExpressionValue(listInvoke, "_annotations()");
        return listInvoke;
    }

    public abstract Caller2<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller2<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> arrayListInvoke = this.k.invoke();
        Intrinsics3.checkNotNullExpressionValue(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl kTypeImplInvoke = this.l.invoke();
        Intrinsics3.checkNotNullExpressionValue(kTypeImplInvoke, "_returnType()");
        return kTypeImplInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> listInvoke = this.m.invoke();
        Intrinsics3.checkNotNullExpressionValue(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        DescriptorVisibility2 visibility = getDescriptor().getVisibility();
        Intrinsics3.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return util2.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }
}
