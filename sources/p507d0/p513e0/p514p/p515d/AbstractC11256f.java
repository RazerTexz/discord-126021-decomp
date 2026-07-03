package p507d0.p513e0.p514p.p515d;

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
import kotlin.reflect.full.IllegalCallableAccessException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.InterfaceC11233f;
import p507d0.p513e0.InterfaceC11235h;
import p507d0.p513e0.p514p.C11243a;
import p507d0.p513e0.p514p.C11244b;
import p507d0.p513e0.p514p.p515d.C11251c0;
import p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11407k0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11511b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12153q;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.f */
/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11256f<R> implements KCallable<R>, InterfaceC12060z {

    /* JADX INFO: renamed from: j */
    public final C11251c0.a<List<Annotation>> f22352j;

    /* JADX INFO: renamed from: k */
    public final C11251c0.a<ArrayList<InterfaceC11233f>> f22353k;

    /* JADX INFO: renamed from: l */
    public final C11251c0.a<C12058x> f22354l;

    /* JADX INFO: renamed from: m */
    public final C11251c0.a<List<C12059y>> f22355m;

    /* JADX INFO: renamed from: d0.e0.p.d.f$a */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Annotation> invoke() {
            return C11265j0.computeAnnotations(AbstractC11256f.this.getDescriptor());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.f$b */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class b extends AbstractC12240o implements Function0<ArrayList<InterfaceC11233f>> {

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$a */
        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return C12169a.compareValues(((InterfaceC11233f) t).getName(), ((InterfaceC11233f) t2).getName());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class C13301b extends AbstractC12240o implements Function0<InterfaceC11407k0> {
            public final /* synthetic */ InterfaceC11459q0 $instanceReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13301b(InterfaceC11459q0 interfaceC11459q0) {
                super(0);
                this.$instanceReceiver = interfaceC11459q0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11407k0 invoke() {
                return this.$instanceReceiver;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$c */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class c extends AbstractC12240o implements Function0<InterfaceC11407k0> {
            public final /* synthetic */ InterfaceC11459q0 $extensionReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(InterfaceC11459q0 interfaceC11459q0) {
                super(0);
                this.$extensionReceiver = interfaceC11459q0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11407k0 invoke() {
                return this.$extensionReceiver;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.f$b$d */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class d extends AbstractC12240o implements Function0<InterfaceC11407k0> {
            public final /* synthetic */ InterfaceC11321b $descriptor;

            /* JADX INFO: renamed from: $i */
            public final /* synthetic */ int f22356$i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(InterfaceC11321b interfaceC11321b, int i) {
                super(0);
                this.$descriptor = interfaceC11321b;
                this.f22356$i = i;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11407k0 invoke() {
                InterfaceC11326c1 interfaceC11326c1 = this.$descriptor.getValueParameters().get(this.f22356$i);
                C12238m.checkNotNullExpressionValue(interfaceC11326c1, "descriptor.valueParameters[i]");
                return interfaceC11326c1;
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ArrayList<InterfaceC11233f> invoke() {
            int i;
            InterfaceC11321b descriptor = AbstractC11256f.this.getDescriptor();
            ArrayList<InterfaceC11233f> arrayList = new ArrayList<>();
            int i2 = 0;
            if (AbstractC11256f.this.isBound()) {
                i = 0;
            } else {
                InterfaceC11459q0 instanceReceiverParameter = C11265j0.getInstanceReceiverParameter(descriptor);
                if (instanceReceiverParameter != null) {
                    arrayList.add(new C12049o(AbstractC11256f.this, 0, InterfaceC11233f.a.INSTANCE, new C13301b(instanceReceiverParameter)));
                    i = 1;
                } else {
                    i = 0;
                }
                InterfaceC11459q0 extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                if (extensionReceiverParameter != null) {
                    arrayList.add(new C12049o(AbstractC11256f.this, i, InterfaceC11233f.a.EXTENSION_RECEIVER, new c(extensionReceiverParameter)));
                    i++;
                }
            }
            List<InterfaceC11326c1> valueParameters = descriptor.getValueParameters();
            C12238m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            int size = valueParameters.size();
            while (i2 < size) {
                arrayList.add(new C12049o(AbstractC11256f.this, i, InterfaceC11233f.a.VALUE, new d(descriptor, i2)));
                i2++;
                i++;
            }
            if (AbstractC11256f.this.m9337b() && (descriptor instanceof InterfaceC11511b) && arrayList.size() > 1) {
                C12153q.sortWith(arrayList, new a());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.f$c */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class c extends AbstractC12240o implements Function0<C12058x> {

        /* JADX INFO: renamed from: d0.e0.p.d.f$c$a */
        /* JADX INFO: compiled from: KCallableImpl.kt */
        public static final class a extends AbstractC12240o implements Function0<Type> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Type invoke() {
                Type typeAccess$extractContinuationArgument = AbstractC11256f.access$extractContinuationArgument(AbstractC11256f.this);
                return typeAccess$extractContinuationArgument != null ? typeAccess$extractContinuationArgument : AbstractC11256f.this.getCaller().getReturnType();
            }
        }

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C12058x invoke() {
            AbstractC11913c0 returnType = AbstractC11256f.this.getDescriptor().getReturnType();
            C12238m.checkNotNull(returnType);
            C12238m.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
            return new C12058x(returnType, new a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.f$d */
    /* JADX INFO: compiled from: KCallableImpl.kt */
    public static final class d extends AbstractC12240o implements Function0<List<? extends C12059y>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends C12059y> invoke() {
            List<InterfaceC11477z0> typeParameters = AbstractC11256f.this.getDescriptor().getTypeParameters();
            C12238m.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(typeParameters, 10));
            for (InterfaceC11477z0 interfaceC11477z0 : typeParameters) {
                AbstractC11256f abstractC11256f = AbstractC11256f.this;
                C12238m.checkNotNullExpressionValue(interfaceC11477z0, "descriptor");
                arrayList.add(new C12059y(abstractC11256f, interfaceC11477z0));
            }
            return arrayList;
        }
    }

    public AbstractC11256f() {
        C11251c0.a<List<Annotation>> aVarLazySoft = C11251c0.lazySoft(new a());
        C12238m.checkNotNullExpressionValue(aVarLazySoft, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.f22352j = aVarLazySoft;
        C11251c0.a<ArrayList<InterfaceC11233f>> aVarLazySoft2 = C11251c0.lazySoft(new b());
        C12238m.checkNotNullExpressionValue(aVarLazySoft2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.f22353k = aVarLazySoft2;
        C11251c0.a<C12058x> aVarLazySoft3 = C11251c0.lazySoft(new c());
        C12238m.checkNotNullExpressionValue(aVarLazySoft3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.f22354l = aVarLazySoft3;
        C11251c0.a<List<C12059y>> aVarLazySoft4 = C11251c0.lazySoft(new d());
        C12238m.checkNotNullExpressionValue(aVarLazySoft4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.f22355m = aVarLazySoft4;
    }

    public static final Type access$extractContinuationArgument(AbstractC11256f abstractC11256f) {
        Type[] lowerBounds;
        InterfaceC11321b descriptor = abstractC11256f.getDescriptor();
        if (!(descriptor instanceof InterfaceC11472x)) {
            descriptor = null;
        }
        InterfaceC11472x interfaceC11472x = (InterfaceC11472x) descriptor;
        if (interfaceC11472x == null || !interfaceC11472x.isSuspend()) {
            return null;
        }
        Object objLastOrNull = C12163u.lastOrNull((List<? extends Object>) abstractC11256f.getCaller().getParameterTypes());
        if (!(objLastOrNull instanceof ParameterizedType)) {
            objLastOrNull = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) objLastOrNull;
        if (!C12238m.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        C12238m.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objSingle = C12141k.single(actualTypeArguments);
        if (!(objSingle instanceof WildcardType)) {
            objSingle = null;
        }
        WildcardType wildcardType = (WildcardType) objSingle;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) C12141k.first(lowerBounds);
    }

    /* JADX INFO: renamed from: a */
    public final Object m9336a(KType kType) {
        Class javaClass = C12209a.getJavaClass(C11243a.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object objNewInstance = Array.newInstance(javaClass.getComponentType(), 0);
            C12238m.checkNotNullExpressionValue(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        StringBuilder sbM833U = C1643a.m833U("Cannot instantiate the default empty array of type ");
        sbM833U.append(javaClass.getSimpleName());
        sbM833U.append(", because it is not an array type");
        throw new C11247a0(sbM833U.toString());
    }

    /* JADX INFO: renamed from: b */
    public final boolean m9337b() {
        return C12238m.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... objArr) throws IllegalCallableAccessException {
        C12238m.checkNotNullParameter(objArr, "args");
        try {
            return (R) getCaller().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<InterfaceC11233f, ? extends Object> map) throws IllegalCallableAccessException {
        Object objM9336a;
        C12238m.checkNotNullParameter(map, "args");
        if (!m9337b()) {
            return callDefaultMethod$kotlin_reflection(map, null);
        }
        List<InterfaceC11233f> parameters = getParameters();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters, 10));
        for (InterfaceC11233f interfaceC11233f : parameters) {
            if (map.containsKey(interfaceC11233f)) {
                objM9336a = map.get(interfaceC11233f);
                if (objM9336a == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + interfaceC11233f + ')');
                }
            } else if (interfaceC11233f.isOptional()) {
                objM9336a = null;
            } else {
                if (!interfaceC11233f.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + interfaceC11233f);
                }
                objM9336a = m9336a(interfaceC11233f.getType());
            }
            arrayList.add(objM9336a);
        }
        InterfaceC11272d<?> defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            StringBuilder sbM833U = C1643a.m833U("This callable does not support a default call: ");
            sbM833U.append(getDescriptor());
            throw new C11247a0(sbM833U.toString());
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return (R) defaultCaller.call(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    public final R callDefaultMethod$kotlin_reflection(Map<InterfaceC11233f, ? extends Object> map, Continuation<?> continuation) throws IllegalCallableAccessException {
        C12238m.checkNotNullParameter(map, "args");
        List<InterfaceC11233f> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<InterfaceC11233f> it = parameters.iterator();
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
                InterfaceC11272d<?> defaultCaller = getDefaultCaller();
                if (defaultCaller == null) {
                    StringBuilder sbM833U = C1643a.m833U("This callable does not support a default call: ");
                    sbM833U.append(getDescriptor());
                    throw new C11247a0(sbM833U.toString());
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
                    throw new IllegalCallableAccessException(e);
                }
            }
            InterfaceC11233f next = it.next();
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(next)) {
                arrayList.add(map.get(next));
            } else if (next.isOptional()) {
                arrayList.add(C11265j0.isInlineClassType(next.getType()) ? null : C11265j0.defaultPrimitiveValue(C11244b.getJavaType(next.getType())));
                i2 = (1 << (i % 32)) | i2;
                z2 = true;
            } else {
                if (!next.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                arrayList.add(m9336a(next.getType()));
            }
            if (next.getKind() == InterfaceC11233f.a.VALUE) {
                i++;
            }
        }
    }

    @Override // p507d0.p513e0.InterfaceC11229b
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this.f22352j.invoke();
        C12238m.checkNotNullExpressionValue(listInvoke, "_annotations()");
        return listInvoke;
    }

    public abstract InterfaceC11272d<?> getCaller();

    public abstract AbstractC11262i getContainer();

    public abstract InterfaceC11272d<?> getDefaultCaller();

    public abstract InterfaceC11321b getDescriptor();

    @Override // kotlin.reflect.KCallable
    public List<InterfaceC11233f> getParameters() {
        ArrayList<InterfaceC11233f> arrayListInvoke = this.f22353k.invoke();
        C12238m.checkNotNullExpressionValue(arrayListInvoke, "_parameters()");
        return arrayListInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        C12058x c12058xInvoke = this.f22354l.invoke();
        C12238m.checkNotNullExpressionValue(c12058xInvoke, "_returnType()");
        return c12058xInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<InterfaceC11235h> getTypeParameters() {
        List<C12059y> listInvoke = this.f22355m.invoke();
        C12238m.checkNotNullExpressionValue(listInvoke, "_typeParameters()");
        return listInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        AbstractC11466u visibility = getDescriptor().getVisibility();
        C12238m.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return C11265j0.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == EnumC11476z.ABSTRACT;
    }

    public abstract boolean isBound();

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == EnumC11476z.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == EnumC11476z.OPEN;
    }
}
